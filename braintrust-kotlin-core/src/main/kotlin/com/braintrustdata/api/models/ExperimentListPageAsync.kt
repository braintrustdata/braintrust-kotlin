// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.ExperimentServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/** @see [ExperimentServiceAsync.list] */
class ExperimentListPageAsync
private constructor(
    private val service: ExperimentServiceAsync,
    private val params: ExperimentListParams,
    private val response: ExperimentListPageResponse,
) {

    /**
     * Delegates to [ExperimentListPageResponse], but gracefully handles missing data.
     *
     * @see [ExperimentListPageResponse.objects]
     */
    fun objects(): List<Experiment> = response._objects().getNullable("objects") ?: emptyList()

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): ExperimentListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): ExperimentListPageAsync? =
        getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ExperimentListParams = params

    /** The response that this page was parsed from. */
    fun response(): ExperimentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExperimentListPageAsync].
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

    /** A builder for [ExperimentListPageAsync]. */
    class Builder internal constructor() {

        private var service: ExperimentServiceAsync? = null
        private var params: ExperimentListParams? = null
        private var response: ExperimentListPageResponse? = null

        internal fun from(experimentListPageAsync: ExperimentListPageAsync) = apply {
            service = experimentListPageAsync.service
            params = experimentListPageAsync.params
            response = experimentListPageAsync.response
        }

        fun service(service: ExperimentServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ExperimentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ExperimentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ExperimentListPageAsync].
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
        fun build(): ExperimentListPageAsync =
            ExperimentListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: ExperimentListPageAsync) : Flow<Experiment> {

        override suspend fun collect(collector: FlowCollector<Experiment>) {
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

        return /* spotless:off */ other is ExperimentListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ExperimentListPageAsync{service=$service, params=$params, response=$response}"
}
