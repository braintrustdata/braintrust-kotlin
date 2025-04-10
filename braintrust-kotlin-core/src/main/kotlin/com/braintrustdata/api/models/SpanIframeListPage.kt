// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.blocking.SpanIframeService
import java.util.Objects

/**
 * List out all span_iframes. The span_iframes are sorted by creation date, with the most
 * recently-created span_iframes coming first
 */
class SpanIframeListPage
private constructor(
    private val spanIframesService: SpanIframeService,
    private val params: SpanIframeListParams,
    private val response: SpanIframeListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): SpanIframeListPageResponse = response

    /**
     * Delegates to [SpanIframeListPageResponse], but gracefully handles missing data.
     *
     * @see [SpanIframeListPageResponse.objects]
     */
    fun objects(): List<SpanIFrame> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SpanIframeListPage && spanIframesService == other.spanIframesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(spanIframesService, params, response) /* spotless:on */

    override fun toString() =
        "SpanIframeListPage{spanIframesService=$spanIframesService, params=$params, response=$response}"

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

    fun getNextPage(): SpanIframeListPage? {
        return getNextPageParams()?.let { spanIframesService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            spanIframesService: SpanIframeService,
            params: SpanIframeListParams,
            response: SpanIframeListPageResponse,
        ) = SpanIframeListPage(spanIframesService, params, response)
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
}
