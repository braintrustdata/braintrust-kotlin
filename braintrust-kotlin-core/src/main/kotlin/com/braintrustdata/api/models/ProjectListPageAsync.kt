// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.async.ProjectServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all projects. The projects are sorted by creation date, with the most recently-created
 * projects coming first
 */
class ProjectListPageAsync
private constructor(
    private val projectsService: ProjectServiceAsync,
    private val params: ProjectListParams,
    private val response: ProjectListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ProjectListPageResponse = response

    /**
     * Delegates to [ProjectListPageResponse], but gracefully handles missing data.
     *
     * @see [ProjectListPageResponse.objects]
     */
    fun objects(): List<Project> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ProjectListPageAsync && projectsService == other.projectsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(projectsService, params, response) /* spotless:on */

    override fun toString() =
        "ProjectListPageAsync{projectsService=$projectsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): ProjectListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): ProjectListPageAsync? {
        return getNextPageParams()?.let { projectsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            projectsService: ProjectServiceAsync,
            params: ProjectListParams,
            response: ProjectListPageResponse,
        ) = ProjectListPageAsync(projectsService, params, response)
    }

    class AutoPager(private val firstPage: ProjectListPageAsync) : Flow<Project> {

        override suspend fun collect(collector: FlowCollector<Project>) {
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
