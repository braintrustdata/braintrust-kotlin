// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.async.DatasetServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all datasets. The datasets are sorted by creation date, with the most recently-created
 * datasets coming first
 */
class DatasetListPageAsync
private constructor(
    private val datasetsService: DatasetServiceAsync,
    private val params: DatasetListParams,
    private val response: DatasetListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): DatasetListPageResponse = response

    /**
     * Delegates to [DatasetListPageResponse], but gracefully handles missing data.
     *
     * @see [DatasetListPageResponse.objects]
     */
    fun objects(): List<Dataset> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is DatasetListPageAsync && datasetsService == other.datasetsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(datasetsService, params, response) /* spotless:on */

    override fun toString() =
        "DatasetListPageAsync{datasetsService=$datasetsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): DatasetListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): DatasetListPageAsync? {
        return getNextPageParams()?.let { datasetsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            datasetsService: DatasetServiceAsync,
            params: DatasetListParams,
            response: DatasetListPageResponse,
        ) = DatasetListPageAsync(datasetsService, params, response)
    }

    class AutoPager(private val firstPage: DatasetListPageAsync) : Flow<Dataset> {

        override suspend fun collect(collector: FlowCollector<Dataset>) {
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
