// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.async.ProjectScoreServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all project_scores. The project_scores are sorted by creation date, with the most
 * recently-created project_scores coming first
 */
class ProjectScoreListPageAsync
private constructor(
    private val projectScoresService: ProjectScoreServiceAsync,
    private val params: ProjectScoreListParams,
    private val response: ProjectScoreListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ProjectScoreListPageResponse = response

    /**
     * Delegates to [ProjectScoreListPageResponse], but gracefully handles missing data.
     *
     * @see [ProjectScoreListPageResponse.objects]
     */
    fun objects(): List<ProjectScore> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ProjectScoreListPageAsync && projectScoresService == other.projectScoresService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(projectScoresService, params, response) /* spotless:on */

    override fun toString() =
        "ProjectScoreListPageAsync{projectScoresService=$projectScoresService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): ProjectScoreListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): ProjectScoreListPageAsync? {
        return getNextPageParams()?.let { projectScoresService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            projectScoresService: ProjectScoreServiceAsync,
            params: ProjectScoreListParams,
            response: ProjectScoreListPageResponse,
        ) = ProjectScoreListPageAsync(projectScoresService, params, response)
    }

    class AutoPager(private val firstPage: ProjectScoreListPageAsync) : Flow<ProjectScore> {

        override suspend fun collect(collector: FlowCollector<ProjectScore>) {
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
