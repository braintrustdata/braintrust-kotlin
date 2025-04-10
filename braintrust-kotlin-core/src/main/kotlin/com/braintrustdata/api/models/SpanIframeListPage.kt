// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.blocking.SpanIframeService
import java.util.Objects

/** @see [SpanIframeService.list] */
class SpanIframeListPage
private constructor(
    private val service: SpanIframeService,
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

    fun getNextPage(): SpanIframeListPage? = getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): SpanIframeListParams = params

    /** The response that this page was parsed from. */
    fun response(): SpanIframeListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SpanIframeListPage].
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

    /** A builder for [SpanIframeListPage]. */
    class Builder internal constructor() {

        private var service: SpanIframeService? = null
        private var params: SpanIframeListParams? = null
        private var response: SpanIframeListPageResponse? = null

        internal fun from(spanIframeListPage: SpanIframeListPage) = apply {
            service = spanIframeListPage.service
            params = spanIframeListPage.params
            response = spanIframeListPage.response
        }

        fun service(service: SpanIframeService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: SpanIframeListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SpanIframeListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SpanIframeListPage].
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
        fun build(): SpanIframeListPage =
            SpanIframeListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: SpanIframeListPage) : Sequence<SpanIFrame> {

        override fun iterator(): Iterator<SpanIFrame> = iterator {
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

        return /* spotless:off */ other is SpanIframeListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "SpanIframeListPage{service=$service, params=$params, response=$response}"
}
