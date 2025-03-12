// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.ExcludeMissing
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.JsonMissing
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.core.immutableEmptyMap
import com.braintrustdata.api.core.toImmutable
import com.braintrustdata.api.models
import com.braintrustdata.api.services.async.SpanIframeServiceAsync
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all span_iframes. The span_iframes are sorted by creation date, with
 * the most recently-created span_iframes coming first
 */
class SpanIframeListPageAsync private constructor(
    private val spanIframesService: SpanIframeServiceAsync,
    private val params: SpanIframeListParams,
    private val response: Response,

) {

    fun response(): Response = response

    fun objects(): List<SpanIFrame> = response().objects()

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is SpanIframeListPageAsync && spanIframesService == other.spanIframesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(spanIframesService, params, response) /* spotless:on */

    override fun toString() = "SpanIframeListPageAsync{spanIframesService=$spanIframesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
      return !objects().isEmpty()
    }

    fun getNextPageParams(): SpanIframeListParams? {
      if (!hasNextPage()) {
        return null
      }

      return if (params.endingBefore() != null) {
        SpanIframeListParams.builder().from(params).endingBefore(objects().first().id()).build();
      } else {
        SpanIframeListParams.builder().from(params).startingAfter(objects().last().id()).build();
      }
    }

    suspend fun getNextPage(): SpanIframeListPageAsync? {
      return getNextPageParams()?.let {
          spanIframesService.list(it)
      }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(spanIframesService: SpanIframeServiceAsync, params: SpanIframeListParams, response: Response) =
            SpanIframeListPageAsync(
              spanIframesService,
              params,
              response,
            )
    }

    @NoAutoDetect
    class Response @JsonCreator constructor(
        @JsonProperty("objects") private val objects: JsonField<List<SpanIFrame>> = JsonMissing.of(),
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        fun objects(): List<SpanIFrame> = objects.getNullable("objects") ?: listOf()

        @JsonProperty("objects")
        fun _objects(): JsonField<List<SpanIFrame>>? = objects

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Response =
            apply {
                if (validated) {
                  return@apply
                }

                objects().map { it.validate() }
                validated = true
            }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return /* spotless:off */ other is Response && objects == other.objects && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(objects, additionalProperties) /* spotless:on */

        override fun toString() = "Response{objects=$objects, additionalProperties=$additionalProperties}"

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of
             * [SpanIframeListPageAsync].
             */
            fun builder() = Builder()
        }

        class Builder {

            private var objects: JsonField<List<SpanIFrame>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(page: Response) =
                apply {
                    this.objects = page.objects
                    this.additionalProperties.putAll(page.additionalProperties)
                }

            fun objects(objects: List<SpanIFrame>) = objects(JsonField.of(objects))

            fun objects(objects: JsonField<List<SpanIFrame>>) = apply { this.objects = objects }

            fun putAdditionalProperty(key: String, value: JsonValue) =
                apply {
                    this.additionalProperties.put(key, value)
                }

            fun build() =
                Response(
                  objects, additionalProperties.toImmutable()
                )
        }
    }

    class AutoPager(
        private val firstPage: SpanIframeListPageAsync,

    ) : Flow<SpanIFrame> {

        override suspend fun collect(collector: FlowCollector<SpanIFrame>) {
          var page = firstPage
          var index = 0
          while (true) {
            while (index < page.objects().size) {
              collector.emit(page.objects()[index++])
            }
            page = page.getNextPage() ?: break
            index = 0
          }
        }
    }
}
