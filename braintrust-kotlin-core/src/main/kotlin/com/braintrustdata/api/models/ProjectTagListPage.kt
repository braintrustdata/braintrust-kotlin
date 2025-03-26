// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.ExcludeMissing
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.JsonMissing
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.services.blocking.ProjectTagService
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects

/**
 * List out all project_tags. The project_tags are sorted by creation date, with the most
 * recently-created project_tags coming first
 */
class ProjectTagListPage
private constructor(
    private val projectTagsService: ProjectTagService,
    private val params: ProjectTagListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun objects(): List<ProjectTag> = response().objects()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ProjectTagListPage && projectTagsService == other.projectTagsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(projectTagsService, params, response) /* spotless:on */

    override fun toString() =
        "ProjectTagListPage{projectTagsService=$projectTagsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !objects().isEmpty()
    }

    fun getNextPageParams(): ProjectTagListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            ProjectTagListParams.builder().from(params).endingBefore(objects().first().id()).build()
        } else {
            ProjectTagListParams.builder().from(params).startingAfter(objects().last().id()).build()
        }
    }

    fun getNextPage(): ProjectTagListPage? {
        return getNextPageParams()?.let { projectTagsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            projectTagsService: ProjectTagService,
            params: ProjectTagListParams,
            response: Response,
        ) = ProjectTagListPage(projectTagsService, params, response)
    }

    class Response(
        private val objects: JsonField<List<ProjectTag>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("objects") objects: JsonField<List<ProjectTag>> = JsonMissing.of()
        ) : this(objects, mutableMapOf())

        fun objects(): List<ProjectTag> = objects.getNullable("objects") ?: listOf()

        @JsonProperty("objects") fun _objects(): JsonField<List<ProjectTag>>? = objects

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            objects().map { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && objects == other.objects && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(objects, additionalProperties) /* spotless:on */

        override fun toString() =
            "Response{objects=$objects, additionalProperties=$additionalProperties}"

        companion object {

            /** Returns a mutable builder for constructing an instance of [ProjectTagListPage]. */
            fun builder() = Builder()
        }

        class Builder {

            private var objects: JsonField<List<ProjectTag>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(page: Response) = apply {
                this.objects = page.objects
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun objects(objects: List<ProjectTag>) = objects(JsonField.of(objects))

            fun objects(objects: JsonField<List<ProjectTag>>) = apply { this.objects = objects }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable instance of [Response].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Response = Response(objects, additionalProperties.toMutableMap())
        }
    }

    class AutoPager(private val firstPage: ProjectTagListPage) : Sequence<ProjectTag> {

        override fun iterator(): Iterator<ProjectTag> = iterator {
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
