// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Objects
import java.util.Optional
import java.util.UUID
import com.braintrustdata.api.core.BaseDeserializer
import com.braintrustdata.api.core.BaseSerializer
import com.braintrustdata.api.core.getOrThrow
import com.braintrustdata.api.core.ExcludeMissing
import com.braintrustdata.api.core.JsonMissing
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.Enum
import com.braintrustdata.api.core.toUnmodifiable
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.errors.BraintrustInvalidDataException

@JsonDeserialize(builder = FetchProjectLogsEventsResponse.Builder::class)
@NoAutoDetect
class FetchProjectLogsEventsResponse private constructor(private val events: JsonField<List<ProjectLogsEvent>>, private val cursor: JsonField<String>, private val additionalProperties: Map<String, JsonValue>, ) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** A list of fetched events */
    fun events(): List<ProjectLogsEvent> = events.getRequired("events")

    /**
     * Pagination cursor
     *
     * Pass this string directly as the `cursor` param to your next fetch request to
     * get the next page of results. Not provided if the returned result set is empty.
     */
    fun cursor(): String? = cursor.getNullable("cursor")

    /** A list of fetched events */
    @JsonProperty("events")
    @ExcludeMissing
    fun _events() = events

    /**
     * Pagination cursor
     *
     * Pass this string directly as the `cursor` param to your next fetch request to
     * get the next page of results. Not provided if the returned result set is empty.
     */
    @JsonProperty("cursor")
    @ExcludeMissing
    fun _cursor() = cursor

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): FetchProjectLogsEventsResponse = apply {
        if (!validated) {
          events().forEach { it.validate() }
          cursor()
          validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is FetchProjectLogsEventsResponse &&
          this.events == other.events &&
          this.cursor == other.cursor &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      if (hashCode == 0) {
        hashCode = Objects.hash(
            events,
            cursor,
            additionalProperties,
        )
      }
      return hashCode
    }

    override fun toString() = "FetchProjectLogsEventsResponse{events=$events, cursor=$cursor, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var events: JsonField<List<ProjectLogsEvent>> = JsonMissing.of()
        private var cursor: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(fetchProjectLogsEventsResponse: FetchProjectLogsEventsResponse) = apply {
            this.events = fetchProjectLogsEventsResponse.events
            this.cursor = fetchProjectLogsEventsResponse.cursor
            additionalProperties(fetchProjectLogsEventsResponse.additionalProperties)
        }

        /** A list of fetched events */
        fun events(events: List<ProjectLogsEvent>) = events(JsonField.of(events))

        /** A list of fetched events */
        @JsonProperty("events")
        @ExcludeMissing
        fun events(events: JsonField<List<ProjectLogsEvent>>) = apply {
            this.events = events
        }

        /**
         * Pagination cursor
         *
         * Pass this string directly as the `cursor` param to your next fetch request to
         * get the next page of results. Not provided if the returned result set is empty.
         */
        fun cursor(cursor: String) = cursor(JsonField.of(cursor))

        /**
         * Pagination cursor
         *
         * Pass this string directly as the `cursor` param to your next fetch request to
         * get the next page of results. Not provided if the returned result set is empty.
         */
        @JsonProperty("cursor")
        @ExcludeMissing
        fun cursor(cursor: JsonField<String>) = apply {
            this.cursor = cursor
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): FetchProjectLogsEventsResponse = FetchProjectLogsEventsResponse(
            events.map { it.toUnmodifiable() },
            cursor,
            additionalProperties.toUnmodifiable(),
        )
    }
}
