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

@JsonDeserialize(builder = OrgSecret.Builder::class)
@NoAutoDetect
class OrgSecret private constructor(
  private val id: JsonField<String>,
  private val created: JsonField<OffsetDateTime>,
  private val orgId: JsonField<String>,
  private val name: JsonField<String>,
  private val type: JsonField<String>,
  private val metadata: JsonField<Metadata>,
  private val previewSecret: JsonField<String>,
  private val additionalProperties: Map<String, JsonValue>,

) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** Unique identifier for the org secret */
    fun id(): String = id.getRequired("id")

    /** Date of org secret creation */
    fun created(): OffsetDateTime? = created.getNullable("created")

    /** Unique identifier for the organization */
    fun orgId(): String = orgId.getRequired("org_id")

    /** Name of the org secret */
    fun name(): String = name.getRequired("name")

    fun type(): String? = type.getNullable("type")

    fun metadata(): Metadata? = metadata.getNullable("metadata")

    fun previewSecret(): String? = previewSecret.getNullable("preview_secret")

    /** Unique identifier for the org secret */
    @JsonProperty("id")
    @ExcludeMissing
    fun _id() = id

    /** Date of org secret creation */
    @JsonProperty("created")
    @ExcludeMissing
    fun _created() = created

    /** Unique identifier for the organization */
    @JsonProperty("org_id")
    @ExcludeMissing
    fun _orgId() = orgId

    /** Name of the org secret */
    @JsonProperty("name")
    @ExcludeMissing
    fun _name() = name

    @JsonProperty("type")
    @ExcludeMissing
    fun _type() = type

    @JsonProperty("metadata")
    @ExcludeMissing
    fun _metadata() = metadata

    @JsonProperty("preview_secret")
    @ExcludeMissing
    fun _previewSecret() = previewSecret

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): OrgSecret = apply {
        if (!validated) {
          id()
          created()
          orgId()
          name()
          type()
          metadata()?.validate()
          previewSecret()
          validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is OrgSecret &&
          this.id == other.id &&
          this.created == other.created &&
          this.orgId == other.orgId &&
          this.name == other.name &&
          this.type == other.type &&
          this.metadata == other.metadata &&
          this.previewSecret == other.previewSecret &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      if (hashCode == 0) {
        hashCode = Objects.hash(
            id,
            created,
            orgId,
            name,
            type,
            metadata,
            previewSecret,
            additionalProperties,
        )
      }
      return hashCode
    }

    override fun toString() = "OrgSecret{id=$id, created=$created, orgId=$orgId, name=$name, type=$type, metadata=$metadata, previewSecret=$previewSecret, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var created: JsonField<OffsetDateTime> = JsonMissing.of()
        private var orgId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var metadata: JsonField<Metadata> = JsonMissing.of()
        private var previewSecret: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(orgSecret: OrgSecret) = apply {
            this.id = orgSecret.id
            this.created = orgSecret.created
            this.orgId = orgSecret.orgId
            this.name = orgSecret.name
            this.type = orgSecret.type
            this.metadata = orgSecret.metadata
            this.previewSecret = orgSecret.previewSecret
            additionalProperties(orgSecret.additionalProperties)
        }

        /** Unique identifier for the org secret */
        fun id(id: String) = id(JsonField.of(id))

        /** Unique identifier for the org secret */
        @JsonProperty("id")
        @ExcludeMissing
        fun id(id: JsonField<String>) = apply {
            this.id = id
        }

        /** Date of org secret creation */
        fun created(created: OffsetDateTime) = created(JsonField.of(created))

        /** Date of org secret creation */
        @JsonProperty("created")
        @ExcludeMissing
        fun created(created: JsonField<OffsetDateTime>) = apply {
            this.created = created
        }

        /** Unique identifier for the organization */
        fun orgId(orgId: String) = orgId(JsonField.of(orgId))

        /** Unique identifier for the organization */
        @JsonProperty("org_id")
        @ExcludeMissing
        fun orgId(orgId: JsonField<String>) = apply {
            this.orgId = orgId
        }

        /** Name of the org secret */
        fun name(name: String) = name(JsonField.of(name))

        /** Name of the org secret */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply {
            this.name = name
        }

        fun type(type: String) = type(JsonField.of(type))

        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<String>) = apply {
            this.type = type
        }

        fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

        @JsonProperty("metadata")
        @ExcludeMissing
        fun metadata(metadata: JsonField<Metadata>) = apply {
            this.metadata = metadata
        }

        fun previewSecret(previewSecret: String) = previewSecret(JsonField.of(previewSecret))

        @JsonProperty("preview_secret")
        @ExcludeMissing
        fun previewSecret(previewSecret: JsonField<String>) = apply {
            this.previewSecret = previewSecret
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

        fun build(): OrgSecret = OrgSecret(
            id,
            created,
            orgId,
            name,
            type,
            metadata,
            previewSecret,
            additionalProperties.toUnmodifiable(),
        )
    }

    @JsonDeserialize(builder = Metadata.Builder::class)
    @NoAutoDetect
    class Metadata private constructor(private val additionalProperties: Map<String, JsonValue>, ) {

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

          return other is Metadata &&
              this.additionalProperties == other.additionalProperties
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
}
