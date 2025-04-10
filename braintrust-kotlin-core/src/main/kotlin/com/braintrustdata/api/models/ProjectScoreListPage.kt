// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.blocking.ProjectScoreService
import java.util.Objects

/** @see [ProjectScoreService.list] */
class ProjectScoreListPage
private constructor(
    private val service: ProjectScoreService,
    private val params: ProjectScoreListParams,
    private val response: ProjectScoreListPageResponse,
) {

    /**
     * Delegates to [ProjectScoreListPageResponse], but gracefully handles missing data.
     *
     * @see [ProjectScoreListPageResponse.objects]
     */
    fun objects(): List<ProjectScore> = response._objects().getNullable("objects") ?: emptyList()

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

    fun getNextPage(): ProjectScoreListPage? = getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ProjectScoreListParams = params

    /** The response that this page was parsed from. */
    fun response(): ProjectScoreListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ProjectScoreListPage].
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

    /** A builder for [ProjectScoreListPage]. */
    class Builder internal constructor() {

        private var service: ProjectScoreService? = null
        private var params: ProjectScoreListParams? = null
        private var response: ProjectScoreListPageResponse? = null

        internal fun from(projectScoreListPage: ProjectScoreListPage) = apply {
            service = projectScoreListPage.service
            params = projectScoreListPage.params
            response = projectScoreListPage.response
        }

        fun service(service: ProjectScoreService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ProjectScoreListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ProjectScoreListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ProjectScoreListPage].
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
        fun build(): ProjectScoreListPage =
            ProjectScoreListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: ProjectScoreListPage) : Sequence<ProjectScore> {

        override fun iterator(): Iterator<ProjectScore> = iterator {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ProjectScoreListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ProjectScoreListPage{service=$service, params=$params, response=$response}"
}
