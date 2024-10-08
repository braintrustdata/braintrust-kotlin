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

@JsonDeserialize(builder = ProjectSettings.Builder::class)
@NoAutoDetect
class ProjectSettings
private constructor(
    private val comparisonKey: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The key used to join two experiments (defaults to `input`). */
    fun comparisonKey(): String? = comparisonKey.getNullable("comparison_key")

    /** The key used to join two experiments (defaults to `input`). */
    @JsonProperty("comparison_key") @ExcludeMissing fun _comparisonKey() = comparisonKey

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ProjectSettings = apply {
        if (!validated) {
            comparisonKey()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectSettings &&
            this.comparisonKey == other.comparisonKey &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = Objects.hash(comparisonKey, additionalProperties)
        }
        return hashCode
    }

    override fun toString() =
        "ProjectSettings{comparisonKey=$comparisonKey, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var comparisonKey: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(projectSettings: ProjectSettings) = apply {
            this.comparisonKey = projectSettings.comparisonKey
            additionalProperties(projectSettings.additionalProperties)
        }

        /** The key used to join two experiments (defaults to `input`). */
        fun comparisonKey(comparisonKey: String) = comparisonKey(JsonField.of(comparisonKey))

        /** The key used to join two experiments (defaults to `input`). */
        @JsonProperty("comparison_key")
        @ExcludeMissing
        fun comparisonKey(comparisonKey: JsonField<String>) = apply {
            this.comparisonKey = comparisonKey
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

        fun build(): ProjectSettings =
            ProjectSettings(comparisonKey, additionalProperties.toUnmodifiable())
    }
}
