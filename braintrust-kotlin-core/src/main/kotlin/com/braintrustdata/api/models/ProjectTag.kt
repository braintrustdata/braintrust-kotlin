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

/**
 * A project tag is a user-configured tag for tracking and filtering your experiments, logs, and
 * other data
 */
@JsonDeserialize(builder = ProjectTag.Builder::class)
@NoAutoDetect
class ProjectTag
private constructor(
    private val id: JsonField<String>,
    private val projectId: JsonField<String>,
    private val userId: JsonField<String>,
    private val created: JsonField<OffsetDateTime>,
    private val name: JsonField<String>,
    private val description: JsonField<String>,
    private val color: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** Unique identifier for the project tag */
    fun id(): String = id.getRequired("id")

    /** Unique identifier for the project that the project tag belongs under */
    fun projectId(): String = projectId.getRequired("project_id")

    fun userId(): String = userId.getRequired("user_id")

    /** Date of project tag creation */
    fun created(): OffsetDateTime? = created.getNullable("created")

    /** Name of the project tag */
    fun name(): String = name.getRequired("name")

    /** Textual description of the project tag */
    fun description(): String? = description.getNullable("description")

    /** Color of the tag for the UI */
    fun color(): String? = color.getNullable("color")

    /** Unique identifier for the project tag */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** Unique identifier for the project that the project tag belongs under */
    @JsonProperty("project_id") @ExcludeMissing fun _projectId() = projectId

    @JsonProperty("user_id") @ExcludeMissing fun _userId() = userId

    /** Date of project tag creation */
    @JsonProperty("created") @ExcludeMissing fun _created() = created

    /** Name of the project tag */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** Textual description of the project tag */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /** Color of the tag for the UI */
    @JsonProperty("color") @ExcludeMissing fun _color() = color

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ProjectTag = apply {
        if (!validated) {
            id()
            projectId()
            userId()
            created()
            name()
            description()
            color()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectTag &&
            this.id == other.id &&
            this.projectId == other.projectId &&
            this.userId == other.userId &&
            this.created == other.created &&
            this.name == other.name &&
            this.description == other.description &&
            this.color == other.color &&
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
                    color,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "ProjectTag{id=$id, projectId=$projectId, userId=$userId, created=$created, name=$name, description=$description, color=$color, additionalProperties=$additionalProperties}"

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
        private var color: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(projectTag: ProjectTag) = apply {
            this.id = projectTag.id
            this.projectId = projectTag.projectId
            this.userId = projectTag.userId
            this.created = projectTag.created
            this.name = projectTag.name
            this.description = projectTag.description
            this.color = projectTag.color
            additionalProperties(projectTag.additionalProperties)
        }

        /** Unique identifier for the project tag */
        fun id(id: String) = id(JsonField.of(id))

        /** Unique identifier for the project tag */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** Unique identifier for the project that the project tag belongs under */
        fun projectId(projectId: String) = projectId(JsonField.of(projectId))

        /** Unique identifier for the project that the project tag belongs under */
        @JsonProperty("project_id")
        @ExcludeMissing
        fun projectId(projectId: JsonField<String>) = apply { this.projectId = projectId }

        fun userId(userId: String) = userId(JsonField.of(userId))

        @JsonProperty("user_id")
        @ExcludeMissing
        fun userId(userId: JsonField<String>) = apply { this.userId = userId }

        /** Date of project tag creation */
        fun created(created: OffsetDateTime) = created(JsonField.of(created))

        /** Date of project tag creation */
        @JsonProperty("created")
        @ExcludeMissing
        fun created(created: JsonField<OffsetDateTime>) = apply { this.created = created }

        /** Name of the project tag */
        fun name(name: String) = name(JsonField.of(name))

        /** Name of the project tag */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Textual description of the project tag */
        fun description(description: String) = description(JsonField.of(description))

        /** Textual description of the project tag */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Color of the tag for the UI */
        fun color(color: String) = color(JsonField.of(color))

        /** Color of the tag for the UI */
        @JsonProperty("color")
        @ExcludeMissing
        fun color(color: JsonField<String>) = apply { this.color = color }

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

        fun build(): ProjectTag =
            ProjectTag(
                id,
                projectId,
                userId,
                created,
                name,
                description,
                color,
                additionalProperties.toUnmodifiable(),
            )
    }
}
