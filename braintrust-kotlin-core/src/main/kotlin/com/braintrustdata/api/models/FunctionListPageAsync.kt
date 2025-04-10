// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.FunctionServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/** @see [FunctionServiceAsync.list] */
class FunctionListPageAsync
private constructor(
    private val service: FunctionServiceAsync,
    private val params: FunctionListParams,
    private val response: FunctionListPageResponse,
) {

    /**
     * Delegates to [FunctionListPageResponse], but gracefully handles missing data.
     *
     * @see [FunctionListPageResponse.objects]
     */
    fun objects(): List<Function> = response._objects().getNullable("objects") ?: emptyList()

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): FunctionListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): FunctionListPageAsync? =
        getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): FunctionListParams = params

    /** The response that this page was parsed from. */
    fun response(): FunctionListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FunctionListPageAsync].
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

    /** A builder for [FunctionListPageAsync]. */
    class Builder internal constructor() {

        private var service: FunctionServiceAsync? = null
        private var params: FunctionListParams? = null
        private var response: FunctionListPageResponse? = null

        internal fun from(functionListPageAsync: FunctionListPageAsync) = apply {
            service = functionListPageAsync.service
            params = functionListPageAsync.params
            response = functionListPageAsync.response
        }

        fun service(service: FunctionServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: FunctionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FunctionListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FunctionListPageAsync].
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
        fun build(): FunctionListPageAsync =
            FunctionListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: FunctionListPageAsync) : Flow<Function> {

        override suspend fun collect(collector: FlowCollector<Function>) {
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

        return /* spotless:off */ other is FunctionListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "FunctionListPageAsync{service=$service, params=$params, response=$response}"
}
