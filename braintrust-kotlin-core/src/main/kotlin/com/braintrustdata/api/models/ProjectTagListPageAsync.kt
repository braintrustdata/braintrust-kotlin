// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.async.ProjectTagServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all project_tags. The project_tags are sorted by creation date, with the most
 * recently-created project_tags coming first
 */
class ProjectTagListPageAsync
private constructor(
    private val projectTagsService: ProjectTagServiceAsync,
    private val params: ProjectTagListParams,
    private val response: ProjectTagListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ProjectTagListPageResponse = response

    /**
     * Delegates to [ProjectTagListPageResponse], but gracefully handles missing data.
     *
     * @see [ProjectTagListPageResponse.objects]
     */
    fun objects(): List<ProjectTag> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ProjectTagListPageAsync && projectTagsService == other.projectTagsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(projectTagsService, params, response) /* spotless:on */

    override fun toString() =
        "ProjectTagListPageAsync{projectTagsService=$projectTagsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): ProjectTagListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): ProjectTagListPageAsync? {
        return getNextPageParams()?.let { projectTagsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            projectTagsService: ProjectTagServiceAsync,
            params: ProjectTagListParams,
            response: ProjectTagListPageResponse,
        ) = ProjectTagListPageAsync(projectTagsService, params, response)
    }

    class AutoPager(private val firstPage: ProjectTagListPageAsync) : Flow<ProjectTag> {

        override suspend fun collect(collector: FlowCollector<ProjectTag>) {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.objects().size) {
                    collector.emit(page.objects()[index++])
                }
                page = page.getNextPage() ?: break
                index = 0
            }
        }
    }
}
