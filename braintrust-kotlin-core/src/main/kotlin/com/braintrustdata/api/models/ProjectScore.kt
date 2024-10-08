// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.BaseDeserializer
import com.braintrustdata.api.core.BaseSerializer
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

/** A project score is a user-configured score, which can be manually-labeled through the UI */
@JsonDeserialize(builder = ProjectScore.Builder::class)
@NoAutoDetect
class ProjectScore
private constructor(
    private val id: JsonField<String>,
    private val projectId: JsonField<String>,
    private val userId: JsonField<String>,
    private val created: JsonField<OffsetDateTime>,
    private val name: JsonField<String>,
    private val description: JsonField<String>,
    private val scoreType: JsonField<ProjectScoreType>,
    private val categories: JsonField<Categories>,
    private val config: JsonField<ProjectScoreConfig>,
    private val position: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** Unique identifier for the project score */
    fun id(): String = id.getRequired("id")

    /** Unique identifier for the project that the project score belongs under */
    fun projectId(): String = projectId.getRequired("project_id")

    fun userId(): String = userId.getRequired("user_id")

    /** Date of project score creation */
    fun created(): OffsetDateTime? = created.getNullable("created")

    /** Name of the project score */
    fun name(): String = name.getRequired("name")

    /** Textual description of the project score */
    fun description(): String? = description.getNullable("description")

    /** The type of the configured score */
    fun scoreType(): ProjectScoreType = scoreType.getRequired("score_type")

    fun categories(): Categories? = categories.getNullable("categories")

    fun config(): ProjectScoreConfig? = config.getNullable("config")

    /** An optional LexoRank-based string that sets the sort position for the score in the UI */
    fun position(): String? = position.getNullable("position")

    /** Unique identifier for the project score */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** Unique identifier for the project that the project score belongs under */
    @JsonProperty("project_id") @ExcludeMissing fun _projectId() = projectId

    @JsonProperty("user_id") @ExcludeMissing fun _userId() = userId

    /** Date of project score creation */
    @JsonProperty("created") @ExcludeMissing fun _created() = created

    /** Name of the project score */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** Textual description of the project score */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /** The type of the configured score */
    @JsonProperty("score_type") @ExcludeMissing fun _scoreType() = scoreType

    @JsonProperty("categories") @ExcludeMissing fun _categories() = categories

    @JsonProperty("config") @ExcludeMissing fun _config() = config

    /** An optional LexoRank-based string that sets the sort position for the score in the UI */
    @JsonProperty("position") @ExcludeMissing fun _position() = position

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ProjectScore = apply {
        if (!validated) {
            id()
            projectId()
            userId()
            created()
            name()
            description()
            scoreType()
            categories()
            config()?.validate()
            position()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectScore &&
            this.id == other.id &&
            this.projectId == other.projectId &&
            this.userId == other.userId &&
            this.created == other.created &&
            this.name == other.name &&
            this.description == other.description &&
            this.scoreType == other.scoreType &&
            this.categories == other.categories &&
            this.config == other.config &&
            this.position == other.position &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    projectId,
                    userId,
                    created,
                    name,
                    description,
                    scoreType,
                    categories,
                    config,
                    position,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ProjectScore{id=$id, projectId=$projectId, userId=$userId, created=$created, name=$name, description=$description, scoreType=$scoreType, categories=$categories, config=$config, position=$position, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var projectId: JsonField<String> = JsonMissing.of()
        private var userId: JsonField<String> = JsonMissing.of()
        private var created: JsonField<OffsetDateTime> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var scoreType: JsonField<ProjectScoreType> = JsonMissing.of()
        private var categories: JsonField<Categories> = JsonMissing.of()
        private var config: JsonField<ProjectScoreConfig> = JsonMissing.of()
        private var position: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(projectScore: ProjectScore) = apply {
            this.id = projectScore.id
            this.projectId = projectScore.projectId
            this.userId = projectScore.userId
            this.created = projectScore.created
            this.name = projectScore.name
            this.description = projectScore.description
            this.scoreType = projectScore.scoreType
            this.categories = projectScore.categories
            this.config = projectScore.config
            this.position = projectScore.position
            additionalProperties(projectScore.additionalProperties)
        }

        /** Unique identifier for the project score */
        fun id(id: String) = id(JsonField.of(id))

        /** Unique identifier for the project score */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** Unique identifier for the project that the project score belongs under */
        fun projectId(projectId: String) = projectId(JsonField.of(projectId))

        /** Unique identifier for the project that the project score belongs under */
        @JsonProperty("project_id")
        @ExcludeMissing
        fun projectId(projectId: JsonField<String>) = apply { this.projectId = projectId }

        fun userId(userId: String) = userId(JsonField.of(userId))

        @JsonProperty("user_id")
        @ExcludeMissing
        fun userId(userId: JsonField<String>) = apply { this.userId = userId }

        /** Date of project score creation */
        fun created(created: OffsetDateTime) = created(JsonField.of(created))

        /** Date of project score creation */
        @JsonProperty("created")
        @ExcludeMissing
        fun created(created: JsonField<OffsetDateTime>) = apply { this.created = created }

        /** Name of the project score */
        fun name(name: String) = name(JsonField.of(name))

        /** Name of the project score */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Textual description of the project score */
        fun description(description: String) = description(JsonField.of(description))

        /** Textual description of the project score */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** The type of the configured score */
        fun scoreType(scoreType: ProjectScoreType) = scoreType(JsonField.of(scoreType))

        /** The type of the configured score */
        @JsonProperty("score_type")
        @ExcludeMissing
        fun scoreType(scoreType: JsonField<ProjectScoreType>) = apply { this.scoreType = scoreType }

        fun categories(categories: Categories) = categories(JsonField.of(categories))

        @JsonProperty("categories")
        @ExcludeMissing
        fun categories(categories: JsonField<Categories>) = apply { this.categories = categories }

        fun config(config: ProjectScoreConfig) = config(JsonField.of(config))

        @JsonProperty("config")
        @ExcludeMissing
        fun config(config: JsonField<ProjectScoreConfig>) = apply { this.config = config }

        /** An optional LexoRank-based string that sets the sort position for the score in the UI */
        fun position(position: String) = position(JsonField.of(position))

        /** An optional LexoRank-based string that sets the sort position for the score in the UI */
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

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): ProjectScore =
            ProjectScore(
                id,
                projectId,
                userId,
                created,
                name,
                description,
                scoreType,
                categories,
                config,
                position,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(using = Categories.Deserializer::class)
    @JsonSerialize(using = Categories.Serializer::class)
    class Categories
    private constructor(
        private val projectScoreCategories: List<ProjectScoreCategory>? = null,
        private val weighted: Weighted? = null,
        private val strings: List<String>? = null,
        private val nullableVariant: NullableVariant? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        /** For categorical-type project scores, the list of all categories */
        fun projectScoreCategories(): List<ProjectScoreCategory>? = projectScoreCategories
        /** For weighted-type project scores, the weights of each score */
        fun weighted(): Weighted? = weighted
        /** For minimum-type project scores, the list of included scores */
        fun strings(): List<String>? = strings

        fun nullableVariant(): NullableVariant? = nullableVariant

        fun isProjectScoreCategories(): Boolean = projectScoreCategories != null

        fun isWeighted(): Boolean = weighted != null

        fun isStrings(): Boolean = strings != null

        fun isNullableVariant(): Boolean = nullableVariant != null

        fun asProjectScoreCategories(): List<ProjectScoreCategory> =
            projectScoreCategories.getOrThrow("projectScoreCategories")

        fun asWeighted(): Weighted = weighted.getOrThrow("weighted")

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun asNullableVariant(): NullableVariant = nullableVariant.getOrThrow("nullableVariant")

        fun _json(): JsonValue? = _json

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                projectScoreCategories != null ->
                    visitor.visitProjectScoreCategories(projectScoreCategories)
                weighted != null -> visitor.visitWeighted(weighted)
                strings != null -> visitor.visitStrings(strings)
                nullableVariant != null -> visitor.visitNullableVariant(nullableVariant)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Categories = apply {
            if (!validated) {
                if (
                    projectScoreCategories == null &&
                        weighted == null &&
                        strings == null &&
                        nullableVariant == null
                ) {
                    throw BraintrustInvalidDataException("Unknown Categories: $_json")
                }
                projectScoreCategories?.forEach { it.validate() }
                weighted?.validate()
                nullableVariant?.validate()
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Categories &&
                this.projectScoreCategories == other.projectScoreCategories &&
                this.weighted == other.weighted &&
                this.strings == other.strings &&
                this.nullableVariant == other.nullableVariant
        }

        override fun hashCode(): Int {
            return Objects.hash(
                projectScoreCategories,
                weighted,
                strings,
                nullableVariant,
            )
        }

        override fun toString(): String {
            return when {
                projectScoreCategories != null ->
                    "Categories{projectScoreCategories=$projectScoreCategories}"
                weighted != null -> "Categories{weighted=$weighted}"
                strings != null -> "Categories{strings=$strings}"
                nullableVariant != null -> "Categories{nullableVariant=$nullableVariant}"
                _json != null -> "Categories{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Categories")
            }
        }

        companion object {

            fun ofProjectScoreCategories(projectScoreCategories: List<ProjectScoreCategory>) =
                Categories(projectScoreCategories = projectScoreCategories)

            fun ofWeighted(weighted: Weighted) = Categories(weighted = weighted)

            fun ofStrings(strings: List<String>) = Categories(strings = strings)

            fun ofNullableVariant(nullableVariant: NullableVariant) =
                Categories(nullableVariant = nullableVariant)
        }

        interface Visitor<out T> {

            fun visitProjectScoreCategories(projectScoreCategories: List<ProjectScoreCategory>): T

            fun visitWeighted(weighted: Weighted): T

            fun visitStrings(strings: List<String>): T

            fun visitNullableVariant(nullableVariant: NullableVariant): T

            fun unknown(json: JsonValue?): T {
                throw BraintrustInvalidDataException("Unknown Categories: $json")
            }
        }

        class Deserializer : BaseDeserializer<Categories>(Categories::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Categories {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<List<ProjectScoreCategory>>()) {
                        it.forEach { it.validate() }
                    }
                    ?.let {
                        return Categories(projectScoreCategories = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<Weighted>()) { it.validate() }
                    ?.let {
                        return Categories(weighted = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return Categories(strings = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<NullableVariant>()) { it.validate() }
                    ?.let {
                        return Categories(nullableVariant = it, _json = json)
                    }

                return Categories(_json = json)
            }
        }

        class Serializer : BaseSerializer<Categories>(Categories::class) {

            override fun serialize(
                value: Categories,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.projectScoreCategories != null ->
                        generator.writeObject(value.projectScoreCategories)
                    value.weighted != null -> generator.writeObject(value.weighted)
                    value.strings != null -> generator.writeObject(value.strings)
                    value.nullableVariant != null -> generator.writeObject(value.nullableVariant)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Categories")
                }
            }
        }

        /** For weighted-type project scores, the weights of each score */
        @JsonDeserialize(builder = Weighted.Builder::class)
        @NoAutoDetect
        class Weighted
        private constructor(
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): Weighted = apply {
                if (!validated) {
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Weighted && this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode = Objects.hash(additionalProperties)
                }
                return hashCode
            }

            override fun toString() = "Weighted{additionalProperties=$additionalProperties}"

            companion object {

                fun builder() = Builder()
            }

            class Builder {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(weighted: Weighted) = apply {
                    additionalProperties(weighted.additionalProperties)
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

                fun build(): Weighted = Weighted(additionalProperties.toUnmodifiable())
            }
        }

        @JsonDeserialize(builder = NullableVariant.Builder::class)
        @NoAutoDetect
        class NullableVariant
        private constructor(
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): NullableVariant = apply {
                if (!validated) {
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is NullableVariant &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode = Objects.hash(additionalProperties)
                }
                return hashCode
            }

            override fun toString() = "NullableVariant{additionalProperties=$additionalProperties}"

            companion object {

                fun builder() = Builder()
            }

            class Builder {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(nullableVariant: NullableVariant) = apply {
                    additionalProperties(nullableVariant.additionalProperties)
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

                fun build(): NullableVariant =
                    NullableVariant(additionalProperties.toUnmodifiable())
            }
        }
    }
}
