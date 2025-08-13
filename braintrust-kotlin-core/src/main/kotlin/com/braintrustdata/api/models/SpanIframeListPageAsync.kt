// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.AutoPagerAsync
import com.braintrustdata.api.core.PageAsync
import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.SpanIframeServiceAsync
import java.util.Objects

/** @see SpanIframeServiceAsync.list */
class SpanIframeListPageAsync
private constructor(
    private val service: SpanIframeServiceAsync,
    private val params: SpanIframeListParams,
    private val response: SpanIframeListPageResponse,
) : PageAsync<SpanIFrame> {

    /**
     * Delegates to [SpanIframeListPageResponse], but gracefully handles missing data.
     *
     * @see SpanIframeListPageResponse.objects
     */
    fun objects(): List<SpanIFrame> = response._objects().getNullable("objects") ?: emptyList()

    override fun items(): List<SpanIFrame> = objects()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): SpanIframeListParams =
        if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(items().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(items().last()._id().getNullable("id")).build()
        }

    override suspend fun nextPage(): SpanIframeListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<SpanIFrame> = AutoPagerAsync.from(this)

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SpanIframeListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "SpanIframeListPageAsync{service=$service, params=$params, response=$response}"
}
