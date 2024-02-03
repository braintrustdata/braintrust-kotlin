// File generated from our OpenAPI spec by Stainless.

package com.braintrust.api.models

import com.braintrust.api.core.ExcludeMissing
import com.braintrust.api.core.JsonField
import com.braintrust.api.core.JsonMissing
import com.braintrust.api.core.JsonValue
import com.braintrust.api.core.NoAutoDetect
import com.braintrust.api.core.toUnmodifiable
import com.braintrust.api.services.blocking.ProjectService
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects

class ProjectListPage
private constructor(
    private val projectService: ProjectService,
    private val params: ProjectListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun objects(): List<Project> = response().objects()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectListPage &&
            this.projectService == other.projectService &&
            this.params == other.params &&
            this.response == other.response
    }

    override fun hashCode(): Int {
        return Objects.hash(
            projectService,
            params,
            response,
        )
    }

    override fun toString() =
        "ProjectListPage{projectService=$projectService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !objects().isEmpty()
    }

    fun getNextPageParams(): ProjectListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            ProjectListParams.builder().from(params).endingBefore(objects().first().id()).build()
        } else {
            ProjectListParams.builder().from(params).startingAfter(objects().last().id()).build()
        }
    }

    fun getNextPage(): ProjectListPage? {
        return getNextPageParams()?.let { projectService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(projectService: ProjectService, params: ProjectListParams, response: Response) =
            ProjectListPage(
                projectService,
                params,
                response,
            )
    }

    @JsonDeserialize(builder = Response.Builder::class)
    @NoAutoDetect
    class Response
    constructor(
        private val objects: JsonField<List<Project>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun objects(): List<Project> = objects.getNullable("objects") ?: listOf()

        @JsonProperty("objects") fun _objects(): JsonField<List<Project>>? = objects

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Response = apply {
            if (!validated) {
                objects().map { it.validate() }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Response &&
                this.objects == other.objects &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            return Objects.hash(objects, additionalProperties)
        }

        override fun toString() =
            "ProjectListPage.Response{objects=$objects, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var objects: JsonField<List<Project>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(page: Response) = apply {
                this.objects = page.objects
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun objects(objects: List<Project>) = objects(JsonField.of(objects))

            @JsonProperty("objects")
            fun objects(objects: JsonField<List<Project>>) = apply { this.objects = objects }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(objects, additionalProperties.toUnmodifiable())
        }
    }

    class AutoPager
    constructor(
        private val firstPage: ProjectListPage,
    ) : Sequence<Project> {

        override fun iterator(): Iterator<Project> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.objects().size) {
                    yield(page.objects()[index++])
                }
                page = page.getNextPage() ?: break
                index = 0
            }
        }
    }
}
