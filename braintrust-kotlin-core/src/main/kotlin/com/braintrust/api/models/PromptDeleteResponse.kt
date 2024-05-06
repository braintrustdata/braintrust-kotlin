// File generated from our OpenAPI spec by Stainless.

package com.braintrust.api.models

import com.braintrust.api.core.BaseDeserializer
import com.braintrust.api.core.BaseSerializer
import com.braintrust.api.core.Enum
import com.braintrust.api.core.ExcludeMissing
import com.braintrust.api.core.JsonField
import com.braintrust.api.core.JsonMissing
import com.braintrust.api.core.JsonValue
import com.braintrust.api.core.NoAutoDetect
import com.braintrust.api.core.getOrThrow
import com.braintrust.api.core.toUnmodifiable
import com.braintrust.api.errors.BraintrustInvalidDataException
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

@JsonDeserialize(builder = PromptDeleteResponse.Builder::class)
@NoAutoDetect
class PromptDeleteResponse
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

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): PromptDeleteResponse = apply {
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
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PromptDeleteResponse &&
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
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "PromptDeleteResponse{id=$id, _xactId=$_xactId, projectId=$projectId, logId=$logId, orgId=$orgId, name=$name, slug=$slug, description=$description, created=$created, promptData=$promptData, tags=$tags, metadata=$metadata, additionalProperties=$additionalProperties}"

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
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(promptDeleteResponse: PromptDeleteResponse) = apply {
            this.id = promptDeleteResponse.id
            this._xactId = promptDeleteResponse._xactId
            this.projectId = promptDeleteResponse.projectId
            this.logId = promptDeleteResponse.logId
            this.orgId = promptDeleteResponse.orgId
            this.name = promptDeleteResponse.name
            this.slug = promptDeleteResponse.slug
            this.description = promptDeleteResponse.description
            this.created = promptDeleteResponse.created
            this.promptData = promptDeleteResponse.promptData
            this.tags = promptDeleteResponse.tags
            this.metadata = promptDeleteResponse.metadata
            additionalProperties(promptDeleteResponse.additionalProperties)
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

        fun build(): PromptDeleteResponse =
            PromptDeleteResponse(
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
                additionalProperties.toUnmodifiable(),
            )
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

    /** The prompt, model, and its parameters */
    @JsonDeserialize(builder = PromptData.Builder::class)
    @NoAutoDetect
    class PromptData
    private constructor(
        private val prompt: JsonField<Prompt>,
        private val options: JsonField<Options>,
        private val origin: JsonField<Origin>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun prompt(): Prompt? = prompt.getNullable("prompt")

        fun options(): Options? = options.getNullable("options")

        fun origin(): Origin? = origin.getNullable("origin")

        @JsonProperty("prompt") @ExcludeMissing fun _prompt() = prompt

        @JsonProperty("options") @ExcludeMissing fun _options() = options

        @JsonProperty("origin") @ExcludeMissing fun _origin() = origin

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): PromptData = apply {
            if (!validated) {
                prompt()
                options()?.validate()
                origin()?.validate()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PromptData &&
                this.prompt == other.prompt &&
                this.options == other.options &&
                this.origin == other.origin &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        prompt,
                        options,
                        origin,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "PromptData{prompt=$prompt, options=$options, origin=$origin, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var prompt: JsonField<Prompt> = JsonMissing.of()
            private var options: JsonField<Options> = JsonMissing.of()
            private var origin: JsonField<Origin> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(promptData: PromptData) = apply {
                this.prompt = promptData.prompt
                this.options = promptData.options
                this.origin = promptData.origin
                additionalProperties(promptData.additionalProperties)
            }

            fun prompt(prompt: Prompt) = prompt(JsonField.of(prompt))

            @JsonProperty("prompt")
            @ExcludeMissing
            fun prompt(prompt: JsonField<Prompt>) = apply { this.prompt = prompt }

            fun options(options: Options) = options(JsonField.of(options))

            @JsonProperty("options")
            @ExcludeMissing
            fun options(options: JsonField<Options>) = apply { this.options = options }

            fun origin(origin: Origin) = origin(JsonField.of(origin))

            @JsonProperty("origin")
            @ExcludeMissing
            fun origin(origin: JsonField<Origin>) = apply { this.origin = origin }

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

            fun build(): PromptData =
                PromptData(
                    prompt,
                    options,
                    origin,
                    additionalProperties.toUnmodifiable(),
                )
        }

        @JsonDeserialize(builder = Options.Builder::class)
        @NoAutoDetect
        class Options
        private constructor(
            private val model: JsonField<String>,
            private val params: JsonField<Params>,
            private val position: JsonField<String>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            fun model(): String? = model.getNullable("model")

            fun params(): Params? = params.getNullable("params")

            fun position(): String? = position.getNullable("position")

            @JsonProperty("model") @ExcludeMissing fun _model() = model

            @JsonProperty("params") @ExcludeMissing fun _params() = params

            @JsonProperty("position") @ExcludeMissing fun _position() = position

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): Options = apply {
                if (!validated) {
                    model()
                    params()
                    position()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Options &&
                    this.model == other.model &&
                    this.params == other.params &&
                    this.position == other.position &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            model,
                            params,
                            position,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "Options{model=$model, params=$params, position=$position, additionalProperties=$additionalProperties}"

            companion object {

                fun builder() = Builder()
            }

            class Builder {

                private var model: JsonField<String> = JsonMissing.of()
                private var params: JsonField<Params> = JsonMissing.of()
                private var position: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(options: Options) = apply {
                    this.model = options.model
                    this.params = options.params
                    this.position = options.position
                    additionalProperties(options.additionalProperties)
                }

                fun model(model: String) = model(JsonField.of(model))

                @JsonProperty("model")
                @ExcludeMissing
                fun model(model: JsonField<String>) = apply { this.model = model }

                fun params(params: Params) = params(JsonField.of(params))

                @JsonProperty("params")
                @ExcludeMissing
                fun params(params: JsonField<Params>) = apply { this.params = params }

                fun position(position: String) = position(JsonField.of(position))

                @JsonProperty("position")
                @ExcludeMissing
                fun position(position: JsonField<String>) = apply { this.position = position }

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

                fun build(): Options =
                    Options(
                        model,
                        params,
                        position,
                        additionalProperties.toUnmodifiable(),
                    )
            }

            @JsonDeserialize(using = Params.Deserializer::class)
            @JsonSerialize(using = Params.Serializer::class)
            class Params
            private constructor(
                private val unionMember0: UnionMember0? = null,
                private val unionMember1: UnionMember1? = null,
                private val unionMember2: UnionMember2? = null,
                private val useCache: UseCache? = null,
                private val _json: JsonValue? = null,
            ) {

                private var validated: Boolean = false

                fun unionMember0(): UnionMember0? = unionMember0

                fun unionMember1(): UnionMember1? = unionMember1

                fun unionMember2(): UnionMember2? = unionMember2

                fun useCache(): UseCache? = useCache

                fun isUnionMember0(): Boolean = unionMember0 != null

                fun isUnionMember1(): Boolean = unionMember1 != null

                fun isUnionMember2(): Boolean = unionMember2 != null

                fun isUseCache(): Boolean = useCache != null

                fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

                fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

                fun asUnionMember2(): UnionMember2 = unionMember2.getOrThrow("unionMember2")

                fun asUseCache(): UseCache = useCache.getOrThrow("useCache")

                fun _json(): JsonValue? = _json

                fun <T> accept(visitor: Visitor<T>): T {
                    return when {
                        unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                        unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                        unionMember2 != null -> visitor.visitUnionMember2(unionMember2)
                        useCache != null -> visitor.visitUseCache(useCache)
                        else -> visitor.unknown(_json)
                    }
                }

                fun validate(): Params = apply {
                    if (!validated) {
                        if (
                            unionMember0 == null &&
                                unionMember1 == null &&
                                unionMember2 == null &&
                                useCache == null
                        ) {
                            throw BraintrustInvalidDataException("Unknown Params: $_json")
                        }
                        unionMember0?.validate()
                        unionMember1?.validate()
                        unionMember2?.validate()
                        useCache?.validate()
                        validated = true
                    }
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Params &&
                        this.unionMember0 == other.unionMember0 &&
                        this.unionMember1 == other.unionMember1 &&
                        this.unionMember2 == other.unionMember2 &&
                        this.useCache == other.useCache
                }

                override fun hashCode(): Int {
                    return Objects.hash(
                        unionMember0,
                        unionMember1,
                        unionMember2,
                        useCache,
                    )
                }

                override fun toString(): String {
                    return when {
                        unionMember0 != null -> "Params{unionMember0=$unionMember0}"
                        unionMember1 != null -> "Params{unionMember1=$unionMember1}"
                        unionMember2 != null -> "Params{unionMember2=$unionMember2}"
                        useCache != null -> "Params{useCache=$useCache}"
                        _json != null -> "Params{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Params")
                    }
                }

                companion object {

                    fun ofUnionMember0(unionMember0: UnionMember0) =
                        Params(unionMember0 = unionMember0)

                    fun ofUnionMember1(unionMember1: UnionMember1) =
                        Params(unionMember1 = unionMember1)

                    fun ofUnionMember2(unionMember2: UnionMember2) =
                        Params(unionMember2 = unionMember2)

                    fun ofUseCache(useCache: UseCache) = Params(useCache = useCache)
                }

                interface Visitor<out T> {

                    fun visitUnionMember0(unionMember0: UnionMember0): T

                    fun visitUnionMember1(unionMember1: UnionMember1): T

                    fun visitUnionMember2(unionMember2: UnionMember2): T

                    fun visitUseCache(useCache: UseCache): T

                    fun unknown(json: JsonValue?): T {
                        throw BraintrustInvalidDataException("Unknown Params: $json")
                    }
                }

                class Deserializer : BaseDeserializer<Params>(Params::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Params {
                        val json = JsonValue.fromJsonNode(node)
                        tryDeserialize(node, jacksonTypeRef<UnionMember0>()) { it.validate() }
                            ?.let {
                                return Params(unionMember0 = it, _json = json)
                            }
                        tryDeserialize(node, jacksonTypeRef<UnionMember1>()) { it.validate() }
                            ?.let {
                                return Params(unionMember1 = it, _json = json)
                            }
                        tryDeserialize(node, jacksonTypeRef<UnionMember2>()) { it.validate() }
                            ?.let {
                                return Params(unionMember2 = it, _json = json)
                            }
                        tryDeserialize(node, jacksonTypeRef<UseCache>()) { it.validate() }
                            ?.let {
                                return Params(useCache = it, _json = json)
                            }

                        return Params(_json = json)
                    }
                }

                class Serializer : BaseSerializer<Params>(Params::class) {

                    override fun serialize(
                        value: Params,
                        generator: JsonGenerator,
                        provider: SerializerProvider
                    ) {
                        when {
                            value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                            value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                            value.unionMember2 != null -> generator.writeObject(value.unionMember2)
                            value.useCache != null -> generator.writeObject(value.useCache)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Params")
                        }
                    }
                }

                @JsonDeserialize(builder = UnionMember0.Builder::class)
                @NoAutoDetect
                class UnionMember0
                private constructor(
                    private val useCache: JsonField<Boolean>,
                    private val temperature: JsonField<Double>,
                    private val topP: JsonField<Double>,
                    private val maxTokens: JsonField<Double>,
                    private val frequencyPenalty: JsonField<Double>,
                    private val presencePenalty: JsonField<Double>,
                    private val responseFormat: JsonField<ResponseFormat>,
                    private val toolChoice: JsonField<ToolChoice>,
                    private val functionCall: JsonField<FunctionCall>,
                    private val n: JsonField<Double>,
                    private val stop: JsonField<List<String>>,
                    private val additionalProperties: Map<String, JsonValue>,
                ) {

                    private var validated: Boolean = false

                    private var hashCode: Int = 0

                    fun useCache(): Boolean? = useCache.getNullable("use_cache")

                    fun temperature(): Double? = temperature.getNullable("temperature")

                    fun topP(): Double? = topP.getNullable("top_p")

                    fun maxTokens(): Double? = maxTokens.getNullable("max_tokens")

                    fun frequencyPenalty(): Double? =
                        frequencyPenalty.getNullable("frequency_penalty")

                    fun presencePenalty(): Double? = presencePenalty.getNullable("presence_penalty")

                    fun responseFormat(): ResponseFormat? =
                        responseFormat.getNullable("response_format")

                    fun toolChoice(): ToolChoice? = toolChoice.getNullable("tool_choice")

                    fun functionCall(): FunctionCall? = functionCall.getNullable("function_call")

                    fun n(): Double? = n.getNullable("n")

                    fun stop(): List<String>? = stop.getNullable("stop")

                    @JsonProperty("use_cache") @ExcludeMissing fun _useCache() = useCache

                    @JsonProperty("temperature") @ExcludeMissing fun _temperature() = temperature

                    @JsonProperty("top_p") @ExcludeMissing fun _topP() = topP

                    @JsonProperty("max_tokens") @ExcludeMissing fun _maxTokens() = maxTokens

                    @JsonProperty("frequency_penalty")
                    @ExcludeMissing
                    fun _frequencyPenalty() = frequencyPenalty

                    @JsonProperty("presence_penalty")
                    @ExcludeMissing
                    fun _presencePenalty() = presencePenalty

                    @JsonProperty("response_format")
                    @ExcludeMissing
                    fun _responseFormat() = responseFormat

                    @JsonProperty("tool_choice") @ExcludeMissing fun _toolChoice() = toolChoice

                    @JsonProperty("function_call")
                    @ExcludeMissing
                    fun _functionCall() = functionCall

                    @JsonProperty("n") @ExcludeMissing fun _n() = n

                    @JsonProperty("stop") @ExcludeMissing fun _stop() = stop

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun validate(): UnionMember0 = apply {
                        if (!validated) {
                            useCache()
                            temperature()
                            topP()
                            maxTokens()
                            frequencyPenalty()
                            presencePenalty()
                            responseFormat()?.validate()
                            toolChoice()
                            functionCall()
                            n()
                            stop()
                            validated = true
                        }
                    }

                    fun toBuilder() = Builder().from(this)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is UnionMember0 &&
                            this.useCache == other.useCache &&
                            this.temperature == other.temperature &&
                            this.topP == other.topP &&
                            this.maxTokens == other.maxTokens &&
                            this.frequencyPenalty == other.frequencyPenalty &&
                            this.presencePenalty == other.presencePenalty &&
                            this.responseFormat == other.responseFormat &&
                            this.toolChoice == other.toolChoice &&
                            this.functionCall == other.functionCall &&
                            this.n == other.n &&
                            this.stop == other.stop &&
                            this.additionalProperties == other.additionalProperties
                    }

                    override fun hashCode(): Int {
                        if (hashCode == 0) {
                            hashCode =
                                Objects.hash(
                                    useCache,
                                    temperature,
                                    topP,
                                    maxTokens,
                                    frequencyPenalty,
                                    presencePenalty,
                                    responseFormat,
                                    toolChoice,
                                    functionCall,
                                    n,
                                    stop,
                                    additionalProperties,
                                )
                        }
                        return hashCode
                    }

                    override fun toString() =
                        "UnionMember0{useCache=$useCache, temperature=$temperature, topP=$topP, maxTokens=$maxTokens, frequencyPenalty=$frequencyPenalty, presencePenalty=$presencePenalty, responseFormat=$responseFormat, toolChoice=$toolChoice, functionCall=$functionCall, n=$n, stop=$stop, additionalProperties=$additionalProperties}"

                    companion object {

                        fun builder() = Builder()
                    }

                    class Builder {

                        private var useCache: JsonField<Boolean> = JsonMissing.of()
                        private var temperature: JsonField<Double> = JsonMissing.of()
                        private var topP: JsonField<Double> = JsonMissing.of()
                        private var maxTokens: JsonField<Double> = JsonMissing.of()
                        private var frequencyPenalty: JsonField<Double> = JsonMissing.of()
                        private var presencePenalty: JsonField<Double> = JsonMissing.of()
                        private var responseFormat: JsonField<ResponseFormat> = JsonMissing.of()
                        private var toolChoice: JsonField<ToolChoice> = JsonMissing.of()
                        private var functionCall: JsonField<FunctionCall> = JsonMissing.of()
                        private var n: JsonField<Double> = JsonMissing.of()
                        private var stop: JsonField<List<String>> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        internal fun from(unionMember0: UnionMember0) = apply {
                            this.useCache = unionMember0.useCache
                            this.temperature = unionMember0.temperature
                            this.topP = unionMember0.topP
                            this.maxTokens = unionMember0.maxTokens
                            this.frequencyPenalty = unionMember0.frequencyPenalty
                            this.presencePenalty = unionMember0.presencePenalty
                            this.responseFormat = unionMember0.responseFormat
                            this.toolChoice = unionMember0.toolChoice
                            this.functionCall = unionMember0.functionCall
                            this.n = unionMember0.n
                            this.stop = unionMember0.stop
                            additionalProperties(unionMember0.additionalProperties)
                        }

                        fun useCache(useCache: Boolean) = useCache(JsonField.of(useCache))

                        @JsonProperty("use_cache")
                        @ExcludeMissing
                        fun useCache(useCache: JsonField<Boolean>) = apply {
                            this.useCache = useCache
                        }

                        fun temperature(temperature: Double) =
                            temperature(JsonField.of(temperature))

                        @JsonProperty("temperature")
                        @ExcludeMissing
                        fun temperature(temperature: JsonField<Double>) = apply {
                            this.temperature = temperature
                        }

                        fun topP(topP: Double) = topP(JsonField.of(topP))

                        @JsonProperty("top_p")
                        @ExcludeMissing
                        fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

                        fun maxTokens(maxTokens: Double) = maxTokens(JsonField.of(maxTokens))

                        @JsonProperty("max_tokens")
                        @ExcludeMissing
                        fun maxTokens(maxTokens: JsonField<Double>) = apply {
                            this.maxTokens = maxTokens
                        }

                        fun frequencyPenalty(frequencyPenalty: Double) =
                            frequencyPenalty(JsonField.of(frequencyPenalty))

                        @JsonProperty("frequency_penalty")
                        @ExcludeMissing
                        fun frequencyPenalty(frequencyPenalty: JsonField<Double>) = apply {
                            this.frequencyPenalty = frequencyPenalty
                        }

                        fun presencePenalty(presencePenalty: Double) =
                            presencePenalty(JsonField.of(presencePenalty))

                        @JsonProperty("presence_penalty")
                        @ExcludeMissing
                        fun presencePenalty(presencePenalty: JsonField<Double>) = apply {
                            this.presencePenalty = presencePenalty
                        }

                        fun responseFormat(responseFormat: ResponseFormat) =
                            responseFormat(JsonField.of(responseFormat))

                        @JsonProperty("response_format")
                        @ExcludeMissing
                        fun responseFormat(responseFormat: JsonField<ResponseFormat>) = apply {
                            this.responseFormat = responseFormat
                        }

                        fun toolChoice(toolChoice: ToolChoice) =
                            toolChoice(JsonField.of(toolChoice))

                        @JsonProperty("tool_choice")
                        @ExcludeMissing
                        fun toolChoice(toolChoice: JsonField<ToolChoice>) = apply {
                            this.toolChoice = toolChoice
                        }

                        fun functionCall(functionCall: FunctionCall) =
                            functionCall(JsonField.of(functionCall))

                        @JsonProperty("function_call")
                        @ExcludeMissing
                        fun functionCall(functionCall: JsonField<FunctionCall>) = apply {
                            this.functionCall = functionCall
                        }

                        fun n(n: Double) = n(JsonField.of(n))

                        @JsonProperty("n")
                        @ExcludeMissing
                        fun n(n: JsonField<Double>) = apply { this.n = n }

                        fun stop(stop: List<String>) = stop(JsonField.of(stop))

                        @JsonProperty("stop")
                        @ExcludeMissing
                        fun stop(stop: JsonField<List<String>>) = apply { this.stop = stop }

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

                        fun build(): UnionMember0 =
                            UnionMember0(
                                useCache,
                                temperature,
                                topP,
                                maxTokens,
                                frequencyPenalty,
                                presencePenalty,
                                responseFormat,
                                toolChoice,
                                functionCall,
                                n,
                                stop.map { it.toUnmodifiable() },
                                additionalProperties.toUnmodifiable(),
                            )
                    }

                    @JsonDeserialize(using = FunctionCall.Deserializer::class)
                    @JsonSerialize(using = FunctionCall.Serializer::class)
                    class FunctionCall
                    private constructor(
                        private val unionMember0: UnionMember0? = null,
                        private val unionMember1: UnionMember1? = null,
                        private val name: Name? = null,
                        private val _json: JsonValue? = null,
                    ) {

                        private var validated: Boolean = false

                        fun unionMember0(): UnionMember0? = unionMember0

                        fun unionMember1(): UnionMember1? = unionMember1

                        fun name(): Name? = name

                        fun isUnionMember0(): Boolean = unionMember0 != null

                        fun isUnionMember1(): Boolean = unionMember1 != null

                        fun isName(): Boolean = name != null

                        fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

                        fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

                        fun asName(): Name = name.getOrThrow("name")

                        fun _json(): JsonValue? = _json

                        fun <T> accept(visitor: Visitor<T>): T {
                            return when {
                                unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                                unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                                name != null -> visitor.visitName(name)
                                else -> visitor.unknown(_json)
                            }
                        }

                        fun validate(): FunctionCall = apply {
                            if (!validated) {
                                if (unionMember0 == null && unionMember1 == null && name == null) {
                                    throw BraintrustInvalidDataException(
                                        "Unknown FunctionCall: $_json"
                                    )
                                }
                                name?.validate()
                                validated = true
                            }
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is FunctionCall &&
                                this.unionMember0 == other.unionMember0 &&
                                this.unionMember1 == other.unionMember1 &&
                                this.name == other.name
                        }

                        override fun hashCode(): Int {
                            return Objects.hash(
                                unionMember0,
                                unionMember1,
                                name,
                            )
                        }

                        override fun toString(): String {
                            return when {
                                unionMember0 != null -> "FunctionCall{unionMember0=$unionMember0}"
                                unionMember1 != null -> "FunctionCall{unionMember1=$unionMember1}"
                                name != null -> "FunctionCall{name=$name}"
                                _json != null -> "FunctionCall{_unknown=$_json}"
                                else -> throw IllegalStateException("Invalid FunctionCall")
                            }
                        }

                        companion object {

                            fun ofUnionMember0(unionMember0: UnionMember0) =
                                FunctionCall(unionMember0 = unionMember0)

                            fun ofUnionMember1(unionMember1: UnionMember1) =
                                FunctionCall(unionMember1 = unionMember1)

                            fun ofName(name: Name) = FunctionCall(name = name)
                        }

                        interface Visitor<out T> {

                            fun visitUnionMember0(unionMember0: UnionMember0): T

                            fun visitUnionMember1(unionMember1: UnionMember1): T

                            fun visitName(name: Name): T

                            fun unknown(json: JsonValue?): T {
                                throw BraintrustInvalidDataException("Unknown FunctionCall: $json")
                            }
                        }

                        class Deserializer : BaseDeserializer<FunctionCall>(FunctionCall::class) {

                            override fun ObjectCodec.deserialize(node: JsonNode): FunctionCall {
                                val json = JsonValue.fromJsonNode(node)
                                tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                                    return FunctionCall(unionMember0 = it, _json = json)
                                }
                                tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                                    return FunctionCall(unionMember1 = it, _json = json)
                                }
                                tryDeserialize(node, jacksonTypeRef<Name>()) { it.validate() }
                                    ?.let {
                                        return FunctionCall(name = it, _json = json)
                                    }

                                return FunctionCall(_json = json)
                            }
                        }

                        class Serializer : BaseSerializer<FunctionCall>(FunctionCall::class) {

                            override fun serialize(
                                value: FunctionCall,
                                generator: JsonGenerator,
                                provider: SerializerProvider
                            ) {
                                when {
                                    value.unionMember0 != null ->
                                        generator.writeObject(value.unionMember0)
                                    value.unionMember1 != null ->
                                        generator.writeObject(value.unionMember1)
                                    value.name != null -> generator.writeObject(value.name)
                                    value._json != null -> generator.writeObject(value._json)
                                    else -> throw IllegalStateException("Invalid FunctionCall")
                                }
                            }
                        }

                        class UnionMember0
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

                                return other is UnionMember0 && this.value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()

                            companion object {

                                val AUTO = UnionMember0(JsonField.of("auto"))

                                fun of(value: String) = UnionMember0(JsonField.of(value))
                            }

                            enum class Known {
                                AUTO,
                            }

                            enum class Value {
                                AUTO,
                                _UNKNOWN,
                            }

                            fun value(): Value =
                                when (this) {
                                    AUTO -> Value.AUTO
                                    else -> Value._UNKNOWN
                                }

                            fun known(): Known =
                                when (this) {
                                    AUTO -> Known.AUTO
                                    else ->
                                        throw BraintrustInvalidDataException(
                                            "Unknown UnionMember0: $value"
                                        )
                                }

                            fun asString(): String = _value().asStringOrThrow()
                        }

                        class UnionMember1
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

                                return other is UnionMember1 && this.value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()

                            companion object {

                                val NONE = UnionMember1(JsonField.of("none"))

                                fun of(value: String) = UnionMember1(JsonField.of(value))
                            }

                            enum class Known {
                                NONE,
                            }

                            enum class Value {
                                NONE,
                                _UNKNOWN,
                            }

                            fun value(): Value =
                                when (this) {
                                    NONE -> Value.NONE
                                    else -> Value._UNKNOWN
                                }

                            fun known(): Known =
                                when (this) {
                                    NONE -> Known.NONE
                                    else ->
                                        throw BraintrustInvalidDataException(
                                            "Unknown UnionMember1: $value"
                                        )
                                }

                            fun asString(): String = _value().asStringOrThrow()
                        }

                        @JsonDeserialize(builder = Name.Builder::class)
                        @NoAutoDetect
                        class Name
                        private constructor(
                            private val name: JsonField<String>,
                            private val additionalProperties: Map<String, JsonValue>,
                        ) {

                            private var validated: Boolean = false

                            private var hashCode: Int = 0

                            fun name(): String = name.getRequired("name")

                            @JsonProperty("name") @ExcludeMissing fun _name() = name

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            fun validate(): Name = apply {
                                if (!validated) {
                                    name()
                                    validated = true
                                }
                            }

                            fun toBuilder() = Builder().from(this)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Name &&
                                    this.name == other.name &&
                                    this.additionalProperties == other.additionalProperties
                            }

                            override fun hashCode(): Int {
                                if (hashCode == 0) {
                                    hashCode = Objects.hash(name, additionalProperties)
                                }
                                return hashCode
                            }

                            override fun toString() =
                                "Name{name=$name, additionalProperties=$additionalProperties}"

                            companion object {

                                fun builder() = Builder()
                            }

                            class Builder {

                                private var name: JsonField<String> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                internal fun from(name: Name) = apply {
                                    this.name = name.name
                                    additionalProperties(name.additionalProperties)
                                }

                                fun name(name: String) = name(JsonField.of(name))

                                @JsonProperty("name")
                                @ExcludeMissing
                                fun name(name: JsonField<String>) = apply { this.name = name }

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

                                fun build(): Name =
                                    Name(name, additionalProperties.toUnmodifiable())
                            }
                        }
                    }

                    @JsonDeserialize(builder = ResponseFormat.Builder::class)
                    @NoAutoDetect
                    class ResponseFormat
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

                        fun validate(): ResponseFormat = apply {
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

                            return other is ResponseFormat &&
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
                            "ResponseFormat{type=$type, additionalProperties=$additionalProperties}"

                        companion object {

                            fun builder() = Builder()
                        }

                        class Builder {

                            private var type: JsonField<Type> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(responseFormat: ResponseFormat) = apply {
                                this.type = responseFormat.type
                                additionalProperties(responseFormat.additionalProperties)
                            }

                            fun type(type: Type) = type(JsonField.of(type))

                            @JsonProperty("type")
                            @ExcludeMissing
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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

                            fun build(): ResponseFormat =
                                ResponseFormat(type, additionalProperties.toUnmodifiable())
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

                                val JSON_OBJECT = Type(JsonField.of("json_object"))

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            enum class Known {
                                JSON_OBJECT,
                            }

                            enum class Value {
                                JSON_OBJECT,
                                _UNKNOWN,
                            }

                            fun value(): Value =
                                when (this) {
                                    JSON_OBJECT -> Value.JSON_OBJECT
                                    else -> Value._UNKNOWN
                                }

                            fun known(): Known =
                                when (this) {
                                    JSON_OBJECT -> Known.JSON_OBJECT
                                    else ->
                                        throw BraintrustInvalidDataException("Unknown Type: $value")
                                }

                            fun asString(): String = _value().asStringOrThrow()
                        }
                    }

                    @JsonDeserialize(using = ToolChoice.Deserializer::class)
                    @JsonSerialize(using = ToolChoice.Serializer::class)
                    class ToolChoice
                    private constructor(
                        private val unionMember0: UnionMember0? = null,
                        private val unionMember1: UnionMember1? = null,
                        private val unionMember2: UnionMember2? = null,
                        private val _json: JsonValue? = null,
                    ) {

                        private var validated: Boolean = false

                        fun unionMember0(): UnionMember0? = unionMember0

                        fun unionMember1(): UnionMember1? = unionMember1

                        fun unionMember2(): UnionMember2? = unionMember2

                        fun isUnionMember0(): Boolean = unionMember0 != null

                        fun isUnionMember1(): Boolean = unionMember1 != null

                        fun isUnionMember2(): Boolean = unionMember2 != null

                        fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

                        fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

                        fun asUnionMember2(): UnionMember2 = unionMember2.getOrThrow("unionMember2")

                        fun _json(): JsonValue? = _json

                        fun <T> accept(visitor: Visitor<T>): T {
                            return when {
                                unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                                unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                                unionMember2 != null -> visitor.visitUnionMember2(unionMember2)
                                else -> visitor.unknown(_json)
                            }
                        }

                        fun validate(): ToolChoice = apply {
                            if (!validated) {
                                if (
                                    unionMember0 == null &&
                                        unionMember1 == null &&
                                        unionMember2 == null
                                ) {
                                    throw BraintrustInvalidDataException(
                                        "Unknown ToolChoice: $_json"
                                    )
                                }
                                unionMember2?.validate()
                                validated = true
                            }
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is ToolChoice &&
                                this.unionMember0 == other.unionMember0 &&
                                this.unionMember1 == other.unionMember1 &&
                                this.unionMember2 == other.unionMember2
                        }

                        override fun hashCode(): Int {
                            return Objects.hash(
                                unionMember0,
                                unionMember1,
                                unionMember2,
                            )
                        }

                        override fun toString(): String {
                            return when {
                                unionMember0 != null -> "ToolChoice{unionMember0=$unionMember0}"
                                unionMember1 != null -> "ToolChoice{unionMember1=$unionMember1}"
                                unionMember2 != null -> "ToolChoice{unionMember2=$unionMember2}"
                                _json != null -> "ToolChoice{_unknown=$_json}"
                                else -> throw IllegalStateException("Invalid ToolChoice")
                            }
                        }

                        companion object {

                            fun ofUnionMember0(unionMember0: UnionMember0) =
                                ToolChoice(unionMember0 = unionMember0)

                            fun ofUnionMember1(unionMember1: UnionMember1) =
                                ToolChoice(unionMember1 = unionMember1)

                            fun ofUnionMember2(unionMember2: UnionMember2) =
                                ToolChoice(unionMember2 = unionMember2)
                        }

                        interface Visitor<out T> {

                            fun visitUnionMember0(unionMember0: UnionMember0): T

                            fun visitUnionMember1(unionMember1: UnionMember1): T

                            fun visitUnionMember2(unionMember2: UnionMember2): T

                            fun unknown(json: JsonValue?): T {
                                throw BraintrustInvalidDataException("Unknown ToolChoice: $json")
                            }
                        }

                        class Deserializer : BaseDeserializer<ToolChoice>(ToolChoice::class) {

                            override fun ObjectCodec.deserialize(node: JsonNode): ToolChoice {
                                val json = JsonValue.fromJsonNode(node)
                                tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                                    return ToolChoice(unionMember0 = it, _json = json)
                                }
                                tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                                    return ToolChoice(unionMember1 = it, _json = json)
                                }
                                tryDeserialize(node, jacksonTypeRef<UnionMember2>()) {
                                        it.validate()
                                    }
                                    ?.let {
                                        return ToolChoice(unionMember2 = it, _json = json)
                                    }

                                return ToolChoice(_json = json)
                            }
                        }

                        class Serializer : BaseSerializer<ToolChoice>(ToolChoice::class) {

                            override fun serialize(
                                value: ToolChoice,
                                generator: JsonGenerator,
                                provider: SerializerProvider
                            ) {
                                when {
                                    value.unionMember0 != null ->
                                        generator.writeObject(value.unionMember0)
                                    value.unionMember1 != null ->
                                        generator.writeObject(value.unionMember1)
                                    value.unionMember2 != null ->
                                        generator.writeObject(value.unionMember2)
                                    value._json != null -> generator.writeObject(value._json)
                                    else -> throw IllegalStateException("Invalid ToolChoice")
                                }
                            }
                        }

                        class UnionMember0
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

                                return other is UnionMember0 && this.value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()

                            companion object {

                                val AUTO = UnionMember0(JsonField.of("auto"))

                                fun of(value: String) = UnionMember0(JsonField.of(value))
                            }

                            enum class Known {
                                AUTO,
                            }

                            enum class Value {
                                AUTO,
                                _UNKNOWN,
                            }

                            fun value(): Value =
                                when (this) {
                                    AUTO -> Value.AUTO
                                    else -> Value._UNKNOWN
                                }

                            fun known(): Known =
                                when (this) {
                                    AUTO -> Known.AUTO
                                    else ->
                                        throw BraintrustInvalidDataException(
                                            "Unknown UnionMember0: $value"
                                        )
                                }

                            fun asString(): String = _value().asStringOrThrow()
                        }

                        class UnionMember1
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

                                return other is UnionMember1 && this.value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()

                            companion object {

                                val NONE = UnionMember1(JsonField.of("none"))

                                fun of(value: String) = UnionMember1(JsonField.of(value))
                            }

                            enum class Known {
                                NONE,
                            }

                            enum class Value {
                                NONE,
                                _UNKNOWN,
                            }

                            fun value(): Value =
                                when (this) {
                                    NONE -> Value.NONE
                                    else -> Value._UNKNOWN
                                }

                            fun known(): Known =
                                when (this) {
                                    NONE -> Known.NONE
                                    else ->
                                        throw BraintrustInvalidDataException(
                                            "Unknown UnionMember1: $value"
                                        )
                                }

                            fun asString(): String = _value().asStringOrThrow()
                        }

                        @JsonDeserialize(builder = UnionMember2.Builder::class)
                        @NoAutoDetect
                        class UnionMember2
                        private constructor(
                            private val type: JsonField<Type>,
                            private val function: JsonField<Function>,
                            private val additionalProperties: Map<String, JsonValue>,
                        ) {

                            private var validated: Boolean = false

                            private var hashCode: Int = 0

                            fun type(): Type = type.getRequired("type")

                            fun function(): Function = function.getRequired("function")

                            @JsonProperty("type") @ExcludeMissing fun _type() = type

                            @JsonProperty("function") @ExcludeMissing fun _function() = function

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            fun validate(): UnionMember2 = apply {
                                if (!validated) {
                                    type()
                                    function().validate()
                                    validated = true
                                }
                            }

                            fun toBuilder() = Builder().from(this)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is UnionMember2 &&
                                    this.type == other.type &&
                                    this.function == other.function &&
                                    this.additionalProperties == other.additionalProperties
                            }

                            override fun hashCode(): Int {
                                if (hashCode == 0) {
                                    hashCode =
                                        Objects.hash(
                                            type,
                                            function,
                                            additionalProperties,
                                        )
                                }
                                return hashCode
                            }

                            override fun toString() =
                                "UnionMember2{type=$type, function=$function, additionalProperties=$additionalProperties}"

                            companion object {

                                fun builder() = Builder()
                            }

                            class Builder {

                                private var type: JsonField<Type> = JsonMissing.of()
                                private var function: JsonField<Function> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                internal fun from(unionMember2: UnionMember2) = apply {
                                    this.type = unionMember2.type
                                    this.function = unionMember2.function
                                    additionalProperties(unionMember2.additionalProperties)
                                }

                                fun type(type: Type) = type(JsonField.of(type))

                                @JsonProperty("type")
                                @ExcludeMissing
                                fun type(type: JsonField<Type>) = apply { this.type = type }

                                fun function(function: Function) = function(JsonField.of(function))

                                @JsonProperty("function")
                                @ExcludeMissing
                                fun function(function: JsonField<Function>) = apply {
                                    this.function = function
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

                                fun build(): UnionMember2 =
                                    UnionMember2(
                                        type,
                                        function,
                                        additionalProperties.toUnmodifiable(),
                                    )
                            }

                            @JsonDeserialize(builder = Function.Builder::class)
                            @NoAutoDetect
                            class Function
                            private constructor(
                                private val name: JsonField<String>,
                                private val additionalProperties: Map<String, JsonValue>,
                            ) {

                                private var validated: Boolean = false

                                private var hashCode: Int = 0

                                fun name(): String = name.getRequired("name")

                                @JsonProperty("name") @ExcludeMissing fun _name() = name

                                @JsonAnyGetter
                                @ExcludeMissing
                                fun _additionalProperties(): Map<String, JsonValue> =
                                    additionalProperties

                                fun validate(): Function = apply {
                                    if (!validated) {
                                        name()
                                        validated = true
                                    }
                                }

                                fun toBuilder() = Builder().from(this)

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is Function &&
                                        this.name == other.name &&
                                        this.additionalProperties == other.additionalProperties
                                }

                                override fun hashCode(): Int {
                                    if (hashCode == 0) {
                                        hashCode = Objects.hash(name, additionalProperties)
                                    }
                                    return hashCode
                                }

                                override fun toString() =
                                    "Function{name=$name, additionalProperties=$additionalProperties}"

                                companion object {

                                    fun builder() = Builder()
                                }

                                class Builder {

                                    private var name: JsonField<String> = JsonMissing.of()
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    internal fun from(function: Function) = apply {
                                        this.name = function.name
                                        additionalProperties(function.additionalProperties)
                                    }

                                    fun name(name: String) = name(JsonField.of(name))

                                    @JsonProperty("name")
                                    @ExcludeMissing
                                    fun name(name: JsonField<String>) = apply { this.name = name }

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

                                    fun build(): Function =
                                        Function(name, additionalProperties.toUnmodifiable())
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
                }

                @JsonDeserialize(builder = UnionMember1.Builder::class)
                @NoAutoDetect
                class UnionMember1
                private constructor(
                    private val useCache: JsonField<Boolean>,
                    private val maxTokens: JsonField<Double>,
                    private val temperature: JsonField<Double>,
                    private val topP: JsonField<Double>,
                    private val topK: JsonField<Double>,
                    private val stopSequences: JsonField<List<String>>,
                    private val maxTokensToSample: JsonField<Double>,
                    private val additionalProperties: Map<String, JsonValue>,
                ) {

                    private var validated: Boolean = false

                    private var hashCode: Int = 0

                    fun useCache(): Boolean? = useCache.getNullable("use_cache")

                    fun maxTokens(): Double = maxTokens.getRequired("max_tokens")

                    fun temperature(): Double = temperature.getRequired("temperature")

                    fun topP(): Double? = topP.getNullable("top_p")

                    fun topK(): Double? = topK.getNullable("top_k")

                    fun stopSequences(): List<String>? = stopSequences.getNullable("stop_sequences")

                    /** This is a legacy parameter that should not be used. */
                    fun maxTokensToSample(): Double? =
                        maxTokensToSample.getNullable("max_tokens_to_sample")

                    @JsonProperty("use_cache") @ExcludeMissing fun _useCache() = useCache

                    @JsonProperty("max_tokens") @ExcludeMissing fun _maxTokens() = maxTokens

                    @JsonProperty("temperature") @ExcludeMissing fun _temperature() = temperature

                    @JsonProperty("top_p") @ExcludeMissing fun _topP() = topP

                    @JsonProperty("top_k") @ExcludeMissing fun _topK() = topK

                    @JsonProperty("stop_sequences")
                    @ExcludeMissing
                    fun _stopSequences() = stopSequences

                    /** This is a legacy parameter that should not be used. */
                    @JsonProperty("max_tokens_to_sample")
                    @ExcludeMissing
                    fun _maxTokensToSample() = maxTokensToSample

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun validate(): UnionMember1 = apply {
                        if (!validated) {
                            useCache()
                            maxTokens()
                            temperature()
                            topP()
                            topK()
                            stopSequences()
                            maxTokensToSample()
                            validated = true
                        }
                    }

                    fun toBuilder() = Builder().from(this)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is UnionMember1 &&
                            this.useCache == other.useCache &&
                            this.maxTokens == other.maxTokens &&
                            this.temperature == other.temperature &&
                            this.topP == other.topP &&
                            this.topK == other.topK &&
                            this.stopSequences == other.stopSequences &&
                            this.maxTokensToSample == other.maxTokensToSample &&
                            this.additionalProperties == other.additionalProperties
                    }

                    override fun hashCode(): Int {
                        if (hashCode == 0) {
                            hashCode =
                                Objects.hash(
                                    useCache,
                                    maxTokens,
                                    temperature,
                                    topP,
                                    topK,
                                    stopSequences,
                                    maxTokensToSample,
                                    additionalProperties,
                                )
                        }
                        return hashCode
                    }

                    override fun toString() =
                        "UnionMember1{useCache=$useCache, maxTokens=$maxTokens, temperature=$temperature, topP=$topP, topK=$topK, stopSequences=$stopSequences, maxTokensToSample=$maxTokensToSample, additionalProperties=$additionalProperties}"

                    companion object {

                        fun builder() = Builder()
                    }

                    class Builder {

                        private var useCache: JsonField<Boolean> = JsonMissing.of()
                        private var maxTokens: JsonField<Double> = JsonMissing.of()
                        private var temperature: JsonField<Double> = JsonMissing.of()
                        private var topP: JsonField<Double> = JsonMissing.of()
                        private var topK: JsonField<Double> = JsonMissing.of()
                        private var stopSequences: JsonField<List<String>> = JsonMissing.of()
                        private var maxTokensToSample: JsonField<Double> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        internal fun from(unionMember1: UnionMember1) = apply {
                            this.useCache = unionMember1.useCache
                            this.maxTokens = unionMember1.maxTokens
                            this.temperature = unionMember1.temperature
                            this.topP = unionMember1.topP
                            this.topK = unionMember1.topK
                            this.stopSequences = unionMember1.stopSequences
                            this.maxTokensToSample = unionMember1.maxTokensToSample
                            additionalProperties(unionMember1.additionalProperties)
                        }

                        fun useCache(useCache: Boolean) = useCache(JsonField.of(useCache))

                        @JsonProperty("use_cache")
                        @ExcludeMissing
                        fun useCache(useCache: JsonField<Boolean>) = apply {
                            this.useCache = useCache
                        }

                        fun maxTokens(maxTokens: Double) = maxTokens(JsonField.of(maxTokens))

                        @JsonProperty("max_tokens")
                        @ExcludeMissing
                        fun maxTokens(maxTokens: JsonField<Double>) = apply {
                            this.maxTokens = maxTokens
                        }

                        fun temperature(temperature: Double) =
                            temperature(JsonField.of(temperature))

                        @JsonProperty("temperature")
                        @ExcludeMissing
                        fun temperature(temperature: JsonField<Double>) = apply {
                            this.temperature = temperature
                        }

                        fun topP(topP: Double) = topP(JsonField.of(topP))

                        @JsonProperty("top_p")
                        @ExcludeMissing
                        fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

                        fun topK(topK: Double) = topK(JsonField.of(topK))

                        @JsonProperty("top_k")
                        @ExcludeMissing
                        fun topK(topK: JsonField<Double>) = apply { this.topK = topK }

                        fun stopSequences(stopSequences: List<String>) =
                            stopSequences(JsonField.of(stopSequences))

                        @JsonProperty("stop_sequences")
                        @ExcludeMissing
                        fun stopSequences(stopSequences: JsonField<List<String>>) = apply {
                            this.stopSequences = stopSequences
                        }

                        /** This is a legacy parameter that should not be used. */
                        fun maxTokensToSample(maxTokensToSample: Double) =
                            maxTokensToSample(JsonField.of(maxTokensToSample))

                        /** This is a legacy parameter that should not be used. */
                        @JsonProperty("max_tokens_to_sample")
                        @ExcludeMissing
                        fun maxTokensToSample(maxTokensToSample: JsonField<Double>) = apply {
                            this.maxTokensToSample = maxTokensToSample
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

                        fun build(): UnionMember1 =
                            UnionMember1(
                                useCache,
                                maxTokens,
                                temperature,
                                topP,
                                topK,
                                stopSequences.map { it.toUnmodifiable() },
                                maxTokensToSample,
                                additionalProperties.toUnmodifiable(),
                            )
                    }
                }

                @JsonDeserialize(builder = UnionMember2.Builder::class)
                @NoAutoDetect
                class UnionMember2
                private constructor(
                    private val useCache: JsonField<Boolean>,
                    private val temperature: JsonField<Double>,
                    private val maxOutputTokens: JsonField<Double>,
                    private val topP: JsonField<Double>,
                    private val topK: JsonField<Double>,
                    private val additionalProperties: Map<String, JsonValue>,
                ) {

                    private var validated: Boolean = false

                    private var hashCode: Int = 0

                    fun useCache(): Boolean? = useCache.getNullable("use_cache")

                    fun temperature(): Double = temperature.getRequired("temperature")

                    fun maxOutputTokens(): Double? = maxOutputTokens.getNullable("maxOutputTokens")

                    fun topP(): Double? = topP.getNullable("topP")

                    fun topK(): Double? = topK.getNullable("topK")

                    @JsonProperty("use_cache") @ExcludeMissing fun _useCache() = useCache

                    @JsonProperty("temperature") @ExcludeMissing fun _temperature() = temperature

                    @JsonProperty("maxOutputTokens")
                    @ExcludeMissing
                    fun _maxOutputTokens() = maxOutputTokens

                    @JsonProperty("topP") @ExcludeMissing fun _topP() = topP

                    @JsonProperty("topK") @ExcludeMissing fun _topK() = topK

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun validate(): UnionMember2 = apply {
                        if (!validated) {
                            useCache()
                            temperature()
                            maxOutputTokens()
                            topP()
                            topK()
                            validated = true
                        }
                    }

                    fun toBuilder() = Builder().from(this)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is UnionMember2 &&
                            this.useCache == other.useCache &&
                            this.temperature == other.temperature &&
                            this.maxOutputTokens == other.maxOutputTokens &&
                            this.topP == other.topP &&
                            this.topK == other.topK &&
                            this.additionalProperties == other.additionalProperties
                    }

                    override fun hashCode(): Int {
                        if (hashCode == 0) {
                            hashCode =
                                Objects.hash(
                                    useCache,
                                    temperature,
                                    maxOutputTokens,
                                    topP,
                                    topK,
                                    additionalProperties,
                                )
                        }
                        return hashCode
                    }

                    override fun toString() =
                        "UnionMember2{useCache=$useCache, temperature=$temperature, maxOutputTokens=$maxOutputTokens, topP=$topP, topK=$topK, additionalProperties=$additionalProperties}"

                    companion object {

                        fun builder() = Builder()
                    }

                    class Builder {

                        private var useCache: JsonField<Boolean> = JsonMissing.of()
                        private var temperature: JsonField<Double> = JsonMissing.of()
                        private var maxOutputTokens: JsonField<Double> = JsonMissing.of()
                        private var topP: JsonField<Double> = JsonMissing.of()
                        private var topK: JsonField<Double> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        internal fun from(unionMember2: UnionMember2) = apply {
                            this.useCache = unionMember2.useCache
                            this.temperature = unionMember2.temperature
                            this.maxOutputTokens = unionMember2.maxOutputTokens
                            this.topP = unionMember2.topP
                            this.topK = unionMember2.topK
                            additionalProperties(unionMember2.additionalProperties)
                        }

                        fun useCache(useCache: Boolean) = useCache(JsonField.of(useCache))

                        @JsonProperty("use_cache")
                        @ExcludeMissing
                        fun useCache(useCache: JsonField<Boolean>) = apply {
                            this.useCache = useCache
                        }

                        fun temperature(temperature: Double) =
                            temperature(JsonField.of(temperature))

                        @JsonProperty("temperature")
                        @ExcludeMissing
                        fun temperature(temperature: JsonField<Double>) = apply {
                            this.temperature = temperature
                        }

                        fun maxOutputTokens(maxOutputTokens: Double) =
                            maxOutputTokens(JsonField.of(maxOutputTokens))

                        @JsonProperty("maxOutputTokens")
                        @ExcludeMissing
                        fun maxOutputTokens(maxOutputTokens: JsonField<Double>) = apply {
                            this.maxOutputTokens = maxOutputTokens
                        }

                        fun topP(topP: Double) = topP(JsonField.of(topP))

                        @JsonProperty("topP")
                        @ExcludeMissing
                        fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

                        fun topK(topK: Double) = topK(JsonField.of(topK))

                        @JsonProperty("topK")
                        @ExcludeMissing
                        fun topK(topK: JsonField<Double>) = apply { this.topK = topK }

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

                        fun build(): UnionMember2 =
                            UnionMember2(
                                useCache,
                                temperature,
                                maxOutputTokens,
                                topP,
                                topK,
                                additionalProperties.toUnmodifiable(),
                            )
                    }
                }

                @JsonDeserialize(builder = UseCache.Builder::class)
                @NoAutoDetect
                class UseCache
                private constructor(
                    private val useCache: JsonField<Boolean>,
                    private val additionalProperties: Map<String, JsonValue>,
                ) {

                    private var validated: Boolean = false

                    private var hashCode: Int = 0

                    fun useCache(): Boolean? = useCache.getNullable("use_cache")

                    @JsonProperty("use_cache") @ExcludeMissing fun _useCache() = useCache

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun validate(): UseCache = apply {
                        if (!validated) {
                            useCache()
                            validated = true
                        }
                    }

                    fun toBuilder() = Builder().from(this)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is UseCache &&
                            this.useCache == other.useCache &&
                            this.additionalProperties == other.additionalProperties
                    }

                    override fun hashCode(): Int {
                        if (hashCode == 0) {
                            hashCode = Objects.hash(useCache, additionalProperties)
                        }
                        return hashCode
                    }

                    override fun toString() =
                        "UseCache{useCache=$useCache, additionalProperties=$additionalProperties}"

                    companion object {

                        fun builder() = Builder()
                    }

                    class Builder {

                        private var useCache: JsonField<Boolean> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        internal fun from(useCache: UseCache) = apply {
                            this.useCache = useCache.useCache
                            additionalProperties(useCache.additionalProperties)
                        }

                        fun useCache(useCache: Boolean) = useCache(JsonField.of(useCache))

                        @JsonProperty("use_cache")
                        @ExcludeMissing
                        fun useCache(useCache: JsonField<Boolean>) = apply {
                            this.useCache = useCache
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

                        fun build(): UseCache =
                            UseCache(useCache, additionalProperties.toUnmodifiable())
                    }
                }
            }
        }

        @JsonDeserialize(builder = Origin.Builder::class)
        @NoAutoDetect
        class Origin
        private constructor(
            private val promptId: JsonField<String>,
            private val projectId: JsonField<String>,
            private val promptVersion: JsonField<String>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            fun promptId(): String? = promptId.getNullable("prompt_id")

            fun projectId(): String? = projectId.getNullable("project_id")

            fun promptVersion(): String? = promptVersion.getNullable("prompt_version")

            @JsonProperty("prompt_id") @ExcludeMissing fun _promptId() = promptId

            @JsonProperty("project_id") @ExcludeMissing fun _projectId() = projectId

            @JsonProperty("prompt_version") @ExcludeMissing fun _promptVersion() = promptVersion

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): Origin = apply {
                if (!validated) {
                    promptId()
                    projectId()
                    promptVersion()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Origin &&
                    this.promptId == other.promptId &&
                    this.projectId == other.projectId &&
                    this.promptVersion == other.promptVersion &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            promptId,
                            projectId,
                            promptVersion,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "Origin{promptId=$promptId, projectId=$projectId, promptVersion=$promptVersion, additionalProperties=$additionalProperties}"

            companion object {

                fun builder() = Builder()
            }

            class Builder {

                private var promptId: JsonField<String> = JsonMissing.of()
                private var projectId: JsonField<String> = JsonMissing.of()
                private var promptVersion: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(origin: Origin) = apply {
                    this.promptId = origin.promptId
                    this.projectId = origin.projectId
                    this.promptVersion = origin.promptVersion
                    additionalProperties(origin.additionalProperties)
                }

                fun promptId(promptId: String) = promptId(JsonField.of(promptId))

                @JsonProperty("prompt_id")
                @ExcludeMissing
                fun promptId(promptId: JsonField<String>) = apply { this.promptId = promptId }

                fun projectId(projectId: String) = projectId(JsonField.of(projectId))

                @JsonProperty("project_id")
                @ExcludeMissing
                fun projectId(projectId: JsonField<String>) = apply { this.projectId = projectId }

                fun promptVersion(promptVersion: String) =
                    promptVersion(JsonField.of(promptVersion))

                @JsonProperty("prompt_version")
                @ExcludeMissing
                fun promptVersion(promptVersion: JsonField<String>) = apply {
                    this.promptVersion = promptVersion
                }

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

                fun build(): Origin =
                    Origin(
                        promptId,
                        projectId,
                        promptVersion,
                        additionalProperties.toUnmodifiable(),
                    )
            }
        }

        @JsonDeserialize(using = Prompt.Deserializer::class)
        @JsonSerialize(using = Prompt.Serializer::class)
        class Prompt
        private constructor(
            private val unionMember0: UnionMember0? = null,
            private val unionMember1: UnionMember1? = null,
            private val _reservedOnlyAllowNull: _ReservedOnlyAllowNull? = null,
            private val _json: JsonValue? = null,
        ) {

            private var validated: Boolean = false

            fun unionMember0(): UnionMember0? = unionMember0

            fun unionMember1(): UnionMember1? = unionMember1

            fun _reservedOnlyAllowNull(): _ReservedOnlyAllowNull? = _reservedOnlyAllowNull

            fun isUnionMember0(): Boolean = unionMember0 != null

            fun isUnionMember1(): Boolean = unionMember1 != null

            fun is_ReservedOnlyAllowNull(): Boolean = _reservedOnlyAllowNull != null

            fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

            fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

            fun as_ReservedOnlyAllowNull(): _ReservedOnlyAllowNull =
                _reservedOnlyAllowNull.getOrThrow("_reservedOnlyAllowNull")

            fun _json(): JsonValue? = _json

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                    unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                    _reservedOnlyAllowNull != null ->
                        visitor.visit_ReservedOnlyAllowNull(_reservedOnlyAllowNull)
                    else -> visitor.unknown(_json)
                }
            }

            fun validate(): Prompt = apply {
                if (!validated) {
                    if (
                        unionMember0 == null &&
                            unionMember1 == null &&
                            _reservedOnlyAllowNull == null
                    ) {
                        throw BraintrustInvalidDataException("Unknown Prompt: $_json")
                    }
                    unionMember0?.validate()
                    unionMember1?.validate()
                    _reservedOnlyAllowNull?.validate()
                    validated = true
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Prompt &&
                    this.unionMember0 == other.unionMember0 &&
                    this.unionMember1 == other.unionMember1 &&
                    this._reservedOnlyAllowNull == other._reservedOnlyAllowNull
            }

            override fun hashCode(): Int {
                return Objects.hash(
                    unionMember0,
                    unionMember1,
                    _reservedOnlyAllowNull,
                )
            }

            override fun toString(): String {
                return when {
                    unionMember0 != null -> "Prompt{unionMember0=$unionMember0}"
                    unionMember1 != null -> "Prompt{unionMember1=$unionMember1}"
                    _reservedOnlyAllowNull != null ->
                        "Prompt{_reservedOnlyAllowNull=$_reservedOnlyAllowNull}"
                    _json != null -> "Prompt{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Prompt")
                }
            }

            companion object {

                fun ofUnionMember0(unionMember0: UnionMember0) = Prompt(unionMember0 = unionMember0)

                fun ofUnionMember1(unionMember1: UnionMember1) = Prompt(unionMember1 = unionMember1)

                fun of_ReservedOnlyAllowNull(_reservedOnlyAllowNull: _ReservedOnlyAllowNull) =
                    Prompt(_reservedOnlyAllowNull = _reservedOnlyAllowNull)
            }

            interface Visitor<out T> {

                fun visitUnionMember0(unionMember0: UnionMember0): T

                fun visitUnionMember1(unionMember1: UnionMember1): T

                fun visit_ReservedOnlyAllowNull(_reservedOnlyAllowNull: _ReservedOnlyAllowNull): T

                fun unknown(json: JsonValue?): T {
                    throw BraintrustInvalidDataException("Unknown Prompt: $json")
                }
            }

            class Deserializer : BaseDeserializer<Prompt>(Prompt::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Prompt {
                    val json = JsonValue.fromJsonNode(node)
                    tryDeserialize(node, jacksonTypeRef<UnionMember0>()) { it.validate() }
                        ?.let {
                            return Prompt(unionMember0 = it, _json = json)
                        }
                    tryDeserialize(node, jacksonTypeRef<UnionMember1>()) { it.validate() }
                        ?.let {
                            return Prompt(unionMember1 = it, _json = json)
                        }
                    tryDeserialize(node, jacksonTypeRef<_ReservedOnlyAllowNull>()) { it.validate() }
                        ?.let {
                            return Prompt(_reservedOnlyAllowNull = it, _json = json)
                        }

                    return Prompt(_json = json)
                }
            }

            class Serializer : BaseSerializer<Prompt>(Prompt::class) {

                override fun serialize(
                    value: Prompt,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                        value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                        value._reservedOnlyAllowNull != null ->
                            generator.writeObject(value._reservedOnlyAllowNull)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Prompt")
                    }
                }
            }

            @JsonDeserialize(builder = UnionMember0.Builder::class)
            @NoAutoDetect
            class UnionMember0
            private constructor(
                private val type: JsonField<Type>,
                private val content: JsonField<String>,
                private val additionalProperties: Map<String, JsonValue>,
            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                fun type(): Type = type.getRequired("type")

                fun content(): String = content.getRequired("content")

                @JsonProperty("type") @ExcludeMissing fun _type() = type

                @JsonProperty("content") @ExcludeMissing fun _content() = content

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): UnionMember0 = apply {
                    if (!validated) {
                        type()
                        content()
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember0 &&
                        this.type == other.type &&
                        this.content == other.content &&
                        this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                    if (hashCode == 0) {
                        hashCode =
                            Objects.hash(
                                type,
                                content,
                                additionalProperties,
                            )
                    }
                    return hashCode
                }

                override fun toString() =
                    "UnionMember0{type=$type, content=$content, additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var type: JsonField<Type> = JsonMissing.of()
                    private var content: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(unionMember0: UnionMember0) = apply {
                        this.type = unionMember0.type
                        this.content = unionMember0.content
                        additionalProperties(unionMember0.additionalProperties)
                    }

                    fun type(type: Type) = type(JsonField.of(type))

                    @JsonProperty("type")
                    @ExcludeMissing
                    fun type(type: JsonField<Type>) = apply { this.type = type }

                    fun content(content: String) = content(JsonField.of(content))

                    @JsonProperty("content")
                    @ExcludeMissing
                    fun content(content: JsonField<String>) = apply { this.content = content }

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

                    fun build(): UnionMember0 =
                        UnionMember0(
                            type,
                            content,
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

                        val COMPLETION = Type(JsonField.of("completion"))

                        fun of(value: String) = Type(JsonField.of(value))
                    }

                    enum class Known {
                        COMPLETION,
                    }

                    enum class Value {
                        COMPLETION,
                        _UNKNOWN,
                    }

                    fun value(): Value =
                        when (this) {
                            COMPLETION -> Value.COMPLETION
                            else -> Value._UNKNOWN
                        }

                    fun known(): Known =
                        when (this) {
                            COMPLETION -> Known.COMPLETION
                            else -> throw BraintrustInvalidDataException("Unknown Type: $value")
                        }

                    fun asString(): String = _value().asStringOrThrow()
                }
            }

            @JsonDeserialize(builder = UnionMember1.Builder::class)
            @NoAutoDetect
            class UnionMember1
            private constructor(
                private val type: JsonField<Type>,
                private val messages: JsonField<List<Message>>,
                private val tools: JsonField<String>,
                private val additionalProperties: Map<String, JsonValue>,
            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                fun type(): Type = type.getRequired("type")

                fun messages(): List<Message> = messages.getRequired("messages")

                fun tools(): String? = tools.getNullable("tools")

                @JsonProperty("type") @ExcludeMissing fun _type() = type

                @JsonProperty("messages") @ExcludeMissing fun _messages() = messages

                @JsonProperty("tools") @ExcludeMissing fun _tools() = tools

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): UnionMember1 = apply {
                    if (!validated) {
                        type()
                        messages()
                        tools()
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember1 &&
                        this.type == other.type &&
                        this.messages == other.messages &&
                        this.tools == other.tools &&
                        this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                    if (hashCode == 0) {
                        hashCode =
                            Objects.hash(
                                type,
                                messages,
                                tools,
                                additionalProperties,
                            )
                    }
                    return hashCode
                }

                override fun toString() =
                    "UnionMember1{type=$type, messages=$messages, tools=$tools, additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var type: JsonField<Type> = JsonMissing.of()
                    private var messages: JsonField<List<Message>> = JsonMissing.of()
                    private var tools: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(unionMember1: UnionMember1) = apply {
                        this.type = unionMember1.type
                        this.messages = unionMember1.messages
                        this.tools = unionMember1.tools
                        additionalProperties(unionMember1.additionalProperties)
                    }

                    fun type(type: Type) = type(JsonField.of(type))

                    @JsonProperty("type")
                    @ExcludeMissing
                    fun type(type: JsonField<Type>) = apply { this.type = type }

                    fun messages(messages: List<Message>) = messages(JsonField.of(messages))

                    @JsonProperty("messages")
                    @ExcludeMissing
                    fun messages(messages: JsonField<List<Message>>) = apply {
                        this.messages = messages
                    }

                    fun tools(tools: String) = tools(JsonField.of(tools))

                    @JsonProperty("tools")
                    @ExcludeMissing
                    fun tools(tools: JsonField<String>) = apply { this.tools = tools }

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

                    fun build(): UnionMember1 =
                        UnionMember1(
                            type,
                            messages.map { it.toUnmodifiable() },
                            tools,
                            additionalProperties.toUnmodifiable(),
                        )
                }

                @JsonDeserialize(using = Message.Deserializer::class)
                @JsonSerialize(using = Message.Serializer::class)
                class Message
                private constructor(
                    private val unionMember0: UnionMember0? = null,
                    private val unionMember1: UnionMember1? = null,
                    private val unionMember2: UnionMember2? = null,
                    private val unionMember3: UnionMember3? = null,
                    private val unionMember4: UnionMember4? = null,
                    private val _json: JsonValue? = null,
                ) {

                    private var validated: Boolean = false

                    fun unionMember0(): UnionMember0? = unionMember0

                    fun unionMember1(): UnionMember1? = unionMember1

                    fun unionMember2(): UnionMember2? = unionMember2

                    fun unionMember3(): UnionMember3? = unionMember3

                    fun unionMember4(): UnionMember4? = unionMember4

                    fun isUnionMember0(): Boolean = unionMember0 != null

                    fun isUnionMember1(): Boolean = unionMember1 != null

                    fun isUnionMember2(): Boolean = unionMember2 != null

                    fun isUnionMember3(): Boolean = unionMember3 != null

                    fun isUnionMember4(): Boolean = unionMember4 != null

                    fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

                    fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

                    fun asUnionMember2(): UnionMember2 = unionMember2.getOrThrow("unionMember2")

                    fun asUnionMember3(): UnionMember3 = unionMember3.getOrThrow("unionMember3")

                    fun asUnionMember4(): UnionMember4 = unionMember4.getOrThrow("unionMember4")

                    fun _json(): JsonValue? = _json

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                            unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                            unionMember2 != null -> visitor.visitUnionMember2(unionMember2)
                            unionMember3 != null -> visitor.visitUnionMember3(unionMember3)
                            unionMember4 != null -> visitor.visitUnionMember4(unionMember4)
                            else -> visitor.unknown(_json)
                        }
                    }

                    fun validate(): Message = apply {
                        if (!validated) {
                            if (
                                unionMember0 == null &&
                                    unionMember1 == null &&
                                    unionMember2 == null &&
                                    unionMember3 == null &&
                                    unionMember4 == null
                            ) {
                                throw BraintrustInvalidDataException("Unknown Message: $_json")
                            }
                            unionMember0?.validate()
                            unionMember1?.validate()
                            unionMember2?.validate()
                            unionMember3?.validate()
                            unionMember4?.validate()
                            validated = true
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Message &&
                            this.unionMember0 == other.unionMember0 &&
                            this.unionMember1 == other.unionMember1 &&
                            this.unionMember2 == other.unionMember2 &&
                            this.unionMember3 == other.unionMember3 &&
                            this.unionMember4 == other.unionMember4
                    }

                    override fun hashCode(): Int {
                        return Objects.hash(
                            unionMember0,
                            unionMember1,
                            unionMember2,
                            unionMember3,
                            unionMember4,
                        )
                    }

                    override fun toString(): String {
                        return when {
                            unionMember0 != null -> "Message{unionMember0=$unionMember0}"
                            unionMember1 != null -> "Message{unionMember1=$unionMember1}"
                            unionMember2 != null -> "Message{unionMember2=$unionMember2}"
                            unionMember3 != null -> "Message{unionMember3=$unionMember3}"
                            unionMember4 != null -> "Message{unionMember4=$unionMember4}"
                            _json != null -> "Message{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid Message")
                        }
                    }

                    companion object {

                        fun ofUnionMember0(unionMember0: UnionMember0) =
                            Message(unionMember0 = unionMember0)

                        fun ofUnionMember1(unionMember1: UnionMember1) =
                            Message(unionMember1 = unionMember1)

                        fun ofUnionMember2(unionMember2: UnionMember2) =
                            Message(unionMember2 = unionMember2)

                        fun ofUnionMember3(unionMember3: UnionMember3) =
                            Message(unionMember3 = unionMember3)

                        fun ofUnionMember4(unionMember4: UnionMember4) =
                            Message(unionMember4 = unionMember4)
                    }

                    interface Visitor<out T> {

                        fun visitUnionMember0(unionMember0: UnionMember0): T

                        fun visitUnionMember1(unionMember1: UnionMember1): T

                        fun visitUnionMember2(unionMember2: UnionMember2): T

                        fun visitUnionMember3(unionMember3: UnionMember3): T

                        fun visitUnionMember4(unionMember4: UnionMember4): T

                        fun unknown(json: JsonValue?): T {
                            throw BraintrustInvalidDataException("Unknown Message: $json")
                        }
                    }

                    class Deserializer : BaseDeserializer<Message>(Message::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): Message {
                            val json = JsonValue.fromJsonNode(node)
                            tryDeserialize(node, jacksonTypeRef<UnionMember0>()) { it.validate() }
                                ?.let {
                                    return Message(unionMember0 = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<UnionMember1>()) { it.validate() }
                                ?.let {
                                    return Message(unionMember1 = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<UnionMember2>()) { it.validate() }
                                ?.let {
                                    return Message(unionMember2 = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<UnionMember3>()) { it.validate() }
                                ?.let {
                                    return Message(unionMember3 = it, _json = json)
                                }
                            tryDeserialize(node, jacksonTypeRef<UnionMember4>()) { it.validate() }
                                ?.let {
                                    return Message(unionMember4 = it, _json = json)
                                }

                            return Message(_json = json)
                        }
                    }

                    class Serializer : BaseSerializer<Message>(Message::class) {

                        override fun serialize(
                            value: Message,
                            generator: JsonGenerator,
                            provider: SerializerProvider
                        ) {
                            when {
                                value.unionMember0 != null ->
                                    generator.writeObject(value.unionMember0)
                                value.unionMember1 != null ->
                                    generator.writeObject(value.unionMember1)
                                value.unionMember2 != null ->
                                    generator.writeObject(value.unionMember2)
                                value.unionMember3 != null ->
                                    generator.writeObject(value.unionMember3)
                                value.unionMember4 != null ->
                                    generator.writeObject(value.unionMember4)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid Message")
                            }
                        }
                    }

                    @JsonDeserialize(builder = UnionMember0.Builder::class)
                    @NoAutoDetect
                    class UnionMember0
                    private constructor(
                        private val content: JsonField<String>,
                        private val role: JsonField<Role>,
                        private val name: JsonField<String>,
                        private val additionalProperties: Map<String, JsonValue>,
                    ) {

                        private var validated: Boolean = false

                        private var hashCode: Int = 0

                        fun content(): String? = content.getNullable("content")

                        fun role(): Role = role.getRequired("role")

                        fun name(): String? = name.getNullable("name")

                        @JsonProperty("content") @ExcludeMissing fun _content() = content

                        @JsonProperty("role") @ExcludeMissing fun _role() = role

                        @JsonProperty("name") @ExcludeMissing fun _name() = name

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun validate(): UnionMember0 = apply {
                            if (!validated) {
                                content()
                                role()
                                name()
                                validated = true
                            }
                        }

                        fun toBuilder() = Builder().from(this)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is UnionMember0 &&
                                this.content == other.content &&
                                this.role == other.role &&
                                this.name == other.name &&
                                this.additionalProperties == other.additionalProperties
                        }

                        override fun hashCode(): Int {
                            if (hashCode == 0) {
                                hashCode =
                                    Objects.hash(
                                        content,
                                        role,
                                        name,
                                        additionalProperties,
                                    )
                            }
                            return hashCode
                        }

                        override fun toString() =
                            "UnionMember0{content=$content, role=$role, name=$name, additionalProperties=$additionalProperties}"

                        companion object {

                            fun builder() = Builder()
                        }

                        class Builder {

                            private var content: JsonField<String> = JsonMissing.of()
                            private var role: JsonField<Role> = JsonMissing.of()
                            private var name: JsonField<String> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(unionMember0: UnionMember0) = apply {
                                this.content = unionMember0.content
                                this.role = unionMember0.role
                                this.name = unionMember0.name
                                additionalProperties(unionMember0.additionalProperties)
                            }

                            fun content(content: String) = content(JsonField.of(content))

                            @JsonProperty("content")
                            @ExcludeMissing
                            fun content(content: JsonField<String>) = apply {
                                this.content = content
                            }

                            fun role(role: Role) = role(JsonField.of(role))

                            @JsonProperty("role")
                            @ExcludeMissing
                            fun role(role: JsonField<Role>) = apply { this.role = role }

                            fun name(name: String) = name(JsonField.of(name))

                            @JsonProperty("name")
                            @ExcludeMissing
                            fun name(name: JsonField<String>) = apply { this.name = name }

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

                            fun build(): UnionMember0 =
                                UnionMember0(
                                    content,
                                    role,
                                    name,
                                    additionalProperties.toUnmodifiable(),
                                )
                        }

                        class Role
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

                                return other is Role && this.value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()

                            companion object {

                                val SYSTEM = Role(JsonField.of("system"))

                                fun of(value: String) = Role(JsonField.of(value))
                            }

                            enum class Known {
                                SYSTEM,
                            }

                            enum class Value {
                                SYSTEM,
                                _UNKNOWN,
                            }

                            fun value(): Value =
                                when (this) {
                                    SYSTEM -> Value.SYSTEM
                                    else -> Value._UNKNOWN
                                }

                            fun known(): Known =
                                when (this) {
                                    SYSTEM -> Known.SYSTEM
                                    else ->
                                        throw BraintrustInvalidDataException("Unknown Role: $value")
                                }

                            fun asString(): String = _value().asStringOrThrow()
                        }
                    }

                    @JsonDeserialize(builder = UnionMember1.Builder::class)
                    @NoAutoDetect
                    class UnionMember1
                    private constructor(
                        private val content: JsonField<Content>,
                        private val role: JsonField<Role>,
                        private val name: JsonField<String>,
                        private val additionalProperties: Map<String, JsonValue>,
                    ) {

                        private var validated: Boolean = false

                        private var hashCode: Int = 0

                        fun content(): Content? = content.getNullable("content")

                        fun role(): Role = role.getRequired("role")

                        fun name(): String? = name.getNullable("name")

                        @JsonProperty("content") @ExcludeMissing fun _content() = content

                        @JsonProperty("role") @ExcludeMissing fun _role() = role

                        @JsonProperty("name") @ExcludeMissing fun _name() = name

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun validate(): UnionMember1 = apply {
                            if (!validated) {
                                content()
                                role()
                                name()
                                validated = true
                            }
                        }

                        fun toBuilder() = Builder().from(this)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is UnionMember1 &&
                                this.content == other.content &&
                                this.role == other.role &&
                                this.name == other.name &&
                                this.additionalProperties == other.additionalProperties
                        }

                        override fun hashCode(): Int {
                            if (hashCode == 0) {
                                hashCode =
                                    Objects.hash(
                                        content,
                                        role,
                                        name,
                                        additionalProperties,
                                    )
                            }
                            return hashCode
                        }

                        override fun toString() =
                            "UnionMember1{content=$content, role=$role, name=$name, additionalProperties=$additionalProperties}"

                        companion object {

                            fun builder() = Builder()
                        }

                        class Builder {

                            private var content: JsonField<Content> = JsonMissing.of()
                            private var role: JsonField<Role> = JsonMissing.of()
                            private var name: JsonField<String> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(unionMember1: UnionMember1) = apply {
                                this.content = unionMember1.content
                                this.role = unionMember1.role
                                this.name = unionMember1.name
                                additionalProperties(unionMember1.additionalProperties)
                            }

                            fun content(content: Content) = content(JsonField.of(content))

                            @JsonProperty("content")
                            @ExcludeMissing
                            fun content(content: JsonField<Content>) = apply {
                                this.content = content
                            }

                            fun role(role: Role) = role(JsonField.of(role))

                            @JsonProperty("role")
                            @ExcludeMissing
                            fun role(role: JsonField<Role>) = apply { this.role = role }

                            fun name(name: String) = name(JsonField.of(name))

                            @JsonProperty("name")
                            @ExcludeMissing
                            fun name(name: JsonField<String>) = apply { this.name = name }

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

                            fun build(): UnionMember1 =
                                UnionMember1(
                                    content,
                                    role,
                                    name,
                                    additionalProperties.toUnmodifiable(),
                                )
                        }

                        class Role
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

                                return other is Role && this.value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()

                            companion object {

                                val USER = Role(JsonField.of("user"))

                                fun of(value: String) = Role(JsonField.of(value))
                            }

                            enum class Known {
                                USER,
                            }

                            enum class Value {
                                USER,
                                _UNKNOWN,
                            }

                            fun value(): Value =
                                when (this) {
                                    USER -> Value.USER
                                    else -> Value._UNKNOWN
                                }

                            fun known(): Known =
                                when (this) {
                                    USER -> Known.USER
                                    else ->
                                        throw BraintrustInvalidDataException("Unknown Role: $value")
                                }

                            fun asString(): String = _value().asStringOrThrow()
                        }

                        @JsonDeserialize(using = Content.Deserializer::class)
                        @JsonSerialize(using = Content.Serializer::class)
                        class Content
                        private constructor(
                            private val string: String? = null,
                            private val unnamedSchemaWithArrayParent7s:
                                List<UnnamedSchemaWithArrayParent7>? =
                                null,
                            private val _json: JsonValue? = null,
                        ) {

                            private var validated: Boolean = false

                            fun string(): String? = string

                            fun unnamedSchemaWithArrayParent7s():
                                List<UnnamedSchemaWithArrayParent7>? =
                                unnamedSchemaWithArrayParent7s

                            fun isString(): Boolean = string != null

                            fun isUnnamedSchemaWithArrayParent7s(): Boolean =
                                unnamedSchemaWithArrayParent7s != null

                            fun asString(): String = string.getOrThrow("string")

                            fun asUnnamedSchemaWithArrayParent7s():
                                List<UnnamedSchemaWithArrayParent7> =
                                unnamedSchemaWithArrayParent7s.getOrThrow(
                                    "unnamedSchemaWithArrayParent7s"
                                )

                            fun _json(): JsonValue? = _json

                            fun <T> accept(visitor: Visitor<T>): T {
                                return when {
                                    string != null -> visitor.visitString(string)
                                    unnamedSchemaWithArrayParent7s != null ->
                                        visitor.visitUnnamedSchemaWithArrayParent7s(
                                            unnamedSchemaWithArrayParent7s
                                        )
                                    else -> visitor.unknown(_json)
                                }
                            }

                            fun validate(): Content = apply {
                                if (!validated) {
                                    if (string == null && unnamedSchemaWithArrayParent7s == null) {
                                        throw BraintrustInvalidDataException(
                                            "Unknown Content: $_json"
                                        )
                                    }
                                    validated = true
                                }
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Content &&
                                    this.string == other.string &&
                                    this.unnamedSchemaWithArrayParent7s ==
                                        other.unnamedSchemaWithArrayParent7s
                            }

                            override fun hashCode(): Int {
                                return Objects.hash(string, unnamedSchemaWithArrayParent7s)
                            }

                            override fun toString(): String {
                                return when {
                                    string != null -> "Content{string=$string}"
                                    unnamedSchemaWithArrayParent7s != null ->
                                        "Content{unnamedSchemaWithArrayParent7s=$unnamedSchemaWithArrayParent7s}"
                                    _json != null -> "Content{_unknown=$_json}"
                                    else -> throw IllegalStateException("Invalid Content")
                                }
                            }

                            companion object {

                                fun ofString(string: String) = Content(string = string)

                                fun ofUnnamedSchemaWithArrayParent7s(
                                    unnamedSchemaWithArrayParent7s:
                                        List<UnnamedSchemaWithArrayParent7>
                                ) =
                                    Content(
                                        unnamedSchemaWithArrayParent7s =
                                            unnamedSchemaWithArrayParent7s
                                    )
                            }

                            interface Visitor<out T> {

                                fun visitString(string: String): T

                                fun visitUnnamedSchemaWithArrayParent7s(
                                    unnamedSchemaWithArrayParent7s:
                                        List<UnnamedSchemaWithArrayParent7>
                                ): T

                                fun unknown(json: JsonValue?): T {
                                    throw BraintrustInvalidDataException("Unknown Content: $json")
                                }
                            }

                            class Deserializer : BaseDeserializer<Content>(Content::class) {

                                override fun ObjectCodec.deserialize(node: JsonNode): Content {
                                    val json = JsonValue.fromJsonNode(node)
                                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                        return Content(string = it, _json = json)
                                    }
                                    tryDeserialize(
                                            node,
                                            jacksonTypeRef<List<UnnamedSchemaWithArrayParent7>>()
                                        )
                                        ?.let {
                                            return Content(
                                                unnamedSchemaWithArrayParent7s = it,
                                                _json = json
                                            )
                                        }

                                    return Content(_json = json)
                                }
                            }

                            class Serializer : BaseSerializer<Content>(Content::class) {

                                override fun serialize(
                                    value: Content,
                                    generator: JsonGenerator,
                                    provider: SerializerProvider
                                ) {
                                    when {
                                        value.string != null -> generator.writeObject(value.string)
                                        value.unnamedSchemaWithArrayParent7s != null ->
                                            generator.writeObject(
                                                value.unnamedSchemaWithArrayParent7s
                                            )
                                        value._json != null -> generator.writeObject(value._json)
                                        else -> throw IllegalStateException("Invalid Content")
                                    }
                                }
                            }

                            @JsonDeserialize(
                                using = UnnamedSchemaWithArrayParent7.Deserializer::class
                            )
                            @JsonSerialize(using = UnnamedSchemaWithArrayParent7.Serializer::class)
                            class UnnamedSchemaWithArrayParent7
                            private constructor(
                                private val unionMember0: UnionMember0? = null,
                                private val unionMember1: UnionMember1? = null,
                                private val _json: JsonValue? = null,
                            ) {

                                private var validated: Boolean = false

                                fun unionMember0(): UnionMember0? = unionMember0

                                fun unionMember1(): UnionMember1? = unionMember1

                                fun isUnionMember0(): Boolean = unionMember0 != null

                                fun isUnionMember1(): Boolean = unionMember1 != null

                                fun asUnionMember0(): UnionMember0 =
                                    unionMember0.getOrThrow("unionMember0")

                                fun asUnionMember1(): UnionMember1 =
                                    unionMember1.getOrThrow("unionMember1")

                                fun _json(): JsonValue? = _json

                                fun <T> accept(visitor: Visitor<T>): T {
                                    return when {
                                        unionMember0 != null ->
                                            visitor.visitUnionMember0(unionMember0)
                                        unionMember1 != null ->
                                            visitor.visitUnionMember1(unionMember1)
                                        else -> visitor.unknown(_json)
                                    }
                                }

                                fun validate(): UnnamedSchemaWithArrayParent7 = apply {
                                    if (!validated) {
                                        if (unionMember0 == null && unionMember1 == null) {
                                            throw BraintrustInvalidDataException(
                                                "Unknown UnnamedSchemaWithArrayParent7: $_json"
                                            )
                                        }
                                        unionMember0?.validate()
                                        unionMember1?.validate()
                                        validated = true
                                    }
                                }

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is UnnamedSchemaWithArrayParent7 &&
                                        this.unionMember0 == other.unionMember0 &&
                                        this.unionMember1 == other.unionMember1
                                }

                                override fun hashCode(): Int {
                                    return Objects.hash(unionMember0, unionMember1)
                                }

                                override fun toString(): String {
                                    return when {
                                        unionMember0 != null ->
                                            "UnnamedSchemaWithArrayParent7{unionMember0=$unionMember0}"
                                        unionMember1 != null ->
                                            "UnnamedSchemaWithArrayParent7{unionMember1=$unionMember1}"
                                        _json != null ->
                                            "UnnamedSchemaWithArrayParent7{_unknown=$_json}"
                                        else ->
                                            throw IllegalStateException(
                                                "Invalid UnnamedSchemaWithArrayParent7"
                                            )
                                    }
                                }

                                companion object {

                                    fun ofUnionMember0(unionMember0: UnionMember0) =
                                        UnnamedSchemaWithArrayParent7(unionMember0 = unionMember0)

                                    fun ofUnionMember1(unionMember1: UnionMember1) =
                                        UnnamedSchemaWithArrayParent7(unionMember1 = unionMember1)
                                }

                                interface Visitor<out T> {

                                    fun visitUnionMember0(unionMember0: UnionMember0): T

                                    fun visitUnionMember1(unionMember1: UnionMember1): T

                                    fun unknown(json: JsonValue?): T {
                                        throw BraintrustInvalidDataException(
                                            "Unknown UnnamedSchemaWithArrayParent7: $json"
                                        )
                                    }
                                }

                                class Deserializer :
                                    BaseDeserializer<UnnamedSchemaWithArrayParent7>(
                                        UnnamedSchemaWithArrayParent7::class
                                    ) {

                                    override fun ObjectCodec.deserialize(
                                        node: JsonNode
                                    ): UnnamedSchemaWithArrayParent7 {
                                        val json = JsonValue.fromJsonNode(node)
                                        tryDeserialize(node, jacksonTypeRef<UnionMember0>()) {
                                                it.validate()
                                            }
                                            ?.let {
                                                return UnnamedSchemaWithArrayParent7(
                                                    unionMember0 = it,
                                                    _json = json
                                                )
                                            }
                                        tryDeserialize(node, jacksonTypeRef<UnionMember1>()) {
                                                it.validate()
                                            }
                                            ?.let {
                                                return UnnamedSchemaWithArrayParent7(
                                                    unionMember1 = it,
                                                    _json = json
                                                )
                                            }

                                        return UnnamedSchemaWithArrayParent7(_json = json)
                                    }
                                }

                                class Serializer :
                                    BaseSerializer<UnnamedSchemaWithArrayParent7>(
                                        UnnamedSchemaWithArrayParent7::class
                                    ) {

                                    override fun serialize(
                                        value: UnnamedSchemaWithArrayParent7,
                                        generator: JsonGenerator,
                                        provider: SerializerProvider
                                    ) {
                                        when {
                                            value.unionMember0 != null ->
                                                generator.writeObject(value.unionMember0)
                                            value.unionMember1 != null ->
                                                generator.writeObject(value.unionMember1)
                                            value._json != null ->
                                                generator.writeObject(value._json)
                                            else ->
                                                throw IllegalStateException(
                                                    "Invalid UnnamedSchemaWithArrayParent7"
                                                )
                                        }
                                    }
                                }

                                @JsonDeserialize(builder = UnionMember0.Builder::class)
                                @NoAutoDetect
                                class UnionMember0
                                private constructor(
                                    private val text: JsonField<String>,
                                    private val type: JsonField<Type>,
                                    private val additionalProperties: Map<String, JsonValue>,
                                ) {

                                    private var validated: Boolean = false

                                    private var hashCode: Int = 0

                                    fun text(): String? = text.getNullable("text")

                                    fun type(): Type = type.getRequired("type")

                                    @JsonProperty("text") @ExcludeMissing fun _text() = text

                                    @JsonProperty("type") @ExcludeMissing fun _type() = type

                                    @JsonAnyGetter
                                    @ExcludeMissing
                                    fun _additionalProperties(): Map<String, JsonValue> =
                                        additionalProperties

                                    fun validate(): UnionMember0 = apply {
                                        if (!validated) {
                                            text()
                                            type()
                                            validated = true
                                        }
                                    }

                                    fun toBuilder() = Builder().from(this)

                                    override fun equals(other: Any?): Boolean {
                                        if (this === other) {
                                            return true
                                        }

                                        return other is UnionMember0 &&
                                            this.text == other.text &&
                                            this.type == other.type &&
                                            this.additionalProperties == other.additionalProperties
                                    }

                                    override fun hashCode(): Int {
                                        if (hashCode == 0) {
                                            hashCode =
                                                Objects.hash(
                                                    text,
                                                    type,
                                                    additionalProperties,
                                                )
                                        }
                                        return hashCode
                                    }

                                    override fun toString() =
                                        "UnionMember0{text=$text, type=$type, additionalProperties=$additionalProperties}"

                                    companion object {

                                        fun builder() = Builder()
                                    }

                                    class Builder {

                                        private var text: JsonField<String> = JsonMissing.of()
                                        private var type: JsonField<Type> = JsonMissing.of()
                                        private var additionalProperties:
                                            MutableMap<String, JsonValue> =
                                            mutableMapOf()

                                        internal fun from(unionMember0: UnionMember0) = apply {
                                            this.text = unionMember0.text
                                            this.type = unionMember0.type
                                            additionalProperties(unionMember0.additionalProperties)
                                        }

                                        fun text(text: String) = text(JsonField.of(text))

                                        @JsonProperty("text")
                                        @ExcludeMissing
                                        fun text(text: JsonField<String>) = apply {
                                            this.text = text
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

                                        fun build(): UnionMember0 =
                                            UnionMember0(
                                                text,
                                                type,
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

                                            val TEXT = Type(JsonField.of("text"))

                                            fun of(value: String) = Type(JsonField.of(value))
                                        }

                                        enum class Known {
                                            TEXT,
                                        }

                                        enum class Value {
                                            TEXT,
                                            _UNKNOWN,
                                        }

                                        fun value(): Value =
                                            when (this) {
                                                TEXT -> Value.TEXT
                                                else -> Value._UNKNOWN
                                            }

                                        fun known(): Known =
                                            when (this) {
                                                TEXT -> Known.TEXT
                                                else ->
                                                    throw BraintrustInvalidDataException(
                                                        "Unknown Type: $value"
                                                    )
                                            }

                                        fun asString(): String = _value().asStringOrThrow()
                                    }
                                }

                                @JsonDeserialize(builder = UnionMember1.Builder::class)
                                @NoAutoDetect
                                class UnionMember1
                                private constructor(
                                    private val imageUrl: JsonField<ImageUrl>,
                                    private val type: JsonField<Type>,
                                    private val additionalProperties: Map<String, JsonValue>,
                                ) {

                                    private var validated: Boolean = false

                                    private var hashCode: Int = 0

                                    fun imageUrl(): ImageUrl = imageUrl.getRequired("image_url")

                                    fun type(): Type = type.getRequired("type")

                                    @JsonProperty("image_url")
                                    @ExcludeMissing
                                    fun _imageUrl() = imageUrl

                                    @JsonProperty("type") @ExcludeMissing fun _type() = type

                                    @JsonAnyGetter
                                    @ExcludeMissing
                                    fun _additionalProperties(): Map<String, JsonValue> =
                                        additionalProperties

                                    fun validate(): UnionMember1 = apply {
                                        if (!validated) {
                                            imageUrl().validate()
                                            type()
                                            validated = true
                                        }
                                    }

                                    fun toBuilder() = Builder().from(this)

                                    override fun equals(other: Any?): Boolean {
                                        if (this === other) {
                                            return true
                                        }

                                        return other is UnionMember1 &&
                                            this.imageUrl == other.imageUrl &&
                                            this.type == other.type &&
                                            this.additionalProperties == other.additionalProperties
                                    }

                                    override fun hashCode(): Int {
                                        if (hashCode == 0) {
                                            hashCode =
                                                Objects.hash(
                                                    imageUrl,
                                                    type,
                                                    additionalProperties,
                                                )
                                        }
                                        return hashCode
                                    }

                                    override fun toString() =
                                        "UnionMember1{imageUrl=$imageUrl, type=$type, additionalProperties=$additionalProperties}"

                                    companion object {

                                        fun builder() = Builder()
                                    }

                                    class Builder {

                                        private var imageUrl: JsonField<ImageUrl> = JsonMissing.of()
                                        private var type: JsonField<Type> = JsonMissing.of()
                                        private var additionalProperties:
                                            MutableMap<String, JsonValue> =
                                            mutableMapOf()

                                        internal fun from(unionMember1: UnionMember1) = apply {
                                            this.imageUrl = unionMember1.imageUrl
                                            this.type = unionMember1.type
                                            additionalProperties(unionMember1.additionalProperties)
                                        }

                                        fun imageUrl(imageUrl: ImageUrl) =
                                            imageUrl(JsonField.of(imageUrl))

                                        @JsonProperty("image_url")
                                        @ExcludeMissing
                                        fun imageUrl(imageUrl: JsonField<ImageUrl>) = apply {
                                            this.imageUrl = imageUrl
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

                                        fun build(): UnionMember1 =
                                            UnionMember1(
                                                imageUrl,
                                                type,
                                                additionalProperties.toUnmodifiable(),
                                            )
                                    }

                                    @JsonDeserialize(builder = ImageUrl.Builder::class)
                                    @NoAutoDetect
                                    class ImageUrl
                                    private constructor(
                                        private val url: JsonField<String>,
                                        private val detail: JsonField<Detail>,
                                        private val additionalProperties: Map<String, JsonValue>,
                                    ) {

                                        private var validated: Boolean = false

                                        private var hashCode: Int = 0

                                        fun url(): String = url.getRequired("url")

                                        fun detail(): Detail? = detail.getNullable("detail")

                                        @JsonProperty("url") @ExcludeMissing fun _url() = url

                                        @JsonProperty("detail")
                                        @ExcludeMissing
                                        fun _detail() = detail

                                        @JsonAnyGetter
                                        @ExcludeMissing
                                        fun _additionalProperties(): Map<String, JsonValue> =
                                            additionalProperties

                                        fun validate(): ImageUrl = apply {
                                            if (!validated) {
                                                url()
                                                detail()
                                                validated = true
                                            }
                                        }

                                        fun toBuilder() = Builder().from(this)

                                        override fun equals(other: Any?): Boolean {
                                            if (this === other) {
                                                return true
                                            }

                                            return other is ImageUrl &&
                                                this.url == other.url &&
                                                this.detail == other.detail &&
                                                this.additionalProperties ==
                                                    other.additionalProperties
                                        }

                                        override fun hashCode(): Int {
                                            if (hashCode == 0) {
                                                hashCode =
                                                    Objects.hash(
                                                        url,
                                                        detail,
                                                        additionalProperties,
                                                    )
                                            }
                                            return hashCode
                                        }

                                        override fun toString() =
                                            "ImageUrl{url=$url, detail=$detail, additionalProperties=$additionalProperties}"

                                        companion object {

                                            fun builder() = Builder()
                                        }

                                        class Builder {

                                            private var url: JsonField<String> = JsonMissing.of()
                                            private var detail: JsonField<Detail> = JsonMissing.of()
                                            private var additionalProperties:
                                                MutableMap<String, JsonValue> =
                                                mutableMapOf()

                                            internal fun from(imageUrl: ImageUrl) = apply {
                                                this.url = imageUrl.url
                                                this.detail = imageUrl.detail
                                                additionalProperties(imageUrl.additionalProperties)
                                            }

                                            fun url(url: String) = url(JsonField.of(url))

                                            @JsonProperty("url")
                                            @ExcludeMissing
                                            fun url(url: JsonField<String>) = apply {
                                                this.url = url
                                            }

                                            fun detail(detail: Detail) =
                                                detail(JsonField.of(detail))

                                            @JsonProperty("detail")
                                            @ExcludeMissing
                                            fun detail(detail: JsonField<Detail>) = apply {
                                                this.detail = detail
                                            }

                                            fun additionalProperties(
                                                additionalProperties: Map<String, JsonValue>
                                            ) = apply {
                                                this.additionalProperties.clear()
                                                this.additionalProperties.putAll(
                                                    additionalProperties
                                                )
                                            }

                                            @JsonAnySetter
                                            fun putAdditionalProperty(
                                                key: String,
                                                value: JsonValue
                                            ) = apply { this.additionalProperties.put(key, value) }

                                            fun putAllAdditionalProperties(
                                                additionalProperties: Map<String, JsonValue>
                                            ) = apply {
                                                this.additionalProperties.putAll(
                                                    additionalProperties
                                                )
                                            }

                                            fun build(): ImageUrl =
                                                ImageUrl(
                                                    url,
                                                    detail,
                                                    additionalProperties.toUnmodifiable(),
                                                )
                                        }

                                        class Detail
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

                                                return other is Detail && this.value == other.value
                                            }

                                            override fun hashCode() = value.hashCode()

                                            override fun toString() = value.toString()

                                            companion object {

                                                val AUTO = Detail(JsonField.of("auto"))

                                                val LOW = Detail(JsonField.of("low"))

                                                val HIGH = Detail(JsonField.of("high"))

                                                fun of(value: String) = Detail(JsonField.of(value))
                                            }

                                            enum class Known {
                                                AUTO,
                                                LOW,
                                                HIGH,
                                            }

                                            enum class Value {
                                                AUTO,
                                                LOW,
                                                HIGH,
                                                _UNKNOWN,
                                            }

                                            fun value(): Value =
                                                when (this) {
                                                    AUTO -> Value.AUTO
                                                    LOW -> Value.LOW
                                                    HIGH -> Value.HIGH
                                                    else -> Value._UNKNOWN
                                                }

                                            fun known(): Known =
                                                when (this) {
                                                    AUTO -> Known.AUTO
                                                    LOW -> Known.LOW
                                                    HIGH -> Known.HIGH
                                                    else ->
                                                        throw BraintrustInvalidDataException(
                                                            "Unknown Detail: $value"
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

                                            val IMAGE_URL = Type(JsonField.of("image_url"))

                                            fun of(value: String) = Type(JsonField.of(value))
                                        }

                                        enum class Known {
                                            IMAGE_URL,
                                        }

                                        enum class Value {
                                            IMAGE_URL,
                                            _UNKNOWN,
                                        }

                                        fun value(): Value =
                                            when (this) {
                                                IMAGE_URL -> Value.IMAGE_URL
                                                else -> Value._UNKNOWN
                                            }

                                        fun known(): Known =
                                            when (this) {
                                                IMAGE_URL -> Known.IMAGE_URL
                                                else ->
                                                    throw BraintrustInvalidDataException(
                                                        "Unknown Type: $value"
                                                    )
                                            }

                                        fun asString(): String = _value().asStringOrThrow()
                                    }
                                }
                            }
                        }
                    }

                    @JsonDeserialize(builder = UnionMember2.Builder::class)
                    @NoAutoDetect
                    class UnionMember2
                    private constructor(
                        private val role: JsonField<Role>,
                        private val content: JsonField<String>,
                        private val functionCall: JsonField<FunctionCall>,
                        private val name: JsonField<String>,
                        private val toolCalls: JsonField<List<ToolCall>>,
                        private val additionalProperties: Map<String, JsonValue>,
                    ) {

                        private var validated: Boolean = false

                        private var hashCode: Int = 0

                        fun role(): Role = role.getRequired("role")

                        fun content(): String? = content.getNullable("content")

                        fun functionCall(): FunctionCall? =
                            functionCall.getNullable("function_call")

                        fun name(): String? = name.getNullable("name")

                        fun toolCalls(): List<ToolCall>? = toolCalls.getNullable("tool_calls")

                        @JsonProperty("role") @ExcludeMissing fun _role() = role

                        @JsonProperty("content") @ExcludeMissing fun _content() = content

                        @JsonProperty("function_call")
                        @ExcludeMissing
                        fun _functionCall() = functionCall

                        @JsonProperty("name") @ExcludeMissing fun _name() = name

                        @JsonProperty("tool_calls") @ExcludeMissing fun _toolCalls() = toolCalls

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun validate(): UnionMember2 = apply {
                            if (!validated) {
                                role()
                                content()
                                functionCall()?.validate()
                                name()
                                toolCalls()?.forEach { it.validate() }
                                validated = true
                            }
                        }

                        fun toBuilder() = Builder().from(this)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is UnionMember2 &&
                                this.role == other.role &&
                                this.content == other.content &&
                                this.functionCall == other.functionCall &&
                                this.name == other.name &&
                                this.toolCalls == other.toolCalls &&
                                this.additionalProperties == other.additionalProperties
                        }

                        override fun hashCode(): Int {
                            if (hashCode == 0) {
                                hashCode =
                                    Objects.hash(
                                        role,
                                        content,
                                        functionCall,
                                        name,
                                        toolCalls,
                                        additionalProperties,
                                    )
                            }
                            return hashCode
                        }

                        override fun toString() =
                            "UnionMember2{role=$role, content=$content, functionCall=$functionCall, name=$name, toolCalls=$toolCalls, additionalProperties=$additionalProperties}"

                        companion object {

                            fun builder() = Builder()
                        }

                        class Builder {

                            private var role: JsonField<Role> = JsonMissing.of()
                            private var content: JsonField<String> = JsonMissing.of()
                            private var functionCall: JsonField<FunctionCall> = JsonMissing.of()
                            private var name: JsonField<String> = JsonMissing.of()
                            private var toolCalls: JsonField<List<ToolCall>> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(unionMember2: UnionMember2) = apply {
                                this.role = unionMember2.role
                                this.content = unionMember2.content
                                this.functionCall = unionMember2.functionCall
                                this.name = unionMember2.name
                                this.toolCalls = unionMember2.toolCalls
                                additionalProperties(unionMember2.additionalProperties)
                            }

                            fun role(role: Role) = role(JsonField.of(role))

                            @JsonProperty("role")
                            @ExcludeMissing
                            fun role(role: JsonField<Role>) = apply { this.role = role }

                            fun content(content: String) = content(JsonField.of(content))

                            @JsonProperty("content")
                            @ExcludeMissing
                            fun content(content: JsonField<String>) = apply {
                                this.content = content
                            }

                            fun functionCall(functionCall: FunctionCall) =
                                functionCall(JsonField.of(functionCall))

                            @JsonProperty("function_call")
                            @ExcludeMissing
                            fun functionCall(functionCall: JsonField<FunctionCall>) = apply {
                                this.functionCall = functionCall
                            }

                            fun name(name: String) = name(JsonField.of(name))

                            @JsonProperty("name")
                            @ExcludeMissing
                            fun name(name: JsonField<String>) = apply { this.name = name }

                            fun toolCalls(toolCalls: List<ToolCall>) =
                                toolCalls(JsonField.of(toolCalls))

                            @JsonProperty("tool_calls")
                            @ExcludeMissing
                            fun toolCalls(toolCalls: JsonField<List<ToolCall>>) = apply {
                                this.toolCalls = toolCalls
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

                            fun build(): UnionMember2 =
                                UnionMember2(
                                    role,
                                    content,
                                    functionCall,
                                    name,
                                    toolCalls.map { it.toUnmodifiable() },
                                    additionalProperties.toUnmodifiable(),
                                )
                        }

                        class Role
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

                                return other is Role && this.value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()

                            companion object {

                                val ASSISTANT = Role(JsonField.of("assistant"))

                                fun of(value: String) = Role(JsonField.of(value))
                            }

                            enum class Known {
                                ASSISTANT,
                            }

                            enum class Value {
                                ASSISTANT,
                                _UNKNOWN,
                            }

                            fun value(): Value =
                                when (this) {
                                    ASSISTANT -> Value.ASSISTANT
                                    else -> Value._UNKNOWN
                                }

                            fun known(): Known =
                                when (this) {
                                    ASSISTANT -> Known.ASSISTANT
                                    else ->
                                        throw BraintrustInvalidDataException("Unknown Role: $value")
                                }

                            fun asString(): String = _value().asStringOrThrow()
                        }

                        @JsonDeserialize(builder = FunctionCall.Builder::class)
                        @NoAutoDetect
                        class FunctionCall
                        private constructor(
                            private val arguments: JsonField<String>,
                            private val name: JsonField<String>,
                            private val additionalProperties: Map<String, JsonValue>,
                        ) {

                            private var validated: Boolean = false

                            private var hashCode: Int = 0

                            fun arguments(): String = arguments.getRequired("arguments")

                            fun name(): String = name.getRequired("name")

                            @JsonProperty("arguments") @ExcludeMissing fun _arguments() = arguments

                            @JsonProperty("name") @ExcludeMissing fun _name() = name

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            fun validate(): FunctionCall = apply {
                                if (!validated) {
                                    arguments()
                                    name()
                                    validated = true
                                }
                            }

                            fun toBuilder() = Builder().from(this)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is FunctionCall &&
                                    this.arguments == other.arguments &&
                                    this.name == other.name &&
                                    this.additionalProperties == other.additionalProperties
                            }

                            override fun hashCode(): Int {
                                if (hashCode == 0) {
                                    hashCode =
                                        Objects.hash(
                                            arguments,
                                            name,
                                            additionalProperties,
                                        )
                                }
                                return hashCode
                            }

                            override fun toString() =
                                "FunctionCall{arguments=$arguments, name=$name, additionalProperties=$additionalProperties}"

                            companion object {

                                fun builder() = Builder()
                            }

                            class Builder {

                                private var arguments: JsonField<String> = JsonMissing.of()
                                private var name: JsonField<String> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                internal fun from(functionCall: FunctionCall) = apply {
                                    this.arguments = functionCall.arguments
                                    this.name = functionCall.name
                                    additionalProperties(functionCall.additionalProperties)
                                }

                                fun arguments(arguments: String) =
                                    arguments(JsonField.of(arguments))

                                @JsonProperty("arguments")
                                @ExcludeMissing
                                fun arguments(arguments: JsonField<String>) = apply {
                                    this.arguments = arguments
                                }

                                fun name(name: String) = name(JsonField.of(name))

                                @JsonProperty("name")
                                @ExcludeMissing
                                fun name(name: JsonField<String>) = apply { this.name = name }

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

                                fun build(): FunctionCall =
                                    FunctionCall(
                                        arguments,
                                        name,
                                        additionalProperties.toUnmodifiable(),
                                    )
                            }
                        }

                        @JsonDeserialize(builder = ToolCall.Builder::class)
                        @NoAutoDetect
                        class ToolCall
                        private constructor(
                            private val id: JsonField<String>,
                            private val function: JsonField<Function>,
                            private val type: JsonField<Type>,
                            private val additionalProperties: Map<String, JsonValue>,
                        ) {

                            private var validated: Boolean = false

                            private var hashCode: Int = 0

                            fun id(): String = id.getRequired("id")

                            fun function(): Function = function.getRequired("function")

                            fun type(): Type = type.getRequired("type")

                            @JsonProperty("id") @ExcludeMissing fun _id() = id

                            @JsonProperty("function") @ExcludeMissing fun _function() = function

                            @JsonProperty("type") @ExcludeMissing fun _type() = type

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            fun validate(): ToolCall = apply {
                                if (!validated) {
                                    id()
                                    function().validate()
                                    type()
                                    validated = true
                                }
                            }

                            fun toBuilder() = Builder().from(this)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is ToolCall &&
                                    this.id == other.id &&
                                    this.function == other.function &&
                                    this.type == other.type &&
                                    this.additionalProperties == other.additionalProperties
                            }

                            override fun hashCode(): Int {
                                if (hashCode == 0) {
                                    hashCode =
                                        Objects.hash(
                                            id,
                                            function,
                                            type,
                                            additionalProperties,
                                        )
                                }
                                return hashCode
                            }

                            override fun toString() =
                                "ToolCall{id=$id, function=$function, type=$type, additionalProperties=$additionalProperties}"

                            companion object {

                                fun builder() = Builder()
                            }

                            class Builder {

                                private var id: JsonField<String> = JsonMissing.of()
                                private var function: JsonField<Function> = JsonMissing.of()
                                private var type: JsonField<Type> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                internal fun from(toolCall: ToolCall) = apply {
                                    this.id = toolCall.id
                                    this.function = toolCall.function
                                    this.type = toolCall.type
                                    additionalProperties(toolCall.additionalProperties)
                                }

                                fun id(id: String) = id(JsonField.of(id))

                                @JsonProperty("id")
                                @ExcludeMissing
                                fun id(id: JsonField<String>) = apply { this.id = id }

                                fun function(function: Function) = function(JsonField.of(function))

                                @JsonProperty("function")
                                @ExcludeMissing
                                fun function(function: JsonField<Function>) = apply {
                                    this.function = function
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
                                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                    this.additionalProperties.put(key, value)
                                }

                                fun putAllAdditionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply { this.additionalProperties.putAll(additionalProperties) }

                                fun build(): ToolCall =
                                    ToolCall(
                                        id,
                                        function,
                                        type,
                                        additionalProperties.toUnmodifiable(),
                                    )
                            }

                            @JsonDeserialize(builder = Function.Builder::class)
                            @NoAutoDetect
                            class Function
                            private constructor(
                                private val arguments: JsonField<String>,
                                private val name: JsonField<String>,
                                private val additionalProperties: Map<String, JsonValue>,
                            ) {

                                private var validated: Boolean = false

                                private var hashCode: Int = 0

                                fun arguments(): String = arguments.getRequired("arguments")

                                fun name(): String = name.getRequired("name")

                                @JsonProperty("arguments")
                                @ExcludeMissing
                                fun _arguments() = arguments

                                @JsonProperty("name") @ExcludeMissing fun _name() = name

                                @JsonAnyGetter
                                @ExcludeMissing
                                fun _additionalProperties(): Map<String, JsonValue> =
                                    additionalProperties

                                fun validate(): Function = apply {
                                    if (!validated) {
                                        arguments()
                                        name()
                                        validated = true
                                    }
                                }

                                fun toBuilder() = Builder().from(this)

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is Function &&
                                        this.arguments == other.arguments &&
                                        this.name == other.name &&
                                        this.additionalProperties == other.additionalProperties
                                }

                                override fun hashCode(): Int {
                                    if (hashCode == 0) {
                                        hashCode =
                                            Objects.hash(
                                                arguments,
                                                name,
                                                additionalProperties,
                                            )
                                    }
                                    return hashCode
                                }

                                override fun toString() =
                                    "Function{arguments=$arguments, name=$name, additionalProperties=$additionalProperties}"

                                companion object {

                                    fun builder() = Builder()
                                }

                                class Builder {

                                    private var arguments: JsonField<String> = JsonMissing.of()
                                    private var name: JsonField<String> = JsonMissing.of()
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    internal fun from(function: Function) = apply {
                                        this.arguments = function.arguments
                                        this.name = function.name
                                        additionalProperties(function.additionalProperties)
                                    }

                                    fun arguments(arguments: String) =
                                        arguments(JsonField.of(arguments))

                                    @JsonProperty("arguments")
                                    @ExcludeMissing
                                    fun arguments(arguments: JsonField<String>) = apply {
                                        this.arguments = arguments
                                    }

                                    fun name(name: String) = name(JsonField.of(name))

                                    @JsonProperty("name")
                                    @ExcludeMissing
                                    fun name(name: JsonField<String>) = apply { this.name = name }

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

                                    fun build(): Function =
                                        Function(
                                            arguments,
                                            name,
                                            additionalProperties.toUnmodifiable(),
                                        )
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

                    @JsonDeserialize(builder = UnionMember3.Builder::class)
                    @NoAutoDetect
                    class UnionMember3
                    private constructor(
                        private val content: JsonField<String>,
                        private val role: JsonField<Role>,
                        private val toolCallId: JsonField<String>,
                        private val additionalProperties: Map<String, JsonValue>,
                    ) {

                        private var validated: Boolean = false

                        private var hashCode: Int = 0

                        fun content(): String? = content.getNullable("content")

                        fun role(): Role = role.getRequired("role")

                        fun toolCallId(): String = toolCallId.getRequired("tool_call_id")

                        @JsonProperty("content") @ExcludeMissing fun _content() = content

                        @JsonProperty("role") @ExcludeMissing fun _role() = role

                        @JsonProperty("tool_call_id") @ExcludeMissing fun _toolCallId() = toolCallId

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun validate(): UnionMember3 = apply {
                            if (!validated) {
                                content()
                                role()
                                toolCallId()
                                validated = true
                            }
                        }

                        fun toBuilder() = Builder().from(this)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is UnionMember3 &&
                                this.content == other.content &&
                                this.role == other.role &&
                                this.toolCallId == other.toolCallId &&
                                this.additionalProperties == other.additionalProperties
                        }

                        override fun hashCode(): Int {
                            if (hashCode == 0) {
                                hashCode =
                                    Objects.hash(
                                        content,
                                        role,
                                        toolCallId,
                                        additionalProperties,
                                    )
                            }
                            return hashCode
                        }

                        override fun toString() =
                            "UnionMember3{content=$content, role=$role, toolCallId=$toolCallId, additionalProperties=$additionalProperties}"

                        companion object {

                            fun builder() = Builder()
                        }

                        class Builder {

                            private var content: JsonField<String> = JsonMissing.of()
                            private var role: JsonField<Role> = JsonMissing.of()
                            private var toolCallId: JsonField<String> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(unionMember3: UnionMember3) = apply {
                                this.content = unionMember3.content
                                this.role = unionMember3.role
                                this.toolCallId = unionMember3.toolCallId
                                additionalProperties(unionMember3.additionalProperties)
                            }

                            fun content(content: String) = content(JsonField.of(content))

                            @JsonProperty("content")
                            @ExcludeMissing
                            fun content(content: JsonField<String>) = apply {
                                this.content = content
                            }

                            fun role(role: Role) = role(JsonField.of(role))

                            @JsonProperty("role")
                            @ExcludeMissing
                            fun role(role: JsonField<Role>) = apply { this.role = role }

                            fun toolCallId(toolCallId: String) =
                                toolCallId(JsonField.of(toolCallId))

                            @JsonProperty("tool_call_id")
                            @ExcludeMissing
                            fun toolCallId(toolCallId: JsonField<String>) = apply {
                                this.toolCallId = toolCallId
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

                            fun build(): UnionMember3 =
                                UnionMember3(
                                    content,
                                    role,
                                    toolCallId,
                                    additionalProperties.toUnmodifiable(),
                                )
                        }

                        class Role
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

                                return other is Role && this.value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()

                            companion object {

                                val TOOL = Role(JsonField.of("tool"))

                                fun of(value: String) = Role(JsonField.of(value))
                            }

                            enum class Known {
                                TOOL,
                            }

                            enum class Value {
                                TOOL,
                                _UNKNOWN,
                            }

                            fun value(): Value =
                                when (this) {
                                    TOOL -> Value.TOOL
                                    else -> Value._UNKNOWN
                                }

                            fun known(): Known =
                                when (this) {
                                    TOOL -> Known.TOOL
                                    else ->
                                        throw BraintrustInvalidDataException("Unknown Role: $value")
                                }

                            fun asString(): String = _value().asStringOrThrow()
                        }
                    }

                    @JsonDeserialize(builder = UnionMember4.Builder::class)
                    @NoAutoDetect
                    class UnionMember4
                    private constructor(
                        private val content: JsonField<String>,
                        private val name: JsonField<String>,
                        private val role: JsonField<Role>,
                        private val additionalProperties: Map<String, JsonValue>,
                    ) {

                        private var validated: Boolean = false

                        private var hashCode: Int = 0

                        fun content(): String? = content.getNullable("content")

                        fun name(): String = name.getRequired("name")

                        fun role(): Role = role.getRequired("role")

                        @JsonProperty("content") @ExcludeMissing fun _content() = content

                        @JsonProperty("name") @ExcludeMissing fun _name() = name

                        @JsonProperty("role") @ExcludeMissing fun _role() = role

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        fun validate(): UnionMember4 = apply {
                            if (!validated) {
                                content()
                                name()
                                role()
                                validated = true
                            }
                        }

                        fun toBuilder() = Builder().from(this)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is UnionMember4 &&
                                this.content == other.content &&
                                this.name == other.name &&
                                this.role == other.role &&
                                this.additionalProperties == other.additionalProperties
                        }

                        override fun hashCode(): Int {
                            if (hashCode == 0) {
                                hashCode =
                                    Objects.hash(
                                        content,
                                        name,
                                        role,
                                        additionalProperties,
                                    )
                            }
                            return hashCode
                        }

                        override fun toString() =
                            "UnionMember4{content=$content, name=$name, role=$role, additionalProperties=$additionalProperties}"

                        companion object {

                            fun builder() = Builder()
                        }

                        class Builder {

                            private var content: JsonField<String> = JsonMissing.of()
                            private var name: JsonField<String> = JsonMissing.of()
                            private var role: JsonField<Role> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(unionMember4: UnionMember4) = apply {
                                this.content = unionMember4.content
                                this.name = unionMember4.name
                                this.role = unionMember4.role
                                additionalProperties(unionMember4.additionalProperties)
                            }

                            fun content(content: String) = content(JsonField.of(content))

                            @JsonProperty("content")
                            @ExcludeMissing
                            fun content(content: JsonField<String>) = apply {
                                this.content = content
                            }

                            fun name(name: String) = name(JsonField.of(name))

                            @JsonProperty("name")
                            @ExcludeMissing
                            fun name(name: JsonField<String>) = apply { this.name = name }

                            fun role(role: Role) = role(JsonField.of(role))

                            @JsonProperty("role")
                            @ExcludeMissing
                            fun role(role: JsonField<Role>) = apply { this.role = role }

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

                            fun build(): UnionMember4 =
                                UnionMember4(
                                    content,
                                    name,
                                    role,
                                    additionalProperties.toUnmodifiable(),
                                )
                        }

                        class Role
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

                                return other is Role && this.value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()

                            companion object {

                                val FUNCTION = Role(JsonField.of("function"))

                                fun of(value: String) = Role(JsonField.of(value))
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
                                        throw BraintrustInvalidDataException("Unknown Role: $value")
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

                        val CHAT = Type(JsonField.of("chat"))

                        fun of(value: String) = Type(JsonField.of(value))
                    }

                    enum class Known {
                        CHAT,
                    }

                    enum class Value {
                        CHAT,
                        _UNKNOWN,
                    }

                    fun value(): Value =
                        when (this) {
                            CHAT -> Value.CHAT
                            else -> Value._UNKNOWN
                        }

                    fun known(): Known =
                        when (this) {
                            CHAT -> Known.CHAT
                            else -> throw BraintrustInvalidDataException("Unknown Type: $value")
                        }

                    fun asString(): String = _value().asStringOrThrow()
                }
            }

            @JsonDeserialize(builder = _ReservedOnlyAllowNull.Builder::class)
            @NoAutoDetect
            class _ReservedOnlyAllowNull
            private constructor(
                private val _reservedOnlyAllowNull: JsonValue,
                private val additionalProperties: Map<String, JsonValue>,
            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                /**
                 * This is just a placeholder nullable object. Only pass null, not the object itself
                 */
                @JsonProperty("__reserved_only_allow_null")
                @ExcludeMissing
                fun __reservedOnlyAllowNull() = _reservedOnlyAllowNull

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): _ReservedOnlyAllowNull = apply {
                    if (!validated) {
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is _ReservedOnlyAllowNull &&
                        this._reservedOnlyAllowNull == other._reservedOnlyAllowNull &&
                        this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                    if (hashCode == 0) {
                        hashCode = Objects.hash(_reservedOnlyAllowNull, additionalProperties)
                    }
                    return hashCode
                }

                override fun toString() =
                    "_ReservedOnlyAllowNull{_reservedOnlyAllowNull=$_reservedOnlyAllowNull, additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var _reservedOnlyAllowNull: JsonValue = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(_reservedOnlyAllowNull: _ReservedOnlyAllowNull) = apply {
                        this._reservedOnlyAllowNull = _reservedOnlyAllowNull._reservedOnlyAllowNull
                        additionalProperties(_reservedOnlyAllowNull.additionalProperties)
                    }

                    /**
                     * This is just a placeholder nullable object. Only pass null, not the object
                     * itself
                     */
                    @JsonProperty("__reserved_only_allow_null")
                    @ExcludeMissing
                    fun _reservedOnlyAllowNull(_reservedOnlyAllowNull: JsonValue) = apply {
                        this._reservedOnlyAllowNull = _reservedOnlyAllowNull
                    }

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

                    fun build(): _ReservedOnlyAllowNull =
                        _ReservedOnlyAllowNull(
                            _reservedOnlyAllowNull,
                            additionalProperties.toUnmodifiable()
                        )
                }
            }
        }
    }
}
