// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.blocking.OrganizationService
import java.util.Objects

/** @see [OrganizationService.list] */
class OrganizationListPage
private constructor(
    private val service: OrganizationService,
    private val params: OrganizationListParams,
    private val response: OrganizationListPageResponse,
) {

    /**
     * Delegates to [OrganizationListPageResponse], but gracefully handles missing data.
     *
     * @see [OrganizationListPageResponse.objects]
     */
    fun objects(): List<Organization> = response._objects().getNullable("objects") ?: emptyList()

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

    fun getNextPage(): OrganizationListPage? = getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): OrganizationListParams = params

    /** The response that this page was parsed from. */
    fun response(): OrganizationListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [OrganizationListPage].
         *
         * The following fields are required:
         * ```kotlin
         * .service()
         * .params()
         * .response()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [OrganizationListPage]. */
    class Builder internal constructor() {

        private var service: OrganizationService? = null
        private var params: OrganizationListParams? = null
        private var response: OrganizationListPageResponse? = null

        internal fun from(organizationListPage: OrganizationListPage) = apply {
            service = organizationListPage.service
            params = organizationListPage.params
            response = organizationListPage.response
        }

        fun service(service: OrganizationService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: OrganizationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: OrganizationListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [OrganizationListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OrganizationListPage =
            OrganizationListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is OrganizationListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "OrganizationListPage{service=$service, params=$params, response=$response}"
}
