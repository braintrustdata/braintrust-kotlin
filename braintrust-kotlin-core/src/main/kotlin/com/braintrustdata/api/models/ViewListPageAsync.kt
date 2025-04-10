// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.async.ViewServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all views. The views are sorted by creation date, with the most recently-created views
 * coming first
 */
class ViewListPageAsync
private constructor(
    private val viewsService: ViewServiceAsync,
    private val params: ViewListParams,
    private val response: ViewListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ViewListPageResponse = response

    /**
     * Delegates to [ViewListPageResponse], but gracefully handles missing data.
     *
     * @see [ViewListPageResponse.objects]
     */
    fun objects(): List<View> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ViewListPageAsync && viewsService == other.viewsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(viewsService, params, response) /* spotless:on */

    override fun toString() =
        "ViewListPageAsync{viewsService=$viewsService, params=$params, response=$response}"

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

    suspend fun getNextPage(): ViewListPageAsync? {
        return getNextPageParams()?.let { viewsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            viewsService: ViewServiceAsync,
            params: ViewListParams,
            response: ViewListPageResponse,
        ) = ViewListPageAsync(viewsService, params, response)
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
}
