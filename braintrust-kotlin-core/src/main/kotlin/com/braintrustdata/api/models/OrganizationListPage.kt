// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.blocking.OrganizationService
import java.util.Objects

/**
 * List out all organizations. The organizations are sorted by creation date, with the most
 * recently-created organizations coming first
 */
class OrganizationListPage
private constructor(
    private val organizationsService: OrganizationService,
    private val params: OrganizationListParams,
    private val response: OrganizationListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): OrganizationListPageResponse = response

    /**
     * Delegates to [OrganizationListPageResponse], but gracefully handles missing data.
     *
     * @see [OrganizationListPageResponse.objects]
     */
    fun objects(): List<Organization> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is OrganizationListPage && organizationsService == other.organizationsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(organizationsService, params, response) /* spotless:on */

    override fun toString() =
        "OrganizationListPage{organizationsService=$organizationsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): OrganizationListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    fun getNextPage(): OrganizationListPage? {
        return getNextPageParams()?.let { organizationsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            organizationsService: OrganizationService,
            params: OrganizationListParams,
            response: OrganizationListPageResponse,
        ) = OrganizationListPage(organizationsService, params, response)
    }

    class AutoPager(private val firstPage: OrganizationListPage) : Sequence<Organization> {

        override fun iterator(): Iterator<Organization> = iterator {
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
