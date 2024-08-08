// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.Enum
import com.braintrustdata.api.core.ExcludeMissing
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.JsonMissing
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.core.toUnmodifiable
import com.braintrustdata.api.errors.BraintrustInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects

@JsonDeserialize(builder = FeedbackProjectLogsItem.Builder::class)
@NoAutoDetect
class FeedbackProjectLogsItem
private constructor(
    private val id: JsonField<String>,
    private val scores: JsonField<Scores>,
    private val expected: JsonValue,
    private val comment: JsonField<String>,
    private val metadata: JsonField<Metadata>,
    private val source: JsonField<Source>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /**
     * The id of the project logs event to log feedback for. This is the row `id` returned by `POST
     * /v1/project_logs/{project_id}/insert`
     */
    fun id(): String = id.getRequired("id")

    /**
     * A dictionary of numeric values (between 0 and 1) to log. These scores will be merged into the
     * existing scores for the project logs event
     */
    fun scores(): Scores? = scores.getNullable("scores")

    /**
     * The ground truth value (an arbitrary, JSON serializable object) that you'd compare to
     * `output` to determine if your `output` value is correct or not
     */
    fun expected(): JsonValue = expected

    /** An optional comment string to log about the project logs event */
    fun comment(): String? = comment.getNullable("comment")

    /**
     * A dictionary with additional data about the feedback. If you have a `user_id`, you can log it
     * here and access it in the Braintrust UI.
     */
    fun metadata(): Metadata? = metadata.getNullable("metadata")

    /** The source of the feedback. Must be one of "external" (default), "app", or "api" */
    fun source(): Source? = source.getNullable("source")

    /**
     * The id of the project logs event to log feedback for. This is the row `id` returned by `POST
     * /v1/project_logs/{project_id}/insert`
     */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /**
     * A dictionary of numeric values (between 0 and 1) to log. These scores will be merged into the
     * existing scores for the project logs event
     */
    @JsonProperty("scores") @ExcludeMissing fun _scores() = scores

    /**
     * The ground truth value (an arbitrary, JSON serializable object) that you'd compare to
     * `output` to determine if your `output` value is correct or not
     */
    @JsonProperty("expected") @ExcludeMissing fun _expected() = expected

    /** An optional comment string to log about the project logs event */
    @JsonProperty("comment") @ExcludeMissing fun _comment() = comment

    /**
     * A dictionary with additional data about the feedback. If you have a `user_id`, you can log it
     * here and access it in the Braintrust UI.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata() = metadata

    /** The source of the feedback. Must be one of "external" (default), "app", or "api" */
    @JsonProperty("source") @ExcludeMissing fun _source() = source

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): FeedbackProjectLogsItem = apply {
        if (!validated) {
            id()
            scores()?.validate()
            expected()
            comment()
            metadata()?.validate()
            source()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FeedbackProjectLogsItem &&
            this.id == other.id &&
            this.scores == other.scores &&
            this.expected == other.expected &&
            this.comment == other.comment &&
            this.metadata == other.metadata &&
            this.source == other.source &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    scores,
                    expected,
                    comment,
                    metadata,
                    source,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "FeedbackProjectLogsItem{id=$id, scores=$scores, expected=$expected, comment=$comment, metadata=$metadata, source=$source, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var scores: JsonField<Scores> = JsonMissing.of()
        private var expected: JsonValue = JsonMissing.of()
        private var comment: JsonField<String> = JsonMissing.of()
        private var metadata: JsonField<Metadata> = JsonMissing.of()
        private var source: JsonField<Source> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(feedbackProjectLogsItem: FeedbackProjectLogsItem) = apply {
            this.id = feedbackProjectLogsItem.id
            this.scores = feedbackProjectLogsItem.scores
            this.expected = feedbackProjectLogsItem.expected
            this.comment = feedbackProjectLogsItem.comment
            this.metadata = feedbackProjectLogsItem.metadata
            this.source = feedbackProjectLogsItem.source
            additionalProperties(feedbackProjectLogsItem.additionalProperties)
        }

        /**
         * The id of the project logs event to log feedback for. This is the row `id` returned by
         * `POST /v1/project_logs/{project_id}/insert`
         */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * The id of the project logs event to log feedback for. This is the row `id` returned by
         * `POST /v1/project_logs/{project_id}/insert`
         */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * A dictionary of numeric values (between 0 and 1) to log. These scores will be merged into
         * the existing scores for the project logs event
         */
        fun scores(scores: Scores) = scores(JsonField.of(scores))

        /**
         * A dictionary of numeric values (between 0 and 1) to log. These scores will be merged into
         * the existing scores for the project logs event
         */
        @JsonProperty("scores")
        @ExcludeMissing
        fun scores(scores: JsonField<Scores>) = apply { this.scores = scores }

        /**
         * The ground truth value (an arbitrary, JSON serializable object) that you'd compare to
         * `output` to determine if your `output` value is correct or not
         */
        @JsonProperty("expected")
        @ExcludeMissing
        fun expected(expected: JsonValue) = apply { this.expected = expected }

        /** An optional comment string to log about the project logs event */
        fun comment(comment: String) = comment(JsonField.of(comment))

        /** An optional comment string to log about the project logs event */
        @JsonProperty("comment")
        @ExcludeMissing
        fun comment(comment: JsonField<String>) = apply { this.comment = comment }

        /**
         * A dictionary with additional data about the feedback. If you have a `user_id`, you can
         * log it here and access it in the Braintrust UI.
         */
        fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

        /**
         * A dictionary with additional data about the feedback. If you have a `user_id`, you can
         * log it here and access it in the Braintrust UI.
         */
        @JsonProperty("metadata")
        @ExcludeMissing
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /** The source of the feedback. Must be one of "external" (default), "app", or "api" */
        fun source(source: Source) = source(JsonField.of(source))

        /** The source of the feedback. Must be one of "external" (default), "app", or "api" */
        @JsonProperty("source")
        @ExcludeMissing
        fun source(source: JsonField<Source>) = apply { this.source = source }

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

        fun build(): FeedbackProjectLogsItem =
            FeedbackProjectLogsItem(
                id,
                scores,
                expected,
                comment,
                metadata,
                source,
                additionalProperties.toUnmodifiable(),
            )
    }

    /**
     * A dictionary with additional data about the feedback. If you have a `user_id`, you can log it
     * here and access it in the Braintrust UI.
     */
    @JsonDeserialize(builder = Metadata.Builder::class)
    @NoAutoDetect
    class Metadata
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Metadata = apply {
            if (!validated) {
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Metadata && this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(additionalProperties)
            }
            return hashCode
        }

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(metadata: Metadata) = apply {
                additionalProperties(metadata.additionalProperties)
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

            fun build(): Metadata = Metadata(additionalProperties.toUnmodifiable())
        }
    }

    /**
     * A dictionary of numeric values (between 0 and 1) to log. These scores will be merged into the
     * existing scores for the project logs event
     */
    @JsonDeserialize(builder = Scores.Builder::class)
    @NoAutoDetect
    class Scores
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Scores = apply {
            if (!validated) {
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Scores && this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(additionalProperties)
            }
            return hashCode
        }

        override fun toString() = "Scores{additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(scores: Scores) = apply {
                additionalProperties(scores.additionalProperties)
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

            fun build(): Scores = Scores(additionalProperties.toUnmodifiable())
        }
    }

    class Source
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Source && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val APP = Source(JsonField.of("app"))

            val API = Source(JsonField.of("api"))

            val EXTERNAL = Source(JsonField.of("external"))

            fun of(value: String) = Source(JsonField.of(value))
        }

        enum class Known {
            APP,
            API,
            EXTERNAL,
        }

        enum class Value {
            APP,
            API,
            EXTERNAL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                APP -> Value.APP
                API -> Value.API
                EXTERNAL -> Value.EXTERNAL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                APP -> Known.APP
                API -> Known.API
                EXTERNAL -> Known.EXTERNAL
                else -> throw BraintrustInvalidDataException("Unknown Source: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
