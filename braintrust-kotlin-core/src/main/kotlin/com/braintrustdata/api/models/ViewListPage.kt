// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.blocking.ViewService
import java.util.Objects

/** @see [ViewService.list] */
class ViewListPage
private constructor(
    private val service: ViewService,
    private val params: ViewListParams,
    private val response: ViewListPageResponse,
) {

    /**
     * Delegates to [ViewListPageResponse], but gracefully handles missing data.
     *
     * @see [ViewListPageResponse.objects]
     */
    fun objects(): List<View> = response._objects().getNullable("objects") ?: emptyList()

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

    fun getNextPage(): ViewListPage? = getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ViewListParams = params

    /** The response that this page was parsed from. */
    fun response(): ViewListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ViewListPage].
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

    /** A builder for [ViewListPage]. */
    class Builder internal constructor() {

        private var service: ViewService? = null
        private var params: ViewListParams? = null
        private var response: ViewListPageResponse? = null

        internal fun from(viewListPage: ViewListPage) = apply {
            service = viewListPage.service
            params = viewListPage.params
            response = viewListPage.response
        }

        fun service(service: ViewService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ViewListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ViewListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ViewListPage].
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
        fun build(): ViewListPage =
            ViewListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: ViewListPage) : Sequence<View> {

        override fun iterator(): Iterator<View> = iterator {
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

        return /* spotless:off */ other is ViewListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() = "ViewListPage{service=$service, params=$params, response=$response}"
}
