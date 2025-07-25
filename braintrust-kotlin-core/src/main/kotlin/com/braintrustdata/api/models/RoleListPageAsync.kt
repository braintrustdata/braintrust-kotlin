// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.AutoPagerAsync
import com.braintrustdata.api.core.PageAsync
import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.RoleServiceAsync
import java.util.Objects

/** @see RoleServiceAsync.list */
class RoleListPageAsync
private constructor(
    private val service: RoleServiceAsync,
    private val params: RoleListParams,
    private val response: RoleListPageResponse,
) : PageAsync<Role> {

    /**
     * Delegates to [RoleListPageResponse], but gracefully handles missing data.
     *
     * @see RoleListPageResponse.objects
     */
    fun objects(): List<Role> = response._objects().getNullable("objects") ?: emptyList()

    override fun items(): List<Role> = objects()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): RoleListParams =
        if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(items().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(items().last()._id().getNullable("id")).build()
        }

    override suspend fun nextPage(): RoleListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Role> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): RoleListParams = params

    /** The response that this page was parsed from. */
    fun response(): RoleListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RoleListPageAsync].
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

    /** A builder for [RoleListPageAsync]. */
    class Builder internal constructor() {

        private var service: RoleServiceAsync? = null
        private var params: RoleListParams? = null
        private var response: RoleListPageResponse? = null

        internal fun from(roleListPageAsync: RoleListPageAsync) = apply {
            service = roleListPageAsync.service
            params = roleListPageAsync.params
            response = roleListPageAsync.response
        }

        fun service(service: RoleServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: RoleListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: RoleListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [RoleListPageAsync].
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
        fun build(): RoleListPageAsync =
            RoleListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RoleListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "RoleListPageAsync{service=$service, params=$params, response=$response}"
}
