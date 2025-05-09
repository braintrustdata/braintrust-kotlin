// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.AutoPagerAsync
import com.braintrustdata.api.core.PageAsync
import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.ViewServiceAsync
import java.util.Objects

/** @see [ViewServiceAsync.list] */
class ViewListPageAsync
private constructor(
    private val service: ViewServiceAsync,
    private val params: ViewListParams,
    private val response: ViewListPageResponse,
) : PageAsync<View> {

    /**
     * Delegates to [ViewListPageResponse], but gracefully handles missing data.
     *
     * @see [ViewListPageResponse.objects]
     */
    fun objects(): List<View> = response._objects().getNullable("objects") ?: emptyList()

    override fun items(): List<View> = objects()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ViewListParams =
        if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(items().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(items().last()._id().getNullable("id")).build()
        }

    override suspend fun nextPage(): ViewListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<View> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ViewListParams = params

    /** The response that this page was parsed from. */
    fun response(): ViewListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ViewListPageAsync].
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

    /** A builder for [ViewListPageAsync]. */
    class Builder internal constructor() {

        private var service: ViewServiceAsync? = null
        private var params: ViewListParams? = null
        private var response: ViewListPageResponse? = null

        internal fun from(viewListPageAsync: ViewListPageAsync) = apply {
            service = viewListPageAsync.service
            params = viewListPageAsync.params
            response = viewListPageAsync.response
        }

        fun service(service: ViewServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ViewListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ViewListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ViewListPageAsync].
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
        fun build(): ViewListPageAsync =
            ViewListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ViewListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ViewListPageAsync{service=$service, params=$params, response=$response}"
}
