// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.ExcludeMissing
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.JsonMissing
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.core.toUnmodifiable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects

/** Summary of a score's performance */
@JsonDeserialize(builder = ScoreSummary.Builder::class)
@NoAutoDetect
class ScoreSummary
private constructor(
    private val name: JsonField<String>,
    private val score: JsonField<Double>,
    private val diff: JsonField<Double>,
    private val improvements: JsonField<Long>,
    private val regressions: JsonField<Long>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** Name of the score */
    fun name(): String = name.getRequired("name")

    /** Average score across all examples */
    fun score(): Double = score.getRequired("score")

    /** Difference in score between the current and comparison experiment */
    fun diff(): Double? = diff.getNullable("diff")

    /** Number of improvements in the score */
    fun improvements(): Long = improvements.getRequired("improvements")

    /** Number of regressions in the score */
    fun regressions(): Long = regressions.getRequired("regressions")

    /** Name of the score */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** Average score across all examples */
    @JsonProperty("score") @ExcludeMissing fun _score() = score

    /** Difference in score between the current and comparison experiment */
    @JsonProperty("diff") @ExcludeMissing fun _diff() = diff

    /** Number of improvements in the score */
    @JsonProperty("improvements") @ExcludeMissing fun _improvements() = improvements

    /** Number of regressions in the score */
    @JsonProperty("regressions") @ExcludeMissing fun _regressions() = regressions

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ScoreSummary = apply {
        if (!validated) {
            name()
            score()
            diff()
            improvements()
            regressions()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ScoreSummary &&
            this.name == other.name &&
            this.score == other.score &&
            this.diff == other.diff &&
            this.improvements == other.improvements &&
            this.regressions == other.regressions &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    name,
                    score,
                    diff,
                    improvements,
                    regressions,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ScoreSummary{name=$name, score=$score, diff=$diff, improvements=$improvements, regressions=$regressions, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var score: JsonField<Double> = JsonMissing.of()
        private var diff: JsonField<Double> = JsonMissing.of()
        private var improvements: JsonField<Long> = JsonMissing.of()
        private var regressions: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(scoreSummary: ScoreSummary) = apply {
            this.name = scoreSummary.name
            this.score = scoreSummary.score
            this.diff = scoreSummary.diff
            this.improvements = scoreSummary.improvements
            this.regressions = scoreSummary.regressions
            additionalProperties(scoreSummary.additionalProperties)
        }

        /** Name of the score */
        fun name(name: String) = name(JsonField.of(name))

        /** Name of the score */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Average score across all examples */
        fun score(score: Double) = score(JsonField.of(score))

        /** Average score across all examples */
        @JsonProperty("score")
        @ExcludeMissing
        fun score(score: JsonField<Double>) = apply { this.score = score }

        /** Difference in score between the current and comparison experiment */
        fun diff(diff: Double) = diff(JsonField.of(diff))

        /** Difference in score between the current and comparison experiment */
        @JsonProperty("diff")
        @ExcludeMissing
        fun diff(diff: JsonField<Double>) = apply { this.diff = diff }

        /** Number of improvements in the score */
        fun improvements(improvements: Long) = improvements(JsonField.of(improvements))

        /** Number of improvements in the score */
        @JsonProperty("improvements")
        @ExcludeMissing
        fun improvements(improvements: JsonField<Long>) = apply { this.improvements = improvements }

        /** Number of regressions in the score */
        fun regressions(regressions: Long) = regressions(JsonField.of(regressions))

        /** Number of regressions in the score */
        @JsonProperty("regressions")
        @ExcludeMissing
        fun regressions(regressions: JsonField<Long>) = apply { this.regressions = regressions }

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

        fun build(): ScoreSummary =
            ScoreSummary(
                name,
                score,
                diff,
                improvements,
                regressions,
                additionalProperties.toUnmodifiable(),
            )
    }
}
