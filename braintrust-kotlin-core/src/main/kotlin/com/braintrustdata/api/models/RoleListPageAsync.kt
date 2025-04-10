// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.async.RoleServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all roles. The roles are sorted by creation date, with the most recently-created roles
 * coming first
 */
class RoleListPageAsync
private constructor(
    private val rolesService: RoleServiceAsync,
    private val params: RoleListParams,
    private val response: RoleListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): RoleListPageResponse = response

    /**
     * Delegates to [RoleListPageResponse], but gracefully handles missing data.
     *
     * @see [RoleListPageResponse.objects]
     */
    fun objects(): List<Role> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RoleListPageAsync && rolesService == other.rolesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(rolesService, params, response) /* spotless:on */

    override fun toString() =
        "RoleListPageAsync{rolesService=$rolesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): RoleListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): RoleListPageAsync? {
        return getNextPageParams()?.let { rolesService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            rolesService: RoleServiceAsync,
            params: RoleListParams,
            response: RoleListPageResponse,
        ) = RoleListPageAsync(rolesService, params, response)
    }

    class AutoPager(private val firstPage: RoleListPageAsync) : Flow<Role> {

        override suspend fun collect(collector: FlowCollector<Role>) {
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
