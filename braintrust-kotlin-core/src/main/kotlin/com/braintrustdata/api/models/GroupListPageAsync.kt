// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.async.GroupServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all groups. The groups are sorted by creation date, with the most recently-created
 * groups coming first
 */
class GroupListPageAsync
private constructor(
    private val groupsService: GroupServiceAsync,
    private val params: GroupListParams,
    private val response: GroupListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): GroupListPageResponse = response

    /**
     * Delegates to [GroupListPageResponse], but gracefully handles missing data.
     *
     * @see [GroupListPageResponse.objects]
     */
    fun objects(): List<Group> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is GroupListPageAsync && groupsService == other.groupsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(groupsService, params, response) /* spotless:on */

    override fun toString() =
        "GroupListPageAsync{groupsService=$groupsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): GroupListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): GroupListPageAsync? {
        return getNextPageParams()?.let { groupsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            groupsService: GroupServiceAsync,
            params: GroupListParams,
            response: GroupListPageResponse,
        ) = GroupListPageAsync(groupsService, params, response)
    }

    class AutoPager(private val firstPage: GroupListPageAsync) : Flow<Group> {

        override suspend fun collect(collector: FlowCollector<Group>) {
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
