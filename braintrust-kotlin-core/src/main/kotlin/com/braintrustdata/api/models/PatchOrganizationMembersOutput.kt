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

@JsonDeserialize(builder = PatchOrganizationMembersOutput.Builder::class)
@NoAutoDetect
class PatchOrganizationMembersOutput
private constructor(
    private val status: JsonField<Status>,
    private val sendEmailError: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun status(): Status = status.getRequired("status")

    /**
     * If invite emails failed to send for some reason, the patch operation will still complete, but
     * we will return an error message here
     */
    fun sendEmailError(): String? = sendEmailError.getNullable("send_email_error")

    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /**
     * If invite emails failed to send for some reason, the patch operation will still complete, but
     * we will return an error message here
     */
    @JsonProperty("send_email_error") @ExcludeMissing fun _sendEmailError() = sendEmailError

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): PatchOrganizationMembersOutput = apply {
        if (!validated) {
            status()
            sendEmailError()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PatchOrganizationMembersOutput &&
            this.status == other.status &&
            this.sendEmailError == other.sendEmailError &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    status,
                    sendEmailError,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "PatchOrganizationMembersOutput{status=$status, sendEmailError=$sendEmailError, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var status: JsonField<Status> = JsonMissing.of()
        private var sendEmailError: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(patchOrganizationMembersOutput: PatchOrganizationMembersOutput) = apply {
            this.status = patchOrganizationMembersOutput.status
            this.sendEmailError = patchOrganizationMembersOutput.sendEmailError
            additionalProperties(patchOrganizationMembersOutput.additionalProperties)
        }

        fun status(status: Status) = status(JsonField.of(status))

        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * If invite emails failed to send for some reason, the patch operation will still complete,
         * but we will return an error message here
         */
        fun sendEmailError(sendEmailError: String) = sendEmailError(JsonField.of(sendEmailError))

        /**
         * If invite emails failed to send for some reason, the patch operation will still complete,
         * but we will return an error message here
         */
        @JsonProperty("send_email_error")
        @ExcludeMissing
        fun sendEmailError(sendEmailError: JsonField<String>) = apply {
            this.sendEmailError = sendEmailError
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

        fun build(): PatchOrganizationMembersOutput =
            PatchOrganizationMembersOutput(
                status,
                sendEmailError,
                additionalProperties.toUnmodifiable(),
            )
    }

    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val SUCCESS = Status(JsonField.of("success"))

            fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            SUCCESS,
        }

        enum class Value {
            SUCCESS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SUCCESS -> Value.SUCCESS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SUCCESS -> Known.SUCCESS
                else -> throw BraintrustInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
