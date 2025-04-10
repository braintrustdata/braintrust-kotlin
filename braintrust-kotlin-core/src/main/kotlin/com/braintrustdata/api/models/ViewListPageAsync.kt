// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.ViewServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/** @see [ViewServiceAsync.list] */
class ViewListPageAsync
private constructor(
    private val service: ViewServiceAsync,
    private val params: ViewListParams,
    private val response: ViewListPageResponse,
) {

    /**
     * Delegates to [ViewListPageResponse], but gracefully handles missing data.
     *
     * @see [ViewListPageResponse.objects]
     */
    fun objects(): List<View> = response._objects().getNullable("objects") ?: emptyList()

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): ViewListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): ViewListPageAsync? = getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ViewListParams = params

    /** The response that this page was parsed from. */
    fun response(): ViewListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ViewListPageAsync].
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

    /** A builder for [ViewListPageAsync]. */
    class Builder internal constructor() {

        private var service: ViewServiceAsync? = null
        private var params: ViewListParams? = null
        private var response: ViewListPageResponse? = null

        internal fun from(viewListPageAsync: ViewListPageAsync) = apply {
            service = viewListPageAsync.service
            params = viewListPageAsync.params
            response = viewListPageAsync.response
        }

        fun service(service: ViewServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ViewListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ViewListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ViewListPageAsync].
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
        fun build(): ViewListPageAsync =
            ViewListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: ViewListPageAsync) : Flow<View> {

        override suspend fun collect(collector: FlowCollector<View>) {
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

        return /* spotless:off */ other is ViewListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ViewListPageAsync{service=$service, params=$params, response=$response}"
}
