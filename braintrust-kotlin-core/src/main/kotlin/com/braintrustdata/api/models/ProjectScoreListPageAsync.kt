// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.AutoPagerAsync
import com.braintrustdata.api.core.PageAsync
import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.ProjectScoreServiceAsync
import java.util.Objects

/** @see ProjectScoreServiceAsync.list */
class ProjectScoreListPageAsync
private constructor(
    private val service: ProjectScoreServiceAsync,
    private val params: ProjectScoreListParams,
    private val response: ProjectScoreListPageResponse,
) : PageAsync<ProjectScore> {

    /**
     * Delegates to [ProjectScoreListPageResponse], but gracefully handles missing data.
     *
     * @see ProjectScoreListPageResponse.objects
     */
    fun objects(): List<ProjectScore> = response._objects().getNullable("objects") ?: emptyList()

    override fun items(): List<ProjectScore> = objects()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ProjectScoreListParams =
        if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(items().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(items().last()._id().getNullable("id")).build()
        }

    override suspend fun nextPage(): ProjectScoreListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<ProjectScore> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ProjectScoreListParams = params

    /** The response that this page was parsed from. */
    fun response(): ProjectScoreListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ProjectScoreListPageAsync].
         *
         * The following fields are required:
         * ```kotlin
         * .service()
         * .params()
         * .response()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [ProjectScoreListPageAsync]. */
    class Builder internal constructor() {

        private var service: ProjectScoreServiceAsync? = null
        private var params: ProjectScoreListParams? = null
        private var response: ProjectScoreListPageResponse? = null

        internal fun from(projectScoreListPageAsync: ProjectScoreListPageAsync) = apply {
            service = projectScoreListPageAsync.service
            params = projectScoreListPageAsync.params
            response = projectScoreListPageAsync.response
        }

        fun service(service: ProjectScoreServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ProjectScoreListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ProjectScoreListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ProjectScoreListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ProjectScoreListPageAsync =
            ProjectScoreListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ProjectScoreListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ProjectScoreListPageAsync{service=$service, params=$params, response=$response}"
}
