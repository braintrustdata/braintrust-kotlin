// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.ProjectTagServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/** @see [ProjectTagServiceAsync.list] */
class ProjectTagListPageAsync
private constructor(
    private val service: ProjectTagServiceAsync,
    private val params: ProjectTagListParams,
    private val response: ProjectTagListPageResponse,
) {

    /**
     * Delegates to [ProjectTagListPageResponse], but gracefully handles missing data.
     *
     * @see [ProjectTagListPageResponse.objects]
     */
    fun objects(): List<ProjectTag> = response._objects().getNullable("objects") ?: emptyList()

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

    suspend fun getNextPage(): ProjectTagListPageAsync? =
        getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ProjectTagListParams = params

    /** The response that this page was parsed from. */
    fun response(): ProjectTagListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ProjectTagListPageAsync].
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

    /** A builder for [ProjectTagListPageAsync]. */
    class Builder internal constructor() {

        private var service: ProjectTagServiceAsync? = null
        private var params: ProjectTagListParams? = null
        private var response: ProjectTagListPageResponse? = null

        internal fun from(projectTagListPageAsync: ProjectTagListPageAsync) = apply {
            service = projectTagListPageAsync.service
            params = projectTagListPageAsync.params
            response = projectTagListPageAsync.response
        }

        fun service(service: ProjectTagServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ProjectTagListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ProjectTagListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ProjectTagListPageAsync].
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
        fun build(): ProjectTagListPageAsync =
            ProjectTagListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ProjectTagListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ProjectTagListPageAsync{service=$service, params=$params, response=$response}"
}
