// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.blocking.DatasetService
import java.util.Objects

/** @see [DatasetService.list] */
class DatasetListPage
private constructor(
    private val service: DatasetService,
    private val params: DatasetListParams,
    private val response: DatasetListPageResponse,
) {

    /**
     * Delegates to [DatasetListPageResponse], but gracefully handles missing data.
     *
     * @see [DatasetListPageResponse.objects]
     */
    fun objects(): List<Dataset> = response._objects().getNullable("objects") ?: emptyList()

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): DatasetListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    fun getNextPage(): DatasetListPage? = getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): DatasetListParams = params

    /** The response that this page was parsed from. */
    fun response(): DatasetListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [DatasetListPage].
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

    /** A builder for [DatasetListPage]. */
    class Builder internal constructor() {

        private var service: DatasetService? = null
        private var params: DatasetListParams? = null
        private var response: DatasetListPageResponse? = null

        internal fun from(datasetListPage: DatasetListPage) = apply {
            service = datasetListPage.service
            params = datasetListPage.params
            response = datasetListPage.response
        }

        fun service(service: DatasetService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: DatasetListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: DatasetListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [DatasetListPage].
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
        fun build(): DatasetListPage =
            DatasetListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: DatasetListPage) : Sequence<Dataset> {

        override fun iterator(): Iterator<Dataset> = iterator {
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

        return /* spotless:off */ other is DatasetListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "DatasetListPage{service=$service, params=$params, response=$response}"
}
