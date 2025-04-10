// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.SpanIframeServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/** @see [SpanIframeServiceAsync.list] */
class SpanIframeListPageAsync
private constructor(
    private val service: SpanIframeServiceAsync,
    private val params: SpanIframeListParams,
    private val response: SpanIframeListPageResponse,
) {

    /**
     * Delegates to [SpanIframeListPageResponse], but gracefully handles missing data.
     *
     * @see [SpanIframeListPageResponse.objects]
     */
    fun objects(): List<SpanIFrame> = response._objects().getNullable("objects") ?: emptyList()

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): SpanIframeListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): SpanIframeListPageAsync? =
        getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): SpanIframeListParams = params

    /** The response that this page was parsed from. */
    fun response(): SpanIframeListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SpanIframeListPageAsync].
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

    /** A builder for [SpanIframeListPageAsync]. */
    class Builder internal constructor() {

        private var service: SpanIframeServiceAsync? = null
        private var params: SpanIframeListParams? = null
        private var response: SpanIframeListPageResponse? = null

        internal fun from(spanIframeListPageAsync: SpanIframeListPageAsync) = apply {
            service = spanIframeListPageAsync.service
            params = spanIframeListPageAsync.params
            response = spanIframeListPageAsync.response
        }

        fun service(service: SpanIframeServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: SpanIframeListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SpanIframeListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SpanIframeListPageAsync].
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
        fun build(): SpanIframeListPageAsync =
            SpanIframeListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: SpanIframeListPageAsync) : Flow<SpanIFrame> {

        override suspend fun collect(collector: FlowCollector<SpanIFrame>) {
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

        return /* spotless:off */ other is SpanIframeListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "SpanIframeListPageAsync{service=$service, params=$params, response=$response}"
}
