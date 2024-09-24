// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.BaseDeserializer
import com.braintrustdata.api.core.BaseSerializer
import com.braintrustdata.api.core.Enum
import com.braintrustdata.api.core.ExcludeMissing
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.JsonMissing
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.core.getOrThrow
import com.braintrustdata.api.core.toUnmodifiable
import com.braintrustdata.api.errors.BraintrustInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import java.util.Objects

@JsonDeserialize(builder = Function.Builder::class)
@NoAutoDetect
class Function
private constructor(
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
    private val functionData: JsonField<FunctionData>,
    private val origin: JsonField<Origin>,
    private val functionSchema: JsonField<FunctionSchema>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** Unique identifier for the prompt */
    fun id(): String = id.getRequired("id")

    /**
     * The transaction id of an event is unique to the network operation that processed the event
     * insertion. Transaction ids are monotonically increasing over time and can be used to retrieve
     * a versioned snapshot of the prompt (see the `version` parameter)
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

    fun functionData(): FunctionData = functionData.getRequired("function_data")

    fun origin(): Origin? = origin.getNullable("origin")

    /** JSON schema for the function's parameters and return type */
    fun functionSchema(): FunctionSchema? = functionSchema.getNullable("function_schema")

    /** Unique identifier for the prompt */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /**
     * The transaction id of an event is unique to the network operation that processed the event
     * insertion. Transaction ids are monotonically increasing over time and can be used to retrieve
     * a versioned snapshot of the prompt (see the `version` parameter)
     */
    @JsonProperty("_xact_id") @ExcludeMissing fun __xactId() = _xactId

    /** Unique identifier for the project that the prompt belongs under */
    @JsonProperty("project_id") @ExcludeMissing fun _projectId() = projectId

    /** A literal 'p' which identifies the object as a project prompt */
    @JsonProperty("log_id") @ExcludeMissing fun _logId() = logId

    /** Unique identifier for the organization */
    @JsonProperty("org_id") @ExcludeMissing fun _orgId() = orgId

    /** Name of the prompt */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** Unique identifier for the prompt */
    @JsonProperty("slug") @ExcludeMissing fun _slug() = slug

    /** Textual description of the prompt */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /** Date of prompt creation */
    @JsonProperty("created") @ExcludeMissing fun _created() = created

    /** The prompt, model, and its parameters */
    @JsonProperty("prompt_data") @ExcludeMissing fun _promptData() = promptData

    /** A list of tags for the prompt */
    @JsonProperty("tags") @ExcludeMissing fun _tags() = tags

    /** User-controlled metadata about the prompt */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata() = metadata

    @JsonProperty("function_type") @ExcludeMissing fun _functionType() = functionType

    @JsonProperty("function_data") @ExcludeMissing fun _functionData() = functionData

    @JsonProperty("origin") @ExcludeMissing fun _origin() = origin

    /** JSON schema for the function's parameters and return type */
    @JsonProperty("function_schema") @ExcludeMissing fun _functionSchema() = functionSchema

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Function = apply {
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
            functionData()
            origin()?.validate()
            functionSchema()?.validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Function &&
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
            this.functionData == other.functionData &&
            this.origin == other.origin &&
            this.functionSchema == other.functionSchema &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
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
                    functionData,
                    origin,
                    functionSchema,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Function{id=$id, _xactId=$_xactId, projectId=$projectId, logId=$logId, orgId=$orgId, name=$name, slug=$slug, description=$description, created=$created, promptData=$promptData, tags=$tags, metadata=$metadata, functionType=$functionType, functionData=$functionData, origin=$origin, functionSchema=$functionSchema, additionalProperties=$additionalProperties}"

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
        private var functionData: JsonField<FunctionData> = JsonMissing.of()
        private var origin: JsonField<Origin> = JsonMissing.of()
        private var functionSchema: JsonField<FunctionSchema> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(function: Function) = apply {
            this.id = function.id
            this._xactId = function._xactId
            this.projectId = function.projectId
            this.logId = function.logId
            this.orgId = function.orgId
            this.name = function.name
            this.slug = function.slug
            this.description = function.description
            this.created = function.created
            this.promptData = function.promptData
            this.tags = function.tags
            this.metadata = function.metadata
            this.functionType = function.functionType
            this.functionData = function.functionData
            this.origin = function.origin
            this.functionSchema = function.functionSchema
            additionalProperties(function.additionalProperties)
        }

        /** Unique identifier for the prompt */
        fun id(id: String) = id(JsonField.of(id))

        /** Unique identifier for the prompt */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * The transaction id of an event is unique to the network operation that processed the
         * event insertion. Transaction ids are monotonically increasing over time and can be used
         * to retrieve a versioned snapshot of the prompt (see the `version` parameter)
         */
        fun _xactId(_xactId: String) = _xactId(JsonField.of(_xactId))

        /**
         * The transaction id of an event is unique to the network operation that processed the
         * event insertion. Transaction ids are monotonically increasing over time and can be used
         * to retrieve a versioned snapshot of the prompt (see the `version` parameter)
         */
        @JsonProperty("_xact_id")
        @ExcludeMissing
        fun _xactId(_xactId: JsonField<String>) = apply { this._xactId = _xactId }

        /** Unique identifier for the project that the prompt belongs under */
        fun projectId(projectId: String) = projectId(JsonField.of(projectId))

        /** Unique identifier for the project that the prompt belongs under */
        @JsonProperty("project_id")
        @ExcludeMissing
        fun projectId(projectId: JsonField<String>) = apply { this.projectId = projectId }

        /** A literal 'p' which identifies the object as a project prompt */
        fun logId(logId: LogId) = logId(JsonField.of(logId))

        /** A literal 'p' which identifies the object as a project prompt */
        @JsonProperty("log_id")
        @ExcludeMissing
        fun logId(logId: JsonField<LogId>) = apply { this.logId = logId }

        /** Unique identifier for the organization */
        fun orgId(orgId: String) = orgId(JsonField.of(orgId))

        /** Unique identifier for the organization */
        @JsonProperty("org_id")
        @ExcludeMissing
        fun orgId(orgId: JsonField<String>) = apply { this.orgId = orgId }

        /** Name of the prompt */
        fun name(name: String) = name(JsonField.of(name))

        /** Name of the prompt */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Unique identifier for the prompt */
        fun slug(slug: String) = slug(JsonField.of(slug))

        /** Unique identifier for the prompt */
        @JsonProperty("slug")
        @ExcludeMissing
        fun slug(slug: JsonField<String>) = apply { this.slug = slug }

        /** Textual description of the prompt */
        fun description(description: String) = description(JsonField.of(description))

        /** Textual description of the prompt */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Date of prompt creation */
        fun created(created: OffsetDateTime) = created(JsonField.of(created))

        /** Date of prompt creation */
        @JsonProperty("created")
        @ExcludeMissing
        fun created(created: JsonField<OffsetDateTime>) = apply { this.created = created }

        /** The prompt, model, and its parameters */
        fun promptData(promptData: PromptData) = promptData(JsonField.of(promptData))

        /** The prompt, model, and its parameters */
        @JsonProperty("prompt_data")
        @ExcludeMissing
        fun promptData(promptData: JsonField<PromptData>) = apply { this.promptData = promptData }

        /** A list of tags for the prompt */
        fun tags(tags: List<String>) = tags(JsonField.of(tags))

        /** A list of tags for the prompt */
        @JsonProperty("tags")
        @ExcludeMissing
        fun tags(tags: JsonField<List<String>>) = apply { this.tags = tags }

        /** User-controlled metadata about the prompt */
        fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

        /** User-controlled metadata about the prompt */
        @JsonProperty("metadata")
        @ExcludeMissing
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        fun functionType(functionType: FunctionType) = functionType(JsonField.of(functionType))

        @JsonProperty("function_type")
        @ExcludeMissing
        fun functionType(functionType: JsonField<FunctionType>) = apply {
            this.functionType = functionType
        }

        fun functionData(functionData: FunctionData) = functionData(JsonField.of(functionData))

        @JsonProperty("function_data")
        @ExcludeMissing
        fun functionData(functionData: JsonField<FunctionData>) = apply {
            this.functionData = functionData
        }

        fun origin(origin: Origin) = origin(JsonField.of(origin))

        @JsonProperty("origin")
        @ExcludeMissing
        fun origin(origin: JsonField<Origin>) = apply { this.origin = origin }

        /** JSON schema for the function's parameters and return type */
        fun functionSchema(functionSchema: FunctionSchema) =
            functionSchema(JsonField.of(functionSchema))

        /** JSON schema for the function's parameters and return type */
        @JsonProperty("function_schema")
        @ExcludeMissing
        fun functionSchema(functionSchema: JsonField<FunctionSchema>) = apply {
            this.functionSchema = functionSchema
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

        fun build(): Function =
            Function(
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
                functionData,
                origin,
                functionSchema,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(using = FunctionData.Deserializer::class)
    @JsonSerialize(using = FunctionData.Serializer::class)
    class FunctionData
    private constructor(
        private val prompt: Prompt? = null,
        private val code: Code? = null,
        private val global: Global? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        fun prompt(): Prompt? = prompt

        fun code(): Code? = code

        fun global(): Global? = global

        fun isPrompt(): Boolean = prompt != null

        fun isCode(): Boolean = code != null

        fun isGlobal(): Boolean = global != null

        fun asPrompt(): Prompt = prompt.getOrThrow("prompt")

        fun asCode(): Code = code.getOrThrow("code")

        fun asGlobal(): Global = global.getOrThrow("global")

        fun _json(): JsonValue? = _json

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                prompt != null -> visitor.visitPrompt(prompt)
                code != null -> visitor.visitCode(code)
                global != null -> visitor.visitGlobal(global)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): FunctionData = apply {
            if (!validated) {
                if (prompt == null && code == null && global == null) {
                    throw BraintrustInvalidDataException("Unknown FunctionData: $_json")
                }
                prompt?.validate()
                code?.validate()
                global?.validate()
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FunctionData &&
                this.prompt == other.prompt &&
                this.code == other.code &&
                this.global == other.global
        }

        override fun hashCode(): Int {
            return Objects.hash(
                prompt,
                code,
                global,
            )
        }

        override fun toString(): String {
            return when {
                prompt != null -> "FunctionData{prompt=$prompt}"
                code != null -> "FunctionData{code=$code}"
                global != null -> "FunctionData{global=$global}"
                _json != null -> "FunctionData{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid FunctionData")
            }
        }

        companion object {

            fun ofPrompt(prompt: Prompt) = FunctionData(prompt = prompt)

            fun ofCode(code: Code) = FunctionData(code = code)

            fun ofGlobal(global: Global) = FunctionData(global = global)
        }

        interface Visitor<out T> {

            fun visitPrompt(prompt: Prompt): T

            fun visitCode(code: Code): T

            fun visitGlobal(global: Global): T

            fun unknown(json: JsonValue?): T {
                throw BraintrustInvalidDataException("Unknown FunctionData: $json")
            }
        }

        class Deserializer : BaseDeserializer<FunctionData>(FunctionData::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): FunctionData {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<Prompt>()) { it.validate() }
                    ?.let {
                        return FunctionData(prompt = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<Code>()) { it.validate() }
                    ?.let {
                        return FunctionData(code = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<Global>()) { it.validate() }
                    ?.let {
                        return FunctionData(global = it, _json = json)
                    }

                return FunctionData(_json = json)
            }
        }

        class Serializer : BaseSerializer<FunctionData>(FunctionData::class) {

            override fun serialize(
                value: FunctionData,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.prompt != null -> generator.writeObject(value.prompt)
                    value.code != null -> generator.writeObject(value.code)
                    value.global != null -> generator.writeObject(value.global)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid FunctionData")
                }
            }
        }

        @JsonDeserialize(builder = Prompt.Builder::class)
        @NoAutoDetect
        class Prompt
        private constructor(
            private val type: JsonField<Type>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            fun type(): Type = type.getRequired("type")

            @JsonProperty("type") @ExcludeMissing fun _type() = type

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): Prompt = apply {
                if (!validated) {
                    type()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Prompt &&
                    this.type == other.type &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode = Objects.hash(type, additionalProperties)
                }
                return hashCode
            }

            override fun toString() =
                "Prompt{type=$type, additionalProperties=$additionalProperties}"

            companion object {

                fun builder() = Builder()
            }

            class Builder {

                private var type: JsonField<Type> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(prompt: Prompt) = apply {
                    this.type = prompt.type
                    additionalProperties(prompt.additionalProperties)
                }

                fun type(type: Type) = type(JsonField.of(type))

                @JsonProperty("type")
                @ExcludeMissing
                fun type(type: JsonField<Type>) = apply { this.type = type }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    this.additionalProperties.putAll(additionalProperties)
                }

                @JsonAnySetter
                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    this.additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): Prompt = Prompt(type, additionalProperties.toUnmodifiable())
            }

            class Type
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Type && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    val PROMPT = Type(JsonField.of("prompt"))

                    fun of(value: String) = Type(JsonField.of(value))
                }

                enum class Known {
                    PROMPT,
                }

                enum class Value {
                    PROMPT,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        PROMPT -> Value.PROMPT
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        PROMPT -> Known.PROMPT
                        else -> throw BraintrustInvalidDataException("Unknown Type: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }
        }

        @JsonDeserialize(builder = Code.Builder::class)
        @NoAutoDetect
        class Code
        private constructor(
            private val type: JsonField<Type>,
            private val data: JsonField<Data>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            fun type(): Type = type.getRequired("type")

            fun data(): Data = data.getRequired("data")

            @JsonProperty("type") @ExcludeMissing fun _type() = type

            @JsonProperty("data") @ExcludeMissing fun _data() = data

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): Code = apply {
                if (!validated) {
                    type()
                    data()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Code &&
                    this.type == other.type &&
                    this.data == other.data &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            type,
                            data,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "Code{type=$type, data=$data, additionalProperties=$additionalProperties}"

            companion object {

                fun builder() = Builder()
            }

            class Builder {

                private var type: JsonField<Type> = JsonMissing.of()
                private var data: JsonField<Data> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(code: Code) = apply {
                    this.type = code.type
                    this.data = code.data
                    additionalProperties(code.additionalProperties)
                }

                fun type(type: Type) = type(JsonField.of(type))

                @JsonProperty("type")
                @ExcludeMissing
                fun type(type: JsonField<Type>) = apply { this.type = type }

                fun data(data: Data) = data(JsonField.of(data))

                @JsonProperty("data")
                @ExcludeMissing
                fun data(data: JsonField<Data>) = apply { this.data = data }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    this.additionalProperties.putAll(additionalProperties)
                }

                @JsonAnySetter
                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    this.additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): Code =
                    Code(
                        type,
                        data,
                        additionalProperties.toUnmodifiable(),
                    )
            }

            @JsonDeserialize(using = Data.Deserializer::class)
            @JsonSerialize(using = Data.Serializer::class)
            class Data
            private constructor(
                private val bundle: Bundle? = null,
                private val inline: Inline? = null,
                private val _json: JsonValue? = null,
            ) {

                private var validated: Boolean = false

                fun bundle(): Bundle? = bundle

                fun inline(): Inline? = inline

                fun isBundle(): Boolean = bundle != null

                fun isInline(): Boolean = inline != null

                fun asBundle(): Bundle = bundle.getOrThrow("bundle")

                fun asInline(): Inline = inline.getOrThrow("inline")

                fun _json(): JsonValue? = _json

                fun <T> accept(visitor: Visitor<T>): T {
                    return when {
                        bundle != null -> visitor.visitBundle(bundle)
                        inline != null -> visitor.visitInline(inline)
                        else -> visitor.unknown(_json)
                    }
                }

                fun validate(): Data = apply {
                    if (!validated) {
                        if (bundle == null && inline == null) {
                            throw BraintrustInvalidDataException("Unknown Data: $_json")
                        }
                        bundle?.validate()
                        inline?.validate()
                        validated = true
                    }
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Data &&
                        this.bundle == other.bundle &&
                        this.inline == other.inline
                }

                override fun hashCode(): Int {
                    return Objects.hash(bundle, inline)
                }

                override fun toString(): String {
                    return when {
                        bundle != null -> "Data{bundle=$bundle}"
                        inline != null -> "Data{inline=$inline}"
                        _json != null -> "Data{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Data")
                    }
                }

                companion object {

                    fun ofBundle(bundle: Bundle) = Data(bundle = bundle)

                    fun ofInline(inline: Inline) = Data(inline = inline)
                }

                interface Visitor<out T> {

                    fun visitBundle(bundle: Bundle): T

                    fun visitInline(inline: Inline): T

                    fun unknown(json: JsonValue?): T {
                        throw BraintrustInvalidDataException("Unknown Data: $json")
                    }
                }

                class Deserializer : BaseDeserializer<Data>(Data::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Data {
                        val json = JsonValue.fromJsonNode(node)
                        tryDeserialize(node, jacksonTypeRef<Bundle>()) { it.validate() }
                            ?.let {
                                return Data(bundle = it, _json = json)
                            }
                        tryDeserialize(node, jacksonTypeRef<Inline>()) { it.validate() }
                            ?.let {
                                return Data(inline = it, _json = json)
                            }

                        return Data(_json = json)
                    }
                }

                class Serializer : BaseSerializer<Data>(Data::class) {

                    override fun serialize(
                        value: Data,
                        generator: JsonGenerator,
                        provider: SerializerProvider
                    ) {
                        when {
                            value.bundle != null -> generator.writeObject(value.bundle)
                            value.inline != null -> generator.writeObject(value.inline)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Data")
                        }
                    }
                }

                @JsonDeserialize(builder = Bundle.Builder::class)
                @NoAutoDetect
                class Bundle
                private constructor(
                    private val type: JsonField<Type>,
                    private val runtimeContext: JsonField<RuntimeContext>,
                    private val location: JsonField<Location>,
                    private val bundleId: JsonField<String>,
                    private val preview: JsonField<String>,
                    private val additionalProperties: Map<String, JsonValue>,
                ) {

                    private var validated: Boolean = false

                    private var hashCode: Int = 0

                    fun type(): Type = type.getRequired("type")

                    fun runtimeContext(): RuntimeContext =
                        runtimeContext.getRequired("runtime_context")

                    fun location(): Location = location.getRequired("location")

                    fun bundleId(): String = bundleId.getRequired("bundle_id")

                    /** A preview of the code */
                    fun preview(): String? = preview.getNullable("preview")

                    @JsonProperty("type") @ExcludeMissing fun _type() = type

                    @JsonProperty("runtime_context")
                    @ExcludeMissing
                    fun _runtimeContext() = runtimeContext

                    @JsonProperty("location") @ExcludeMissing fun _location() = location

                    @JsonProperty("bundle_id") @ExcludeMissing fun _bundleId() = bundleId

                    /** A preview of the code */
                    @JsonProperty("preview") @ExcludeMissing fun _preview() = preview

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun validate(): Bundle = apply {
                        if (!validated) {
                            type()
                            runtimeContext().validate()
                            location()
                            bundleId()
                            preview()
                            validated = true
                        }
                    }

                    fun toBuilder() = Builder().from(this)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Bundle &&
                            this.type == other.type &&
                            this.runtimeContext == other.runtimeContext &&
                            this.location == other.location &&
                            this.bundleId == other.bundleId &&
                            this.preview == other.preview &&
                            this.additionalProperties == other.additionalProperties
                    }

                    override fun hashCode(): Int {
                        if (hashCode == 0) {
                            hashCode =
                                Objects.hash(
                                    type,
                                    runtimeContext,
                                    location,
                                    bundleId,
                                    preview,
                                    additionalProperties,
                                )
                        }
                        return hashCode
                    }

                    override fun toString() =
                        "Bundle{type=$type, runtimeContext=$runtimeContext, location=$location, bundleId=$bundleId, preview=$preview, additionalProperties=$additionalProperties}"

                    companion object {

                        fun builder() = Builder()
                    }

                    class Builder {

                        private var type: JsonField<Type> = JsonMissing.of()
                        private var runtimeContext: JsonField<RuntimeContext> = JsonMissing.of()
                        private var location: JsonField<Location> = JsonMissing.of()
                        private var bundleId: JsonField<String> = JsonMissing.of()
                        private var preview: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        internal fun from(bundle: Bundle) = apply {
                            this.type = bundle.type
                            this.runtimeContext = bundle.runtimeContext
                            this.location = bundle.location
                            this.bundleId = bundle.bundleId
                            this.preview = bundle.preview
                            additionalProperties(bundle.additionalProperties)
                        }

                        fun type(type: Type) = type(JsonField.of(type))

                        @JsonProperty("type")
                        @ExcludeMissing
                        fun type(type: JsonField<Type>) = apply { this.type = type }

                        fun runtimeContext(runtimeContext: RuntimeContext) =
                            runtimeContext(JsonField.of(runtimeContext))

                        @JsonProperty("runtime_context")
                        @ExcludeMissing
                        fun runtimeContext(runtimeContext: JsonField<RuntimeContext>) = apply {
                            this.runtimeContext = runtimeContext
                        }

                        fun location(location: Location) = location(JsonField.of(location))

                        @JsonProperty("location")
                        @ExcludeMissing
                        fun location(location: JsonField<Location>) = apply {
                            this.location = location
                        }

                        fun bundleId(bundleId: String) = bundleId(JsonField.of(bundleId))

                        @JsonProperty("bundle_id")
                        @ExcludeMissing
                        fun bundleId(bundleId: JsonField<String>) = apply {
                            this.bundleId = bundleId
                        }

                        /** A preview of the code */
                        fun preview(preview: String) = preview(JsonField.of(preview))

                        /** A preview of the code */
                        @JsonProperty("preview")
                        @ExcludeMissing
                        fun preview(preview: JsonField<String>) = apply { this.preview = preview }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                this.additionalProperties.putAll(additionalProperties)
                            }

                        @JsonAnySetter
                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            this.additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun build(): Bundle =
                            Bundle(
                                type,
                                runtimeContext,
                                location,
                                bundleId,
                                preview,
                                additionalProperties.toUnmodifiable(),
                            )
                    }

                    @JsonDeserialize(using = Location.Deserializer::class)
                    @JsonSerialize(using = Location.Serializer::class)
                    class Location
                    private constructor(
                        private val experiment: Experiment? = null,
                        private val function: Function? = null,
                        private val _json: JsonValue? = null,
                    ) {

                        private var validated: Boolean = false

                        fun experiment(): Experiment? = experiment

                        fun function(): Function? = function

                        fun isExperiment(): Boolean = experiment != null

                        fun isFunction(): Boolean = function != null

                        fun asExperiment(): Experiment = experiment.getOrThrow("experiment")

                        fun asFunction(): Function = function.getOrThrow("function")

                        fun _json(): JsonValue? = _json

                        fun <T> accept(visitor: Visitor<T>): T {
                            return when {
                                experiment != null -> visitor.visitExperiment(experiment)
                                function != null -> visitor.visitFunction(function)
                                else -> visitor.unknown(_json)
                            }
                        }

                        fun validate(): Location = apply {
                            if (!validated) {
                                if (experiment == null && function == null) {
                                    throw BraintrustInvalidDataException("Unknown Location: $_json")
                                }
                                experiment?.validate()
                                function?.validate()
                                validated = true
                            }
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Location &&
                                this.experiment == other.experiment &&
                                this.function == other.function
                        }

                        override fun hashCode(): Int {
                            return Objects.hash(experiment, function)
                        }

                        override fun toString(): String {
                            return when {
                                experiment != null -> "Location{experiment=$experiment}"
                                function != null -> "Location{function=$function}"
                                _json != null -> "Location{_unknown=$_json}"
                                else -> throw IllegalStateException("Invalid Location")
                            }
                        }

                        companion object {

                            fun ofExperiment(experiment: Experiment) =
                                Location(experiment = experiment)

                            fun ofFunction(function: Function) = Location(function = function)
                        }

                        interface Visitor<out T> {

                            fun visitExperiment(experiment: Experiment): T

                            fun visitFunction(function: Function): T

                            fun unknown(json: JsonValue?): T {
                                throw BraintrustInvalidDataException("Unknown Location: $json")
                            }
                        }

                        class Deserializer : BaseDeserializer<Location>(Location::class) {

                            override fun ObjectCodec.deserialize(node: JsonNode): Location {
                                val json = JsonValue.fromJsonNode(node)
                                tryDeserialize(node, jacksonTypeRef<Experiment>()) { it.validate() }
                                    ?.let {
                                        return Location(experiment = it, _json = json)
                                    }
                                tryDeserialize(node, jacksonTypeRef<Function>()) { it.validate() }
                                    ?.let {
                                        return Location(function = it, _json = json)
                                    }

                                return Location(_json = json)
                            }
                        }

                        class Serializer : BaseSerializer<Location>(Location::class) {

                            override fun serialize(
                                value: Location,
                                generator: JsonGenerator,
                                provider: SerializerProvider
                            ) {
                                when {
                                    value.experiment != null ->
                                        generator.writeObject(value.experiment)
                                    value.function != null -> generator.writeObject(value.function)
                                    value._json != null -> generator.writeObject(value._json)
                                    else -> throw IllegalStateException("Invalid Location")
                                }
                            }
                        }

                        @JsonDeserialize(builder = Experiment.Builder::class)
                        @NoAutoDetect
                        class Experiment
                        private constructor(
                            private val type: JsonField<Type>,
                            private val evalName: JsonField<String>,
                            private val position: JsonField<Position>,
                            private val additionalProperties: Map<String, JsonValue>,
                        ) {

                            private var validated: Boolean = false

                            private var hashCode: Int = 0

                            fun type(): Type = type.getRequired("type")

                            fun evalName(): String = evalName.getRequired("eval_name")

                            fun position(): Position = position.getRequired("position")

                            @JsonProperty("type") @ExcludeMissing fun _type() = type

                            @JsonProperty("eval_name") @ExcludeMissing fun _evalName() = evalName

                            @JsonProperty("position") @ExcludeMissing fun _position() = position

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            fun validate(): Experiment = apply {
                                if (!validated) {
                                    type()
                                    evalName()
                                    position()
                                    validated = true
                                }
                            }

                            fun toBuilder() = Builder().from(this)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Experiment &&
                                    this.type == other.type &&
                                    this.evalName == other.evalName &&
                                    this.position == other.position &&
                                    this.additionalProperties == other.additionalProperties
                            }

                            override fun hashCode(): Int {
                                if (hashCode == 0) {
                                    hashCode =
                                        Objects.hash(
                                            type,
                                            evalName,
                                            position,
                                            additionalProperties,
                                        )
                                }
                                return hashCode
                            }

                            override fun toString() =
                                "Experiment{type=$type, evalName=$evalName, position=$position, additionalProperties=$additionalProperties}"

                            companion object {

                                fun builder() = Builder()
                            }

                            class Builder {

                                private var type: JsonField<Type> = JsonMissing.of()
                                private var evalName: JsonField<String> = JsonMissing.of()
                                private var position: JsonField<Position> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                internal fun from(experiment: Experiment) = apply {
                                    this.type = experiment.type
                                    this.evalName = experiment.evalName
                                    this.position = experiment.position
                                    additionalProperties(experiment.additionalProperties)
                                }

                                fun type(type: Type) = type(JsonField.of(type))

                                @JsonProperty("type")
                                @ExcludeMissing
                                fun type(type: JsonField<Type>) = apply { this.type = type }

                                fun evalName(evalName: String) = evalName(JsonField.of(evalName))

                                @JsonProperty("eval_name")
                                @ExcludeMissing
                                fun evalName(evalName: JsonField<String>) = apply {
                                    this.evalName = evalName
                                }

                                fun position(position: Position) = position(JsonField.of(position))

                                @JsonProperty("position")
                                @ExcludeMissing
                                fun position(position: JsonField<Position>) = apply {
                                    this.position = position
                                }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
                                    this.additionalProperties.clear()
                                    this.additionalProperties.putAll(additionalProperties)
                                }

                                @JsonAnySetter
                                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                    this.additionalProperties.put(key, value)
                                }

                                fun putAllAdditionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply { this.additionalProperties.putAll(additionalProperties) }

                                fun build(): Experiment =
                                    Experiment(
                                        type,
                                        evalName,
                                        position,
                                        additionalProperties.toUnmodifiable(),
                                    )
                            }

                            @JsonDeserialize(using = Position.Deserializer::class)
                            @JsonSerialize(using = Position.Serializer::class)
                            class Position
                            private constructor(
                                private val type: Type? = null,
                                private val scorer: Scorer? = null,
                                private val _json: JsonValue? = null,
                            ) {

                                private var validated: Boolean = false

                                fun type(): Type? = type

                                fun scorer(): Scorer? = scorer

                                fun isType(): Boolean = type != null

                                fun isScorer(): Boolean = scorer != null

                                fun asType(): Type = type.getOrThrow("type")

                                fun asScorer(): Scorer = scorer.getOrThrow("scorer")

                                fun _json(): JsonValue? = _json

                                fun <T> accept(visitor: Visitor<T>): T {
                                    return when {
                                        type != null -> visitor.visitType(type)
                                        scorer != null -> visitor.visitScorer(scorer)
                                        else -> visitor.unknown(_json)
                                    }
                                }

                                fun validate(): Position = apply {
                                    if (!validated) {
                                        if (type == null && scorer == null) {
                                            throw BraintrustInvalidDataException(
                                                "Unknown Position: $_json"
                                            )
                                        }
                                        type?.validate()
                                        scorer?.validate()
                                        validated = true
                                    }
                                }

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is Position &&
                                        this.type == other.type &&
                                        this.scorer == other.scorer
                                }

                                override fun hashCode(): Int {
                                    return Objects.hash(type, scorer)
                                }

                                override fun toString(): String {
                                    return when {
                                        type != null -> "Position{type=$type}"
                                        scorer != null -> "Position{scorer=$scorer}"
                                        _json != null -> "Position{_unknown=$_json}"
                                        else -> throw IllegalStateException("Invalid Position")
                                    }
                                }

                                companion object {

                                    fun ofType(type: Type) = Position(type = type)

                                    fun ofScorer(scorer: Scorer) = Position(scorer = scorer)
                                }

                                interface Visitor<out T> {

                                    fun visitType(type: Type): T

                                    fun visitScorer(scorer: Scorer): T

                                    fun unknown(json: JsonValue?): T {
                                        throw BraintrustInvalidDataException(
                                            "Unknown Position: $json"
                                        )
                                    }
                                }

                                class Deserializer : BaseDeserializer<Position>(Position::class) {

                                    override fun ObjectCodec.deserialize(node: JsonNode): Position {
                                        val json = JsonValue.fromJsonNode(node)
                                        tryDeserialize(node, jacksonTypeRef<Type>()) {
                                                it.validate()
                                            }
                                            ?.let {
                                                return Position(type = it, _json = json)
                                            }
                                        tryDeserialize(node, jacksonTypeRef<Scorer>()) {
                                                it.validate()
                                            }
                                            ?.let {
                                                return Position(scorer = it, _json = json)
                                            }

                                        return Position(_json = json)
                                    }
                                }

                                class Serializer : BaseSerializer<Position>(Position::class) {

                                    override fun serialize(
                                        value: Position,
                                        generator: JsonGenerator,
                                        provider: SerializerProvider
                                    ) {
                                        when {
                                            value.type != null -> generator.writeObject(value.type)
                                            value.scorer != null ->
                                                generator.writeObject(value.scorer)
                                            value._json != null ->
                                                generator.writeObject(value._json)
                                            else -> throw IllegalStateException("Invalid Position")
                                        }
                                    }
                                }

                                @JsonDeserialize(builder = Type.Builder::class)
                                @NoAutoDetect
                                class Type
                                private constructor(
                                    private val type: JsonField<Type>,
                                    private val additionalProperties: Map<String, JsonValue>,
                                ) {

                                    private var validated: Boolean = false

                                    private var hashCode: Int = 0

                                    fun type(): Type = type.getRequired("type")

                                    @JsonProperty("type") @ExcludeMissing fun _type() = type

                                    @JsonAnyGetter
                                    @ExcludeMissing
                                    fun _additionalProperties(): Map<String, JsonValue> =
                                        additionalProperties

                                    fun validate(): Type = apply {
                                        if (!validated) {
                                            type()
                                            validated = true
                                        }
                                    }

                                    fun toBuilder() = Builder().from(this)

                                    override fun equals(other: Any?): Boolean {
                                        if (this === other) {
                                            return true
                                        }

                                        return other is Type &&
                                            this.type == other.type &&
                                            this.additionalProperties == other.additionalProperties
                                    }

                                    override fun hashCode(): Int {
                                        if (hashCode == 0) {
                                            hashCode = Objects.hash(type, additionalProperties)
                                        }
                                        return hashCode
                                    }

                                    override fun toString() =
                                        "Type{type=$type, additionalProperties=$additionalProperties}"

                                    companion object {

                                        fun builder() = Builder()
                                    }

                                    class Builder {

                                        private var type: JsonField<Type> = JsonMissing.of()
                                        private var additionalProperties:
                                            MutableMap<String, JsonValue> =
                                            mutableMapOf()

                                        internal fun from(type: Type) = apply {
                                            this.type = type.type
                                            additionalProperties(type.additionalProperties)
                                        }

                                        fun type(type: Type) = type(JsonField.of(type))

                                        @JsonProperty("type")
                                        @ExcludeMissing
                                        fun type(type: JsonField<Type>) = apply { this.type = type }

                                        fun additionalProperties(
                                            additionalProperties: Map<String, JsonValue>
                                        ) = apply {
                                            this.additionalProperties.clear()
                                            this.additionalProperties.putAll(additionalProperties)
                                        }

                                        @JsonAnySetter
                                        fun putAdditionalProperty(key: String, value: JsonValue) =
                                            apply {
                                                this.additionalProperties.put(key, value)
                                            }

                                        fun putAllAdditionalProperties(
                                            additionalProperties: Map<String, JsonValue>
                                        ) = apply {
                                            this.additionalProperties.putAll(additionalProperties)
                                        }

                                        fun build(): Type =
                                            Type(type, additionalProperties.toUnmodifiable())
                                    }

                                    class Type
                                    @JsonCreator
                                    private constructor(
                                        private val value: JsonField<String>,
                                    ) : Enum {

                                        @com.fasterxml.jackson.annotation.JsonValue
                                        fun _value(): JsonField<String> = value

                                        override fun equals(other: Any?): Boolean {
                                            if (this === other) {
                                                return true
                                            }

                                            return other is Type && this.value == other.value
                                        }

                                        override fun hashCode() = value.hashCode()

                                        override fun toString() = value.toString()

                                        companion object {

                                            val TASK = Type(JsonField.of("task"))

                                            fun of(value: String) = Type(JsonField.of(value))
                                        }

                                        enum class Known {
                                            TASK,
                                        }

                                        enum class Value {
                                            TASK,
                                            _UNKNOWN,
                                        }

                                        fun value(): Value =
                                            when (this) {
                                                TASK -> Value.TASK
                                                else -> Value._UNKNOWN
                                            }

                                        fun known(): Known =
                                            when (this) {
                                                TASK -> Known.TASK
                                                else ->
                                                    throw BraintrustInvalidDataException(
                                                        "Unknown Type: $value"
                                                    )
                                            }

                                        fun asString(): String = _value().asStringOrThrow()
                                    }
                                }

                                @JsonDeserialize(builder = Scorer.Builder::class)
                                @NoAutoDetect
                                class Scorer
                                private constructor(
                                    private val type: JsonField<Type>,
                                    private val index: JsonField<Long>,
                                    private val additionalProperties: Map<String, JsonValue>,
                                ) {

                                    private var validated: Boolean = false

                                    private var hashCode: Int = 0

                                    fun type(): Type = type.getRequired("type")

                                    fun index(): Long = index.getRequired("index")

                                    @JsonProperty("type") @ExcludeMissing fun _type() = type

                                    @JsonProperty("index") @ExcludeMissing fun _index() = index

                                    @JsonAnyGetter
                                    @ExcludeMissing
                                    fun _additionalProperties(): Map<String, JsonValue> =
                                        additionalProperties

                                    fun validate(): Scorer = apply {
                                        if (!validated) {
                                            type()
                                            index()
                                            validated = true
                                        }
                                    }

                                    fun toBuilder() = Builder().from(this)

                                    override fun equals(other: Any?): Boolean {
                                        if (this === other) {
                                            return true
                                        }

                                        return other is Scorer &&
                                            this.type == other.type &&
                                            this.index == other.index &&
                                            this.additionalProperties == other.additionalProperties
                                    }

                                    override fun hashCode(): Int {
                                        if (hashCode == 0) {
                                            hashCode =
                                                Objects.hash(
                                                    type,
                                                    index,
                                                    additionalProperties,
                                                )
                                        }
                                        return hashCode
                                    }

                                    override fun toString() =
                                        "Scorer{type=$type, index=$index, additionalProperties=$additionalProperties}"

                                    companion object {

                                        fun builder() = Builder()
                                    }

                                    class Builder {

                                        private var type: JsonField<Type> = JsonMissing.of()
                                        private var index: JsonField<Long> = JsonMissing.of()
                                        private var additionalProperties:
                                            MutableMap<String, JsonValue> =
                                            mutableMapOf()

                                        internal fun from(scorer: Scorer) = apply {
                                            this.type = scorer.type
                                            this.index = scorer.index
                                            additionalProperties(scorer.additionalProperties)
                                        }

                                        fun type(type: Type) = type(JsonField.of(type))

                                        @JsonProperty("type")
                                        @ExcludeMissing
                                        fun type(type: JsonField<Type>) = apply { this.type = type }

                                        fun index(index: Long) = index(JsonField.of(index))

                                        @JsonProperty("index")
                                        @ExcludeMissing
                                        fun index(index: JsonField<Long>) = apply {
                                            this.index = index
                                        }

                                        fun additionalProperties(
                                            additionalProperties: Map<String, JsonValue>
                                        ) = apply {
                                            this.additionalProperties.clear()
                                            this.additionalProperties.putAll(additionalProperties)
                                        }

                                        @JsonAnySetter
                                        fun putAdditionalProperty(key: String, value: JsonValue) =
                                            apply {
                                                this.additionalProperties.put(key, value)
                                            }

                                        fun putAllAdditionalProperties(
                                            additionalProperties: Map<String, JsonValue>
                                        ) = apply {
                                            this.additionalProperties.putAll(additionalProperties)
                                        }

                                        fun build(): Scorer =
                                            Scorer(
                                                type,
                                                index,
                                                additionalProperties.toUnmodifiable(),
                                            )
                                    }

                                    class Type
                                    @JsonCreator
                                    private constructor(
                                        private val value: JsonField<String>,
                                    ) : Enum {

                                        @com.fasterxml.jackson.annotation.JsonValue
                                        fun _value(): JsonField<String> = value

                                        override fun equals(other: Any?): Boolean {
                                            if (this === other) {
                                                return true
                                            }

                                            return other is Type && this.value == other.value
                                        }

                                        override fun hashCode() = value.hashCode()

                                        override fun toString() = value.toString()

                                        companion object {

                                            val SCORER = Type(JsonField.of("scorer"))

                                            fun of(value: String) = Type(JsonField.of(value))
                                        }

                                        enum class Known {
                                            SCORER,
                                        }

                                        enum class Value {
                                            SCORER,
                                            _UNKNOWN,
                                        }

                                        fun value(): Value =
                                            when (this) {
                                                SCORER -> Value.SCORER
                                                else -> Value._UNKNOWN
                                            }

                                        fun known(): Known =
                                            when (this) {
                                                SCORER -> Known.SCORER
                                                else ->
                                                    throw BraintrustInvalidDataException(
                                                        "Unknown Type: $value"
                                                    )
                                            }

                                        fun asString(): String = _value().asStringOrThrow()
                                    }
                                }
                            }

                            class Type
                            @JsonCreator
                            private constructor(
                                private val value: JsonField<String>,
                            ) : Enum {

                                @com.fasterxml.jackson.annotation.JsonValue
                                fun _value(): JsonField<String> = value

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is Type && this.value == other.value
                                }

                                override fun hashCode() = value.hashCode()

                                override fun toString() = value.toString()

                                companion object {

                                    val EXPERIMENT = Type(JsonField.of("experiment"))

                                    fun of(value: String) = Type(JsonField.of(value))
                                }

                                enum class Known {
                                    EXPERIMENT,
                                }

                                enum class Value {
                                    EXPERIMENT,
                                    _UNKNOWN,
                                }

                                fun value(): Value =
                                    when (this) {
                                        EXPERIMENT -> Value.EXPERIMENT
                                        else -> Value._UNKNOWN
                                    }

                                fun known(): Known =
                                    when (this) {
                                        EXPERIMENT -> Known.EXPERIMENT
                                        else ->
                                            throw BraintrustInvalidDataException(
                                                "Unknown Type: $value"
                                            )
                                    }

                                fun asString(): String = _value().asStringOrThrow()
                            }
                        }

                        @JsonDeserialize(builder = Function.Builder::class)
                        @NoAutoDetect
                        class Function
                        private constructor(
                            private val type: JsonField<Type>,
                            private val index: JsonField<Long>,
                            private val additionalProperties: Map<String, JsonValue>,
                        ) {

                            private var validated: Boolean = false

                            private var hashCode: Int = 0

                            fun type(): Type = type.getRequired("type")

                            fun index(): Long = index.getRequired("index")

                            @JsonProperty("type") @ExcludeMissing fun _type() = type

                            @JsonProperty("index") @ExcludeMissing fun _index() = index

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            fun validate(): Function = apply {
                                if (!validated) {
                                    type()
                                    index()
                                    validated = true
                                }
                            }

                            fun toBuilder() = Builder().from(this)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Function &&
                                    this.type == other.type &&
                                    this.index == other.index &&
                                    this.additionalProperties == other.additionalProperties
                            }

                            override fun hashCode(): Int {
                                if (hashCode == 0) {
                                    hashCode =
                                        Objects.hash(
                                            type,
                                            index,
                                            additionalProperties,
                                        )
                                }
                                return hashCode
                            }

                            override fun toString() =
                                "Function{type=$type, index=$index, additionalProperties=$additionalProperties}"

                            companion object {

                                fun builder() = Builder()
                            }

                            class Builder {

                                private var type: JsonField<Type> = JsonMissing.of()
                                private var index: JsonField<Long> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                internal fun from(function: Function) = apply {
                                    this.type = function.type
                                    this.index = function.index
                                    additionalProperties(function.additionalProperties)
                                }

                                fun type(type: Type) = type(JsonField.of(type))

                                @JsonProperty("type")
                                @ExcludeMissing
                                fun type(type: JsonField<Type>) = apply { this.type = type }

                                fun index(index: Long) = index(JsonField.of(index))

                                @JsonProperty("index")
                                @ExcludeMissing
                                fun index(index: JsonField<Long>) = apply { this.index = index }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
                                    this.additionalProperties.clear()
                                    this.additionalProperties.putAll(additionalProperties)
                                }

                                @JsonAnySetter
                                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                    this.additionalProperties.put(key, value)
                                }

                                fun putAllAdditionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply { this.additionalProperties.putAll(additionalProperties) }

                                fun build(): Function =
                                    Function(
                                        type,
                                        index,
                                        additionalProperties.toUnmodifiable(),
                                    )
                            }

                            class Type
                            @JsonCreator
                            private constructor(
                                private val value: JsonField<String>,
                            ) : Enum {

                                @com.fasterxml.jackson.annotation.JsonValue
                                fun _value(): JsonField<String> = value

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is Type && this.value == other.value
                                }

                                override fun hashCode() = value.hashCode()

                                override fun toString() = value.toString()

                                companion object {

                                    val FUNCTION = Type(JsonField.of("function"))

                                    fun of(value: String) = Type(JsonField.of(value))
                                }

                                enum class Known {
                                    FUNCTION,
                                }

                                enum class Value {
                                    FUNCTION,
                                    _UNKNOWN,
                                }

                                fun value(): Value =
                                    when (this) {
                                        FUNCTION -> Value.FUNCTION
                                        else -> Value._UNKNOWN
                                    }

                                fun known(): Known =
                                    when (this) {
                                        FUNCTION -> Known.FUNCTION
                                        else ->
                                            throw BraintrustInvalidDataException(
                                                "Unknown Type: $value"
                                            )
                                    }

                                fun asString(): String = _value().asStringOrThrow()
                            }
                        }
                    }

                    @JsonDeserialize(builder = RuntimeContext.Builder::class)
                    @NoAutoDetect
                    class RuntimeContext
                    private constructor(
                        private val runtime: JsonField<Runtime>,
                        private val version: JsonField<String>,
                        private val additionalProperties: Map<String, JsonValue>,
                    ) {

                        private var validated: Boolean = false

                        private var hashCode: Int = 0

                        fun runtime(): Runtime = runtime.getRequired("runtime")

                        fun version(): String = version.getRequired("version")

                        @JsonProperty("runtime") @ExcludeMissing fun _runtime() = runtime

                        @JsonProperty("version") @ExcludeMissing fun _version() = version

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun validate(): RuntimeContext = apply {
                            if (!validated) {
                                runtime()
                                version()
                                validated = true
                            }
                        }

                        fun toBuilder() = Builder().from(this)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is RuntimeContext &&
                                this.runtime == other.runtime &&
                                this.version == other.version &&
                                this.additionalProperties == other.additionalProperties
                        }

                        override fun hashCode(): Int {
                            if (hashCode == 0) {
                                hashCode =
                                    Objects.hash(
                                        runtime,
                                        version,
                                        additionalProperties,
                                    )
                            }
                            return hashCode
                        }

                        override fun toString() =
                            "RuntimeContext{runtime=$runtime, version=$version, additionalProperties=$additionalProperties}"

                        companion object {

                            fun builder() = Builder()
                        }

                        class Builder {

                            private var runtime: JsonField<Runtime> = JsonMissing.of()
                            private var version: JsonField<String> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(runtimeContext: RuntimeContext) = apply {
                                this.runtime = runtimeContext.runtime
                                this.version = runtimeContext.version
                                additionalProperties(runtimeContext.additionalProperties)
                            }

                            fun runtime(runtime: Runtime) = runtime(JsonField.of(runtime))

                            @JsonProperty("runtime")
                            @ExcludeMissing
                            fun runtime(runtime: JsonField<Runtime>) = apply {
                                this.runtime = runtime
                            }

                            fun version(version: String) = version(JsonField.of(version))

                            @JsonProperty("version")
                            @ExcludeMissing
                            fun version(version: JsonField<String>) = apply {
                                this.version = version
                            }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    this.additionalProperties.putAll(additionalProperties)
                                }

                            @JsonAnySetter
                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                this.additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun build(): RuntimeContext =
                                RuntimeContext(
                                    runtime,
                                    version,
                                    additionalProperties.toUnmodifiable(),
                                )
                        }

                        class Runtime
                        @JsonCreator
                        private constructor(
                            private val value: JsonField<String>,
                        ) : Enum {

                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Runtime && this.value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()

                            companion object {

                                val NODE = Runtime(JsonField.of("node"))

                                val PYTHON = Runtime(JsonField.of("python"))

                                fun of(value: String) = Runtime(JsonField.of(value))
                            }

                            enum class Known {
                                NODE,
                                PYTHON,
                            }

                            enum class Value {
                                NODE,
                                PYTHON,
                                _UNKNOWN,
                            }

                            fun value(): Value =
                                when (this) {
                                    NODE -> Value.NODE
                                    PYTHON -> Value.PYTHON
                                    else -> Value._UNKNOWN
                                }

                            fun known(): Known =
                                when (this) {
                                    NODE -> Known.NODE
                                    PYTHON -> Known.PYTHON
                                    else ->
                                        throw BraintrustInvalidDataException(
                                            "Unknown Runtime: $value"
                                        )
                                }

                            fun asString(): String = _value().asStringOrThrow()
                        }
                    }

                    class Type
                    @JsonCreator
                    private constructor(
                        private val value: JsonField<String>,
                    ) : Enum {

                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Type && this.value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()

                        companion object {

                            val BUNDLE = Type(JsonField.of("bundle"))

                            fun of(value: String) = Type(JsonField.of(value))
                        }

                        enum class Known {
                            BUNDLE,
                        }

                        enum class Value {
                            BUNDLE,
                            _UNKNOWN,
                        }

                        fun value(): Value =
                            when (this) {
                                BUNDLE -> Value.BUNDLE
                                else -> Value._UNKNOWN
                            }

                        fun known(): Known =
                            when (this) {
                                BUNDLE -> Known.BUNDLE
                                else -> throw BraintrustInvalidDataException("Unknown Type: $value")
                            }

                        fun asString(): String = _value().asStringOrThrow()
                    }
                }

                @JsonDeserialize(builder = Inline.Builder::class)
                @NoAutoDetect
                class Inline
                private constructor(
                    private val type: JsonField<Type>,
                    private val runtimeContext: JsonField<RuntimeContext>,
                    private val code: JsonField<String>,
                    private val additionalProperties: Map<String, JsonValue>,
                ) {

                    private var validated: Boolean = false

                    private var hashCode: Int = 0

                    fun type(): Type = type.getRequired("type")

                    fun runtimeContext(): RuntimeContext =
                        runtimeContext.getRequired("runtime_context")

                    fun code(): String = code.getRequired("code")

                    @JsonProperty("type") @ExcludeMissing fun _type() = type

                    @JsonProperty("runtime_context")
                    @ExcludeMissing
                    fun _runtimeContext() = runtimeContext

                    @JsonProperty("code") @ExcludeMissing fun _code() = code

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun validate(): Inline = apply {
                        if (!validated) {
                            type()
                            runtimeContext().validate()
                            code()
                            validated = true
                        }
                    }

                    fun toBuilder() = Builder().from(this)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Inline &&
                            this.type == other.type &&
                            this.runtimeContext == other.runtimeContext &&
                            this.code == other.code &&
                            this.additionalProperties == other.additionalProperties
                    }

                    override fun hashCode(): Int {
                        if (hashCode == 0) {
                            hashCode =
                                Objects.hash(
                                    type,
                                    runtimeContext,
                                    code,
                                    additionalProperties,
                                )
                        }
                        return hashCode
                    }

                    override fun toString() =
                        "Inline{type=$type, runtimeContext=$runtimeContext, code=$code, additionalProperties=$additionalProperties}"

                    companion object {

                        fun builder() = Builder()
                    }

                    class Builder {

                        private var type: JsonField<Type> = JsonMissing.of()
                        private var runtimeContext: JsonField<RuntimeContext> = JsonMissing.of()
                        private var code: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        internal fun from(inline: Inline) = apply {
                            this.type = inline.type
                            this.runtimeContext = inline.runtimeContext
                            this.code = inline.code
                            additionalProperties(inline.additionalProperties)
                        }

                        fun type(type: Type) = type(JsonField.of(type))

                        @JsonProperty("type")
                        @ExcludeMissing
                        fun type(type: JsonField<Type>) = apply { this.type = type }

                        fun runtimeContext(runtimeContext: RuntimeContext) =
                            runtimeContext(JsonField.of(runtimeContext))

                        @JsonProperty("runtime_context")
                        @ExcludeMissing
                        fun runtimeContext(runtimeContext: JsonField<RuntimeContext>) = apply {
                            this.runtimeContext = runtimeContext
                        }

                        fun code(code: String) = code(JsonField.of(code))

                        @JsonProperty("code")
                        @ExcludeMissing
                        fun code(code: JsonField<String>) = apply { this.code = code }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                this.additionalProperties.putAll(additionalProperties)
                            }

                        @JsonAnySetter
                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            this.additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun build(): Inline =
                            Inline(
                                type,
                                runtimeContext,
                                code,
                                additionalProperties.toUnmodifiable(),
                            )
                    }

                    @JsonDeserialize(builder = RuntimeContext.Builder::class)
                    @NoAutoDetect
                    class RuntimeContext
                    private constructor(
                        private val runtime: JsonField<Runtime>,
                        private val version: JsonField<String>,
                        private val additionalProperties: Map<String, JsonValue>,
                    ) {

                        private var validated: Boolean = false

                        private var hashCode: Int = 0

                        fun runtime(): Runtime = runtime.getRequired("runtime")

                        fun version(): String = version.getRequired("version")

                        @JsonProperty("runtime") @ExcludeMissing fun _runtime() = runtime

                        @JsonProperty("version") @ExcludeMissing fun _version() = version

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun validate(): RuntimeContext = apply {
                            if (!validated) {
                                runtime()
                                version()
                                validated = true
                            }
                        }

                        fun toBuilder() = Builder().from(this)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is RuntimeContext &&
                                this.runtime == other.runtime &&
                                this.version == other.version &&
                                this.additionalProperties == other.additionalProperties
                        }

                        override fun hashCode(): Int {
                            if (hashCode == 0) {
                                hashCode =
                                    Objects.hash(
                                        runtime,
                                        version,
                                        additionalProperties,
                                    )
                            }
                            return hashCode
                        }

                        override fun toString() =
                            "RuntimeContext{runtime=$runtime, version=$version, additionalProperties=$additionalProperties}"

                        companion object {

                            fun builder() = Builder()
                        }

                        class Builder {

                            private var runtime: JsonField<Runtime> = JsonMissing.of()
                            private var version: JsonField<String> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(runtimeContext: RuntimeContext) = apply {
                                this.runtime = runtimeContext.runtime
                                this.version = runtimeContext.version
                                additionalProperties(runtimeContext.additionalProperties)
                            }

                            fun runtime(runtime: Runtime) = runtime(JsonField.of(runtime))

                            @JsonProperty("runtime")
                            @ExcludeMissing
                            fun runtime(runtime: JsonField<Runtime>) = apply {
                                this.runtime = runtime
                            }

                            fun version(version: String) = version(JsonField.of(version))

                            @JsonProperty("version")
                            @ExcludeMissing
                            fun version(version: JsonField<String>) = apply {
                                this.version = version
                            }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    this.additionalProperties.putAll(additionalProperties)
                                }

                            @JsonAnySetter
                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                this.additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun build(): RuntimeContext =
                                RuntimeContext(
                                    runtime,
                                    version,
                                    additionalProperties.toUnmodifiable(),
                                )
                        }

                        class Runtime
                        @JsonCreator
                        private constructor(
                            private val value: JsonField<String>,
                        ) : Enum {

                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Runtime && this.value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()

                            companion object {

                                val NODE = Runtime(JsonField.of("node"))

                                val PYTHON = Runtime(JsonField.of("python"))

                                fun of(value: String) = Runtime(JsonField.of(value))
                            }

                            enum class Known {
                                NODE,
                                PYTHON,
                            }

                            enum class Value {
                                NODE,
                                PYTHON,
                                _UNKNOWN,
                            }

                            fun value(): Value =
                                when (this) {
                                    NODE -> Value.NODE
                                    PYTHON -> Value.PYTHON
                                    else -> Value._UNKNOWN
                                }

                            fun known(): Known =
                                when (this) {
                                    NODE -> Known.NODE
                                    PYTHON -> Known.PYTHON
                                    else ->
                                        throw BraintrustInvalidDataException(
                                            "Unknown Runtime: $value"
                                        )
                                }

                            fun asString(): String = _value().asStringOrThrow()
                        }
                    }

                    class Type
                    @JsonCreator
                    private constructor(
                        private val value: JsonField<String>,
                    ) : Enum {

                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Type && this.value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()

                        companion object {

                            val INLINE = Type(JsonField.of("inline"))

                            fun of(value: String) = Type(JsonField.of(value))
                        }

                        enum class Known {
                            INLINE,
                        }

                        enum class Value {
                            INLINE,
                            _UNKNOWN,
                        }

                        fun value(): Value =
                            when (this) {
                                INLINE -> Value.INLINE
                                else -> Value._UNKNOWN
                            }

                        fun known(): Known =
                            when (this) {
                                INLINE -> Known.INLINE
                                else -> throw BraintrustInvalidDataException("Unknown Type: $value")
                            }

                        fun asString(): String = _value().asStringOrThrow()
                    }
                }
            }

            class Type
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Type && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    val CODE = Type(JsonField.of("code"))

                    fun of(value: String) = Type(JsonField.of(value))
                }

                enum class Known {
                    CODE,
                }

                enum class Value {
                    CODE,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        CODE -> Value.CODE
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        CODE -> Known.CODE
                        else -> throw BraintrustInvalidDataException("Unknown Type: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }
        }

        @JsonDeserialize(builder = Global.Builder::class)
        @NoAutoDetect
        class Global
        private constructor(
            private val type: JsonField<Type>,
            private val name: JsonField<String>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            fun type(): Type = type.getRequired("type")

            fun name(): String = name.getRequired("name")

            @JsonProperty("type") @ExcludeMissing fun _type() = type

            @JsonProperty("name") @ExcludeMissing fun _name() = name

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): Global = apply {
                if (!validated) {
                    type()
                    name()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Global &&
                    this.type == other.type &&
                    this.name == other.name &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            type,
                            name,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "Global{type=$type, name=$name, additionalProperties=$additionalProperties}"

            companion object {

                fun builder() = Builder()
            }

            class Builder {

                private var type: JsonField<Type> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(global: Global) = apply {
                    this.type = global.type
                    this.name = global.name
                    additionalProperties(global.additionalProperties)
                }

                fun type(type: Type) = type(JsonField.of(type))

                @JsonProperty("type")
                @ExcludeMissing
                fun type(type: JsonField<Type>) = apply { this.type = type }

                fun name(name: String) = name(JsonField.of(name))

                @JsonProperty("name")
                @ExcludeMissing
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    this.additionalProperties.putAll(additionalProperties)
                }

                @JsonAnySetter
                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    this.additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): Global =
                    Global(
                        type,
                        name,
                        additionalProperties.toUnmodifiable(),
                    )
            }

            class Type
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Type && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    val GLOBAL = Type(JsonField.of("global"))

                    fun of(value: String) = Type(JsonField.of(value))
                }

                enum class Known {
                    GLOBAL,
                }

                enum class Value {
                    GLOBAL,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        GLOBAL -> Value.GLOBAL
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        GLOBAL -> Known.GLOBAL
                        else -> throw BraintrustInvalidDataException("Unknown Type: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }
        }
    }

    class LogId
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LogId && this.value == other.value
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

        fun value(): Value =
            when (this) {
                P -> Value.P
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                P -> Known.P
                else -> throw BraintrustInvalidDataException("Unknown LogId: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /** JSON schema for the function's parameters and return type */
    @JsonDeserialize(builder = FunctionSchema.Builder::class)
    @NoAutoDetect
    class FunctionSchema
    private constructor(
        private val parameters: JsonValue,
        private val returns: JsonValue,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun parameters(): JsonValue = parameters

        fun returns(): JsonValue = returns

        @JsonProperty("parameters") @ExcludeMissing fun _parameters() = parameters

        @JsonProperty("returns") @ExcludeMissing fun _returns() = returns

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): FunctionSchema = apply {
            if (!validated) {
                parameters()
                returns()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FunctionSchema &&
                this.parameters == other.parameters &&
                this.returns == other.returns &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        parameters,
                        returns,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "FunctionSchema{parameters=$parameters, returns=$returns, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var parameters: JsonValue = JsonMissing.of()
            private var returns: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(functionSchema: FunctionSchema) = apply {
                this.parameters = functionSchema.parameters
                this.returns = functionSchema.returns
                additionalProperties(functionSchema.additionalProperties)
            }

            @JsonProperty("parameters")
            @ExcludeMissing
            fun parameters(parameters: JsonValue) = apply { this.parameters = parameters }

            @JsonProperty("returns")
            @ExcludeMissing
            fun returns(returns: JsonValue) = apply { this.returns = returns }

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

            fun build(): FunctionSchema =
                FunctionSchema(
                    parameters,
                    returns,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    class FunctionType
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FunctionType && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val LLM = FunctionType(JsonField.of("llm"))

            val SCORER = FunctionType(JsonField.of("scorer"))

            val TASK = FunctionType(JsonField.of("task"))

            val TOOL = FunctionType(JsonField.of("tool"))

            fun of(value: String) = FunctionType(JsonField.of(value))
        }

        enum class Known {
            LLM,
            SCORER,
            TASK,
            TOOL,
        }

        enum class Value {
            LLM,
            SCORER,
            TASK,
            TOOL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                LLM -> Value.LLM
                SCORER -> Value.SCORER
                TASK -> Value.TASK
                TOOL -> Value.TOOL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                LLM -> Known.LLM
                SCORER -> Known.SCORER
                TASK -> Known.TASK
                TOOL -> Known.TOOL
                else -> throw BraintrustInvalidDataException("Unknown FunctionType: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /** User-controlled metadata about the prompt */
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

    @JsonDeserialize(builder = Origin.Builder::class)
    @NoAutoDetect
    class Origin
    private constructor(
        private val objectType: JsonField<ObjectType>,
        private val objectId: JsonField<String>,
        private val internal_: JsonField<Boolean>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** The object type that the ACL applies to */
        fun objectType(): ObjectType? = objectType.getNullable("object_type")

        /** Id of the object the function is originating from */
        fun objectId(): String = objectId.getRequired("object_id")

        /**
         * The function exists for internal purposes and should not be displayed in the list of
         * functions.
         */
        fun internal_(): Boolean? = internal_.getNullable("internal")

        /** The object type that the ACL applies to */
        @JsonProperty("object_type") @ExcludeMissing fun _objectType() = objectType

        /** Id of the object the function is originating from */
        @JsonProperty("object_id") @ExcludeMissing fun _objectId() = objectId

        /**
         * The function exists for internal purposes and should not be displayed in the list of
         * functions.
         */
        @JsonProperty("internal") @ExcludeMissing fun _internal_() = internal_

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Origin = apply {
            if (!validated) {
                objectType()
                objectId()
                internal_()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Origin &&
                this.objectType == other.objectType &&
                this.objectId == other.objectId &&
                this.internal_ == other.internal_ &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        objectType,
                        objectId,
                        internal_,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Origin{objectType=$objectType, objectId=$objectId, internal_=$internal_, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var objectType: JsonField<ObjectType> = JsonMissing.of()
            private var objectId: JsonField<String> = JsonMissing.of()
            private var internal_: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(origin: Origin) = apply {
                this.objectType = origin.objectType
                this.objectId = origin.objectId
                this.internal_ = origin.internal_
                additionalProperties(origin.additionalProperties)
            }

            /** The object type that the ACL applies to */
            fun objectType(objectType: ObjectType) = objectType(JsonField.of(objectType))

            /** The object type that the ACL applies to */
            @JsonProperty("object_type")
            @ExcludeMissing
            fun objectType(objectType: JsonField<ObjectType>) = apply {
                this.objectType = objectType
            }

            /** Id of the object the function is originating from */
            fun objectId(objectId: String) = objectId(JsonField.of(objectId))

            /** Id of the object the function is originating from */
            @JsonProperty("object_id")
            @ExcludeMissing
            fun objectId(objectId: JsonField<String>) = apply { this.objectId = objectId }

            /**
             * The function exists for internal purposes and should not be displayed in the list of
             * functions.
             */
            fun internal_(internal_: Boolean) = internal_(JsonField.of(internal_))

            /**
             * The function exists for internal purposes and should not be displayed in the list of
             * functions.
             */
            @JsonProperty("internal")
            @ExcludeMissing
            fun internal_(internal_: JsonField<Boolean>) = apply { this.internal_ = internal_ }

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

            fun build(): Origin =
                Origin(
                    objectType,
                    objectId,
                    internal_,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class ObjectType
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ObjectType && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                val ORGANIZATION = ObjectType(JsonField.of("organization"))

                val PROJECT = ObjectType(JsonField.of("project"))

                val EXPERIMENT = ObjectType(JsonField.of("experiment"))

                val DATASET = ObjectType(JsonField.of("dataset"))

                val PROMPT = ObjectType(JsonField.of("prompt"))

                val PROMPT_SESSION = ObjectType(JsonField.of("prompt_session"))

                val GROUP = ObjectType(JsonField.of("group"))

                val ROLE = ObjectType(JsonField.of("role"))

                val ORG_MEMBER = ObjectType(JsonField.of("org_member"))

                val PROJECT_LOG = ObjectType(JsonField.of("project_log"))

                val ORG_PROJECT = ObjectType(JsonField.of("org_project"))

                fun of(value: String) = ObjectType(JsonField.of(value))
            }

            enum class Known {
                ORGANIZATION,
                PROJECT,
                EXPERIMENT,
                DATASET,
                PROMPT,
                PROMPT_SESSION,
                GROUP,
                ROLE,
                ORG_MEMBER,
                PROJECT_LOG,
                ORG_PROJECT,
            }

            enum class Value {
                ORGANIZATION,
                PROJECT,
                EXPERIMENT,
                DATASET,
                PROMPT,
                PROMPT_SESSION,
                GROUP,
                ROLE,
                ORG_MEMBER,
                PROJECT_LOG,
                ORG_PROJECT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    ORGANIZATION -> Value.ORGANIZATION
                    PROJECT -> Value.PROJECT
                    EXPERIMENT -> Value.EXPERIMENT
                    DATASET -> Value.DATASET
                    PROMPT -> Value.PROMPT
                    PROMPT_SESSION -> Value.PROMPT_SESSION
                    GROUP -> Value.GROUP
                    ROLE -> Value.ROLE
                    ORG_MEMBER -> Value.ORG_MEMBER
                    PROJECT_LOG -> Value.PROJECT_LOG
                    ORG_PROJECT -> Value.ORG_PROJECT
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    ORGANIZATION -> Known.ORGANIZATION
                    PROJECT -> Known.PROJECT
                    EXPERIMENT -> Known.EXPERIMENT
                    DATASET -> Known.DATASET
                    PROMPT -> Known.PROMPT
                    PROMPT_SESSION -> Known.PROMPT_SESSION
                    GROUP -> Known.GROUP
                    ROLE -> Known.ROLE
                    ORG_MEMBER -> Known.ORG_MEMBER
                    PROJECT_LOG -> Known.PROJECT_LOG
                    ORG_PROJECT -> Known.ORG_PROJECT
                    else -> throw BraintrustInvalidDataException("Unknown ObjectType: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
