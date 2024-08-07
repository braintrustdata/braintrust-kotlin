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

@JsonDeserialize(builder = ProjectLogInsertResponse.Builder::class)
@NoAutoDetect
class ProjectLogInsertResponse
private constructor(
    private val rowIds: JsonField<List<String>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /**
     * The ids of all rows that were inserted, aligning one-to-one with the rows provided as input
     */
    fun rowIds(): List<String> = rowIds.getRequired("row_ids")

    /**
     * The ids of all rows that were inserted, aligning one-to-one with the rows provided as input
     */
    @JsonProperty("row_ids") @ExcludeMissing fun _rowIds() = rowIds

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ProjectLogInsertResponse = apply {
        if (!validated) {
            rowIds()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectLogInsertResponse &&
            this.rowIds == other.rowIds &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = Objects.hash(rowIds, additionalProperties)
        }
        return hashCode
    }

    override fun toString() =
        "ProjectLogInsertResponse{rowIds=$rowIds, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var rowIds: JsonField<List<String>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(projectLogInsertResponse: ProjectLogInsertResponse) = apply {
            this.rowIds = projectLogInsertResponse.rowIds
            additionalProperties(projectLogInsertResponse.additionalProperties)
        }

        /**
         * The ids of all rows that were inserted, aligning one-to-one with the rows provided as
         * input
         */
        fun rowIds(rowIds: List<String>) = rowIds(JsonField.of(rowIds))

        /**
         * The ids of all rows that were inserted, aligning one-to-one with the rows provided as
         * input
         */
        @JsonProperty("row_ids")
        @ExcludeMissing
        fun rowIds(rowIds: JsonField<List<String>>) = apply { this.rowIds = rowIds }

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

        fun build(): ProjectLogInsertResponse =
            ProjectLogInsertResponse(
                rowIds.map { it.toUnmodifiable() },
                additionalProperties.toUnmodifiable()
            )
    }
}
