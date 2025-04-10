// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.async.AclServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 * List out all acls. The acls are sorted by creation date, with the most recently-created acls
 * coming first
 */
class AclListPageAsync
private constructor(
    private val aclsService: AclServiceAsync,
    private val params: AclListParams,
    private val response: AclListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): AclListPageResponse = response

    /**
     * Delegates to [AclListPageResponse], but gracefully handles missing data.
     *
     * @see [AclListPageResponse.objects]
     */
    fun objects(): List<Acl> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AclListPageAsync && aclsService == other.aclsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(aclsService, params, response) /* spotless:on */

    override fun toString() =
        "AclListPageAsync{aclsService=$aclsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): AclListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): AclListPageAsync? {
        return getNextPageParams()?.let { aclsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(aclsService: AclServiceAsync, params: AclListParams, response: AclListPageResponse) =
            AclListPageAsync(aclsService, params, response)
    }

    class AutoPager(private val firstPage: AclListPageAsync) : Flow<Acl> {

        override suspend fun collect(collector: FlowCollector<Acl>) {
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
