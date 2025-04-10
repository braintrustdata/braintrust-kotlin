// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.async.FunctionServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all functions. The functions are sorted by creation date, with the most recently-created
 * functions coming first
 */
class FunctionListPageAsync
private constructor(
    private val functionsService: FunctionServiceAsync,
    private val params: FunctionListParams,
    private val response: FunctionListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): FunctionListPageResponse = response

    /**
     * Delegates to [FunctionListPageResponse], but gracefully handles missing data.
     *
     * @see [FunctionListPageResponse.objects]
     */
    fun objects(): List<Function> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FunctionListPageAsync && functionsService == other.functionsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(functionsService, params, response) /* spotless:on */

    override fun toString() =
        "FunctionListPageAsync{functionsService=$functionsService, params=$params, response=$response}"

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

    suspend fun getNextPage(): FunctionListPageAsync? {
        return getNextPageParams()?.let { functionsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            functionsService: FunctionServiceAsync,
            params: FunctionListParams,
            response: FunctionListPageResponse,
        ) = FunctionListPageAsync(functionsService, params, response)
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
}
