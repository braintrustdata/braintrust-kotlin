// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.async.ApiKeyServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all api_keys. The api_keys are sorted by creation date, with the most recently-created
 * api_keys coming first
 */
class ApiKeyListPageAsync
private constructor(
    private val apiKeysService: ApiKeyServiceAsync,
    private val params: ApiKeyListParams,
    private val response: ApiKeyListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ApiKeyListPageResponse = response

    /**
     * Delegates to [ApiKeyListPageResponse], but gracefully handles missing data.
     *
     * @see [ApiKeyListPageResponse.objects]
     */
    fun objects(): List<ApiKey> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ApiKeyListPageAsync && apiKeysService == other.apiKeysService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(apiKeysService, params, response) /* spotless:on */

    override fun toString() =
        "ApiKeyListPageAsync{apiKeysService=$apiKeysService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): ApiKeyListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): ApiKeyListPageAsync? {
        return getNextPageParams()?.let { apiKeysService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            apiKeysService: ApiKeyServiceAsync,
            params: ApiKeyListParams,
            response: ApiKeyListPageResponse,
        ) = ApiKeyListPageAsync(apiKeysService, params, response)
    }

    class AutoPager(private val firstPage: ApiKeyListPageAsync) : Flow<ApiKey> {

        override suspend fun collect(collector: FlowCollector<ApiKey>) {
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
