// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.async.SpanIframeServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all span_iframes. The span_iframes are sorted by creation date, with the most
 * recently-created span_iframes coming first
 */
class SpanIframeListPageAsync
private constructor(
    private val spanIframesService: SpanIframeServiceAsync,
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

        return /* spotless:off */ other is SpanIframeListPageAsync && spanIframesService == other.spanIframesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(spanIframesService, params, response) /* spotless:on */

    override fun toString() =
        "SpanIframeListPageAsync{spanIframesService=$spanIframesService, params=$params, response=$response}"

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

    suspend fun getNextPage(): SpanIframeListPageAsync? {
        return getNextPageParams()?.let { spanIframesService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            spanIframesService: SpanIframeServiceAsync,
            params: SpanIframeListParams,
            response: SpanIframeListPageResponse,
        ) = SpanIframeListPageAsync(spanIframesService, params, response)
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
}
