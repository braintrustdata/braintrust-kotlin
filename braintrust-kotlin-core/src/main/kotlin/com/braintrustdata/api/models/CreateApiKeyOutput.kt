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
import java.time.OffsetDateTime
import java.util.Objects

@JsonDeserialize(builder = CreateApiKeyOutput.Builder::class)
@NoAutoDetect
class CreateApiKeyOutput
private constructor(
    private val id: JsonField<String>,
    private val created: JsonField<OffsetDateTime>,
    private val name: JsonField<String>,
    private val previewName: JsonField<String>,
    private val userId: JsonField<String>,
    private val orgId: JsonField<String>,
    private val key: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** Unique identifier for the api key */
    fun id(): String = id.getRequired("id")

    /** Date of api key creation */
    fun created(): OffsetDateTime? = created.getNullable("created")

    /** Name of the api key */
    fun name(): String = name.getRequired("name")

    fun previewName(): String = previewName.getRequired("preview_name")

    /** Unique identifier for the user */
    fun userId(): String? = userId.getNullable("user_id")

    /** Unique identifier for the organization */
    fun orgId(): String? = orgId.getNullable("org_id")

    /** The raw API key. It will only be exposed this one time */
    fun key(): String = key.getRequired("key")

    /** Unique identifier for the api key */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** Date of api key creation */
    @JsonProperty("created") @ExcludeMissing fun _created() = created

    /** Name of the api key */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    @JsonProperty("preview_name") @ExcludeMissing fun _previewName() = previewName

    /** Unique identifier for the user */
    @JsonProperty("user_id") @ExcludeMissing fun _userId() = userId

    /** Unique identifier for the organization */
    @JsonProperty("org_id") @ExcludeMissing fun _orgId() = orgId

    /** The raw API key. It will only be exposed this one time */
    @JsonProperty("key") @ExcludeMissing fun _key() = key

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): CreateApiKeyOutput = apply {
        if (!validated) {
            id()
            created()
            name()
            previewName()
            userId()
            orgId()
            key()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var created: JsonField<OffsetDateTime> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var previewName: JsonField<String> = JsonMissing.of()
        private var userId: JsonField<String> = JsonMissing.of()
        private var orgId: JsonField<String> = JsonMissing.of()
        private var key: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(createApiKeyOutput: CreateApiKeyOutput) = apply {
            this.id = createApiKeyOutput.id
            this.created = createApiKeyOutput.created
            this.name = createApiKeyOutput.name
            this.previewName = createApiKeyOutput.previewName
            this.userId = createApiKeyOutput.userId
            this.orgId = createApiKeyOutput.orgId
            this.key = createApiKeyOutput.key
            additionalProperties(createApiKeyOutput.additionalProperties)
        }

        /** Unique identifier for the api key */
        fun id(id: String) = id(JsonField.of(id))

        /** Unique identifier for the api key */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** Date of api key creation */
        fun created(created: OffsetDateTime) = created(JsonField.of(created))

        /** Date of api key creation */
        @JsonProperty("created")
        @ExcludeMissing
        fun created(created: JsonField<OffsetDateTime>) = apply { this.created = created }

        /** Name of the api key */
        fun name(name: String) = name(JsonField.of(name))

        /** Name of the api key */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun previewName(previewName: String) = previewName(JsonField.of(previewName))

        @JsonProperty("preview_name")
        @ExcludeMissing
        fun previewName(previewName: JsonField<String>) = apply { this.previewName = previewName }

        /** Unique identifier for the user */
        fun userId(userId: String) = userId(JsonField.of(userId))

        /** Unique identifier for the user */
        @JsonProperty("user_id")
        @ExcludeMissing
        fun userId(userId: JsonField<String>) = apply { this.userId = userId }

        /** Unique identifier for the organization */
        fun orgId(orgId: String) = orgId(JsonField.of(orgId))

        /** Unique identifier for the organization */
        @JsonProperty("org_id")
        @ExcludeMissing
        fun orgId(orgId: JsonField<String>) = apply { this.orgId = orgId }

        /** The raw API key. It will only be exposed this one time */
        fun key(key: String) = key(JsonField.of(key))

        /** The raw API key. It will only be exposed this one time */
        @JsonProperty("key")
        @ExcludeMissing
        fun key(key: JsonField<String>) = apply { this.key = key }

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

        fun build(): CreateApiKeyOutput =
            CreateApiKeyOutput(
                id,
                created,
                name,
                previewName,
                userId,
                orgId,
                key,
                additionalProperties.toUnmodifiable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CreateApiKeyOutput && this.id == other.id && this.created == other.created && this.name == other.name && this.previewName == other.previewName && this.userId == other.userId && this.orgId == other.orgId && this.key == other.key && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(id, created, name, previewName, userId, orgId, key, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "CreateApiKeyOutput{id=$id, created=$created, name=$name, previewName=$previewName, userId=$userId, orgId=$orgId, key=$key, additionalProperties=$additionalProperties}"
}
