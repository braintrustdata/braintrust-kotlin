// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.AutoPagerAsync
import com.braintrustdata.api.core.PageAsync
import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.DatasetServiceAsync
import java.util.Objects

/** @see DatasetServiceAsync.list */
class DatasetListPageAsync
private constructor(
    private val service: DatasetServiceAsync,
    private val params: DatasetListParams,
    private val response: DatasetListPageResponse,
) : PageAsync<Dataset> {

    /**
     * Delegates to [DatasetListPageResponse], but gracefully handles missing data.
     *
     * @see DatasetListPageResponse.objects
     */
    fun objects(): List<Dataset> = response._objects().getNullable("objects") ?: emptyList()

    override fun items(): List<Dataset> = objects()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): DatasetListParams =
        if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(items().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(items().last()._id().getNullable("id")).build()
        }

    override suspend fun nextPage(): DatasetListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Dataset> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): DatasetListParams = params

    /** The response that this page was parsed from. */
    fun response(): DatasetListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [DatasetListPageAsync].
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

    /** A builder for [DatasetListPageAsync]. */
    class Builder internal constructor() {

        private var service: DatasetServiceAsync? = null
        private var params: DatasetListParams? = null
        private var response: DatasetListPageResponse? = null

        internal fun from(datasetListPageAsync: DatasetListPageAsync) = apply {
            service = datasetListPageAsync.service
            params = datasetListPageAsync.params
            response = datasetListPageAsync.response
        }

        fun service(service: DatasetServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: DatasetListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: DatasetListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [DatasetListPageAsync].
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
        fun build(): DatasetListPageAsync =
            DatasetListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DatasetListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "DatasetListPageAsync{service=$service, params=$params, response=$response}"
}
