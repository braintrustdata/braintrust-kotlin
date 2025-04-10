// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.ProjectServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/** @see [ProjectServiceAsync.list] */
class ProjectListPageAsync
private constructor(
    private val service: ProjectServiceAsync,
    private val params: ProjectListParams,
    private val response: ProjectListPageResponse,
) {

    /**
     * Delegates to [ProjectListPageResponse], but gracefully handles missing data.
     *
     * @see [ProjectListPageResponse.objects]
     */
    fun objects(): List<Project> = response._objects().getNullable("objects") ?: emptyList()

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

    suspend fun getNextPage(): ProjectListPageAsync? = getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ProjectListParams = params

    /** The response that this page was parsed from. */
    fun response(): ProjectListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ProjectListPageAsync].
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

    /** A builder for [ProjectListPageAsync]. */
    class Builder internal constructor() {

        private var service: ProjectServiceAsync? = null
        private var params: ProjectListParams? = null
        private var response: ProjectListPageResponse? = null

        internal fun from(projectListPageAsync: ProjectListPageAsync) = apply {
            service = projectListPageAsync.service
            params = projectListPageAsync.params
            response = projectListPageAsync.response
        }

        fun service(service: ProjectServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ProjectListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ProjectListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ProjectListPageAsync].
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
        fun build(): ProjectListPageAsync =
            ProjectListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ProjectListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ProjectListPageAsync{service=$service, params=$params, response=$response}"
}
