// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Objects
import java.util.Optional
import java.util.Spliterator
import java.util.Spliterators
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import com.braintrustdata.api.core.ExcludeMissing
import com.braintrustdata.api.core.JsonMissing
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.core.toUnmodifiable
import com.braintrustdata.api.models.OrgSecret
import com.braintrustdata.api.services.async.OrgSecretServiceAsync

class OrgSecretListPageAsync private constructor(private val orgSecretService: OrgSecretServiceAsync, private val params: OrgSecretListParams, private val response: Response, ) {

    fun response(): Response = response

    fun objects(): List<OrgSecret> = response().objects()

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is OrgSecretListPageAsync &&
          this.orgSecretService == other.orgSecretService &&
          this.params == other.params &&
          this.response == other.response
    }

    override fun hashCode(): Int {
      return Objects.hash(
          orgSecretService,
          params,
          response,
      )
    }

    override fun toString() = "OrgSecretListPageAsync{orgSecretService=$orgSecretService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
      return !objects().isEmpty()
    }

    fun getNextPageParams(): OrgSecretListParams? {
      if (!hasNextPage()) {
        return null
      }

      return if (params.endingBefore() != null) {
        OrgSecretListParams.builder().from(params).endingBefore(objects().first().id()).build();
      } else {
        OrgSecretListParams.builder().from(params).startingAfter(objects().last().id()).build();
      }
    }

    suspend fun getNextPage(): OrgSecretListPageAsync? {
      return getNextPageParams()?.let {
          orgSecretService.list(it)
      }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(orgSecretService: OrgSecretServiceAsync, params: OrgSecretListParams, response: Response) = OrgSecretListPageAsync(
            orgSecretService,
            params,
            response,
        )
    }

    @JsonDeserialize(builder = Response.Builder::class)
    @NoAutoDetect
    class Response constructor(private val objects: JsonField<List<OrgSecret>>, private val additionalProperties: Map<String, JsonValue>, ) {

        private var validated: Boolean = false

        fun objects(): List<OrgSecret> = objects.getNullable("objects") ?: listOf()

        @JsonProperty("objects")
        fun _objects(): JsonField<List<OrgSecret>>? = objects

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Response = apply {
            if (!validated) {
              objects().map { it.validate() }
              validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Response &&
              this.objects == other.objects &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          return Objects.hash(objects, additionalProperties)
        }

        override fun toString() = "OrgSecretListPageAsync.Response{objects=$objects, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var objects: JsonField<List<OrgSecret>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(page: Response) = apply {
                this.objects = page.objects
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun objects(objects: List<OrgSecret>) = objects(JsonField.of(objects))

            @JsonProperty("objects")
            fun objects(objects: JsonField<List<OrgSecret>>) = apply { this.objects = objects }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(objects, additionalProperties.toUnmodifiable())
        }
    }

    class AutoPager constructor(private val firstPage: OrgSecretListPageAsync, ) : Flow<OrgSecret> {

        override suspend fun collect(collector: FlowCollector<OrgSecret>) {
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
