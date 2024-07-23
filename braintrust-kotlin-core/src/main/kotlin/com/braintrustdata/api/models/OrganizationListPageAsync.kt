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
import com.braintrustdata.api.models.Organization
import com.braintrustdata.api.services.async.OrganizationServiceAsync

class OrganizationListPageAsync private constructor(private val organizationService: OrganizationServiceAsync, private val params: OrganizationListParams, private val response: Response, ) {

    fun response(): Response = response

    fun objects(): List<Organization> = response().objects()

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is OrganizationListPageAsync &&
          this.organizationService == other.organizationService &&
          this.params == other.params &&
          this.response == other.response
    }

    override fun hashCode(): Int {
      return Objects.hash(
          organizationService,
          params,
          response,
      )
    }

    override fun toString() = "OrganizationListPageAsync{organizationService=$organizationService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
      return !objects().isEmpty()
    }

    fun getNextPageParams(): OrganizationListParams? {
      if (!hasNextPage()) {
        return null
      }

      return if (params.endingBefore() != null) {
        OrganizationListParams.builder().from(params).endingBefore(objects().first().id()).build();
      } else {
        OrganizationListParams.builder().from(params).startingAfter(objects().last().id()).build();
      }
    }

    suspend fun getNextPage(): OrganizationListPageAsync? {
      return getNextPageParams()?.let {
          organizationService.list(it)
      }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(organizationService: OrganizationServiceAsync, params: OrganizationListParams, response: Response) = OrganizationListPageAsync(
            organizationService,
            params,
            response,
        )
    }

    @JsonDeserialize(builder = Response.Builder::class)
    @NoAutoDetect
    class Response constructor(private val objects: JsonField<List<Organization>>, private val additionalProperties: Map<String, JsonValue>, ) {

        private var validated: Boolean = false

        fun objects(): List<Organization> = objects.getNullable("objects") ?: listOf()

        @JsonProperty("objects")
        fun _objects(): JsonField<List<Organization>>? = objects

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

        override fun toString() = "OrganizationListPageAsync.Response{objects=$objects, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var objects: JsonField<List<Organization>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(page: Response) = apply {
                this.objects = page.objects
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun objects(objects: List<Organization>) = objects(JsonField.of(objects))

            @JsonProperty("objects")
            fun objects(objects: JsonField<List<Organization>>) = apply { this.objects = objects }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(objects, additionalProperties.toUnmodifiable())
        }
    }

    class AutoPager constructor(private val firstPage: OrganizationListPageAsync, ) : Flow<Organization> {

        override suspend fun collect(collector: FlowCollector<Organization>) {
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