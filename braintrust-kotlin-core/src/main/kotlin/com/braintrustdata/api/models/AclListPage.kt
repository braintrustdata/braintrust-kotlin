// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.blocking.AclService
import java.util.Objects

/**
 * List out all acls. The acls are sorted by creation date, with the most recently-created acls
 * coming first
 */
class AclListPage
private constructor(
    private val aclsService: AclService,
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

        return /* spotless:off */ other is AclListPage && aclsService == other.aclsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(aclsService, params, response) /* spotless:on */

    override fun toString() =
        "AclListPage{aclsService=$aclsService, params=$params, response=$response}"

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

    fun getNextPage(): AclListPage? {
        return getNextPageParams()?.let { aclsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(aclsService: AclService, params: AclListParams, response: AclListPageResponse) =
            AclListPage(aclsService, params, response)
    }

    class AutoPager(private val firstPage: AclListPage) : Sequence<Acl> {

        override fun iterator(): Iterator<Acl> = iterator {
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
