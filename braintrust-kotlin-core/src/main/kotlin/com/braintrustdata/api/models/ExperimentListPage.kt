// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.blocking.ExperimentService
import java.util.Objects

/** @see [ExperimentService.list] */
class ExperimentListPage
private constructor(
    private val service: ExperimentService,
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

    fun getNextPage(): ExperimentListPage? = getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ExperimentListParams = params

    /** The response that this page was parsed from. */
    fun response(): ExperimentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExperimentListPage].
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

    /** A builder for [ExperimentListPage]. */
    class Builder internal constructor() {

        private var service: ExperimentService? = null
        private var params: ExperimentListParams? = null
        private var response: ExperimentListPageResponse? = null

        internal fun from(experimentListPage: ExperimentListPage) = apply {
            service = experimentListPage.service
            params = experimentListPage.params
            response = experimentListPage.response
        }

        fun service(service: ExperimentService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ExperimentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ExperimentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ExperimentListPage].
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
        fun build(): ExperimentListPage =
            ExperimentListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: ExperimentListPage) : Sequence<Experiment> {

        override fun iterator(): Iterator<Experiment> = iterator {
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

        return /* spotless:off */ other is ExperimentListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ExperimentListPage{service=$service, params=$params, response=$response}"
}
