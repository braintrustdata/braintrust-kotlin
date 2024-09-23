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

@JsonDeserialize(builder = Prompt.Builder::class)
@NoAutoDetect
class Prompt private constructor(
  private val id: JsonField<String>,
  private val _xactId: JsonField<String>,
  private val projectId: JsonField<String>,
  private val logId: JsonField<LogId>,
  private val orgId: JsonField<String>,
  private val name: JsonField<String>,
  private val slug: JsonField<String>,
  private val description: JsonField<String>,
  private val created: JsonField<OffsetDateTime>,
  private val promptData: JsonField<PromptData>,
  private val tags: JsonField<List<String>>,
  private val metadata: JsonField<Metadata>,
  private val functionType: JsonField<FunctionType>,
  private val additionalProperties: Map<String, JsonValue>,

) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** Unique identifier for the prompt */
    fun id(): String = id.getRequired("id")

    /**
     * The transaction id of an event is unique to the network operation that processed
     * the event insertion. Transaction ids are monotonically increasing over time and
     * can be used to retrieve a versioned snapshot of the prompt (see the `version`
     * parameter)
     */
    fun _xactId(): String = _xactId.getRequired("_xact_id")

    /** Unique identifier for the project that the prompt belongs under */
    fun projectId(): String = projectId.getRequired("project_id")

    /** A literal 'p' which identifies the object as a project prompt */
    fun logId(): LogId = logId.getRequired("log_id")

    /** Unique identifier for the organization */
    fun orgId(): String = orgId.getRequired("org_id")

    /** Name of the prompt */
    fun name(): String = name.getRequired("name")

    /** Unique identifier for the prompt */
    fun slug(): String = slug.getRequired("slug")

    /** Textual description of the prompt */
    fun description(): String? = description.getNullable("description")

    /** Date of prompt creation */
    fun created(): OffsetDateTime? = created.getNullable("created")

    /** The prompt, model, and its parameters */
    fun promptData(): PromptData? = promptData.getNullable("prompt_data")

    /** A list of tags for the prompt */
    fun tags(): List<String>? = tags.getNullable("tags")

    /** User-controlled metadata about the prompt */
    fun metadata(): Metadata? = metadata.getNullable("metadata")

    fun functionType(): FunctionType? = functionType.getNullable("function_type")

    /** Unique identifier for the prompt */
    @JsonProperty("id")
    @ExcludeMissing
    fun _id() = id

    /**
     * The transaction id of an event is unique to the network operation that processed
     * the event insertion. Transaction ids are monotonically increasing over time and
     * can be used to retrieve a versioned snapshot of the prompt (see the `version`
     * parameter)
     */
    @JsonProperty("_xact_id")
    @ExcludeMissing
    fun __xactId() = _xactId

    /** Unique identifier for the project that the prompt belongs under */
    @JsonProperty("project_id")
    @ExcludeMissing
    fun _projectId() = projectId

    /** A literal 'p' which identifies the object as a project prompt */
    @JsonProperty("log_id")
    @ExcludeMissing
    fun _logId() = logId

    /** Unique identifier for the organization */
    @JsonProperty("org_id")
    @ExcludeMissing
    fun _orgId() = orgId

    /** Name of the prompt */
    @JsonProperty("name")
    @ExcludeMissing
    fun _name() = name

    /** Unique identifier for the prompt */
    @JsonProperty("slug")
    @ExcludeMissing
    fun _slug() = slug

    /** Textual description of the prompt */
    @JsonProperty("description")
    @ExcludeMissing
    fun _description() = description

    /** Date of prompt creation */
    @JsonProperty("created")
    @ExcludeMissing
    fun _created() = created

    /** The prompt, model, and its parameters */
    @JsonProperty("prompt_data")
    @ExcludeMissing
    fun _promptData() = promptData

    /** A list of tags for the prompt */
    @JsonProperty("tags")
    @ExcludeMissing
    fun _tags() = tags

    /** User-controlled metadata about the prompt */
    @JsonProperty("metadata")
    @ExcludeMissing
    fun _metadata() = metadata

    @JsonProperty("function_type")
    @ExcludeMissing
    fun _functionType() = functionType

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Prompt = apply {
        if (!validated) {
          id()
          _xactId()
          projectId()
          logId()
          orgId()
          name()
          slug()
          description()
          created()
          promptData()?.validate()
          tags()
          metadata()?.validate()
          functionType()
          validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is Prompt &&
          this.id == other.id &&
          this._xactId == other._xactId &&
          this.projectId == other.projectId &&
          this.logId == other.logId &&
          this.orgId == other.orgId &&
          this.name == other.name &&
          this.slug == other.slug &&
          this.description == other.description &&
          this.created == other.created &&
          this.promptData == other.promptData &&
          this.tags == other.tags &&
          this.metadata == other.metadata &&
          this.functionType == other.functionType &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      if (hashCode == 0) {
        hashCode = Objects.hash(
            id,
            _xactId,
            projectId,
            logId,
            orgId,
            name,
            slug,
            description,
            created,
            promptData,
            tags,
            metadata,
            functionType,
            additionalProperties,
        )
      }
      return hashCode
    }

    override fun toString() = "Prompt{id=$id, _xactId=$_xactId, projectId=$projectId, logId=$logId, orgId=$orgId, name=$name, slug=$slug, description=$description, created=$created, promptData=$promptData, tags=$tags, metadata=$metadata, functionType=$functionType, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var _xactId: JsonField<String> = JsonMissing.of()
        private var projectId: JsonField<String> = JsonMissing.of()
        private var logId: JsonField<LogId> = JsonMissing.of()
        private var orgId: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var slug: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var created: JsonField<OffsetDateTime> = JsonMissing.of()
        private var promptData: JsonField<PromptData> = JsonMissing.of()
        private var tags: JsonField<List<String>> = JsonMissing.of()
        private var metadata: JsonField<Metadata> = JsonMissing.of()
        private var functionType: JsonField<FunctionType> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(prompt: Prompt) = apply {
            this.id = prompt.id
            this._xactId = prompt._xactId
            this.projectId = prompt.projectId
            this.logId = prompt.logId
            this.orgId = prompt.orgId
            this.name = prompt.name
            this.slug = prompt.slug
            this.description = prompt.description
            this.created = prompt.created
            this.promptData = prompt.promptData
            this.tags = prompt.tags
            this.metadata = prompt.metadata
            this.functionType = prompt.functionType
            additionalProperties(prompt.additionalProperties)
        }

        /** Unique identifier for the prompt */
        fun id(id: String) = id(JsonField.of(id))

        /** Unique identifier for the prompt */
        @JsonProperty("id")
        @ExcludeMissing
        fun id(id: JsonField<String>) = apply {
            this.id = id
        }

        /**
         * The transaction id of an event is unique to the network operation that processed
         * the event insertion. Transaction ids are monotonically increasing over time and
         * can be used to retrieve a versioned snapshot of the prompt (see the `version`
         * parameter)
         */
        fun _xactId(_xactId: String) = _xactId(JsonField.of(_xactId))

        /**
         * The transaction id of an event is unique to the network operation that processed
         * the event insertion. Transaction ids are monotonically increasing over time and
         * can be used to retrieve a versioned snapshot of the prompt (see the `version`
         * parameter)
         */
        @JsonProperty("_xact_id")
        @ExcludeMissing
        fun _xactId(_xactId: JsonField<String>) = apply {
            this._xactId = _xactId
        }

        /** Unique identifier for the project that the prompt belongs under */
        fun projectId(projectId: String) = projectId(JsonField.of(projectId))

        /** Unique identifier for the project that the prompt belongs under */
        @JsonProperty("project_id")
        @ExcludeMissing
        fun projectId(projectId: JsonField<String>) = apply {
            this.projectId = projectId
        }

        /** A literal 'p' which identifies the object as a project prompt */
        fun logId(logId: LogId) = logId(JsonField.of(logId))

        /** A literal 'p' which identifies the object as a project prompt */
        @JsonProperty("log_id")
        @ExcludeMissing
        fun logId(logId: JsonField<LogId>) = apply {
            this.logId = logId
        }

        /** Unique identifier for the organization */
        fun orgId(orgId: String) = orgId(JsonField.of(orgId))

        /** Unique identifier for the organization */
        @JsonProperty("org_id")
        @ExcludeMissing
        fun orgId(orgId: JsonField<String>) = apply {
            this.orgId = orgId
        }

        /** Name of the prompt */
        fun name(name: String) = name(JsonField.of(name))

        /** Name of the prompt */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply {
            this.name = name
        }

        /** Unique identifier for the prompt */
        fun slug(slug: String) = slug(JsonField.of(slug))

        /** Unique identifier for the prompt */
        @JsonProperty("slug")
        @ExcludeMissing
        fun slug(slug: JsonField<String>) = apply {
            this.slug = slug
        }

        /** Textual description of the prompt */
        fun description(description: String) = description(JsonField.of(description))

        /** Textual description of the prompt */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply {
            this.description = description
        }

        /** Date of prompt creation */
        fun created(created: OffsetDateTime) = created(JsonField.of(created))

        /** Date of prompt creation */
        @JsonProperty("created")
        @ExcludeMissing
        fun created(created: JsonField<OffsetDateTime>) = apply {
            this.created = created
        }

        /** The prompt, model, and its parameters */
        fun promptData(promptData: PromptData) = promptData(JsonField.of(promptData))

        /** The prompt, model, and its parameters */
        @JsonProperty("prompt_data")
        @ExcludeMissing
        fun promptData(promptData: JsonField<PromptData>) = apply {
            this.promptData = promptData
        }

        /** A list of tags for the prompt */
        fun tags(tags: List<String>) = tags(JsonField.of(tags))

        /** A list of tags for the prompt */
        @JsonProperty("tags")
        @ExcludeMissing
        fun tags(tags: JsonField<List<String>>) = apply {
            this.tags = tags
        }

        /** User-controlled metadata about the prompt */
        fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

        /** User-controlled metadata about the prompt */
        @JsonProperty("metadata")
        @ExcludeMissing
        fun metadata(metadata: JsonField<Metadata>) = apply {
            this.metadata = metadata
        }

        fun functionType(functionType: FunctionType) = functionType(JsonField.of(functionType))

        @JsonProperty("function_type")
        @ExcludeMissing
        fun functionType(functionType: JsonField<FunctionType>) = apply {
            this.functionType = functionType
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

        fun build(): Prompt = Prompt(
            id,
            _xactId,
            projectId,
            logId,
            orgId,
            name,
            slug,
            description,
            created,
            promptData,
            tags.map { it.toUnmodifiable() },
            metadata,
            functionType,
            additionalProperties.toUnmodifiable(),
        )
    }

    class LogId @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is LogId &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val P = LogId(JsonField.of("p"))

            fun of(value: String) = LogId(JsonField.of(value))
        }

        enum class Known {
            P,
        }

        enum class Value {
            P,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            P -> Value.P
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            P -> Known.P
            else -> throw BraintrustInvalidDataException("Unknown LogId: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }

    class FunctionType @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is FunctionType &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val TASK = FunctionType(JsonField.of("task"))

            val LLM = FunctionType(JsonField.of("llm"))

            val SCORER = FunctionType(JsonField.of("scorer"))

            fun of(value: String) = FunctionType(JsonField.of(value))
        }

        enum class Known {
            TASK,
            LLM,
            SCORER,
        }

        enum class Value {
            TASK,
            LLM,
            SCORER,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            TASK -> Value.TASK
            LLM -> Value.LLM
            SCORER -> Value.SCORER
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            TASK -> Known.TASK
            LLM -> Known.LLM
            SCORER -> Known.SCORER
            else -> throw BraintrustInvalidDataException("Unknown FunctionType: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }

    /** User-controlled metadata about the prompt */
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
