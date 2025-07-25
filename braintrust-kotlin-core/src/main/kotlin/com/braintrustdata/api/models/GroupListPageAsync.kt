// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.AutoPagerAsync
import com.braintrustdata.api.core.PageAsync
import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.GroupServiceAsync
import java.util.Objects

/** @see GroupServiceAsync.list */
class GroupListPageAsync
private constructor(
    private val service: GroupServiceAsync,
    private val params: GroupListParams,
    private val response: GroupListPageResponse,
) : PageAsync<Group> {

    /**
     * Delegates to [GroupListPageResponse], but gracefully handles missing data.
     *
     * @see GroupListPageResponse.objects
     */
    fun objects(): List<Group> = response._objects().getNullable("objects") ?: emptyList()

    override fun items(): List<Group> = objects()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): GroupListParams =
        if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(items().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(items().last()._id().getNullable("id")).build()
        }

    override suspend fun nextPage(): GroupListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Group> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): GroupListParams = params

    /** The response that this page was parsed from. */
    fun response(): GroupListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [GroupListPageAsync].
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

    /** A builder for [GroupListPageAsync]. */
    class Builder internal constructor() {

        private var service: GroupServiceAsync? = null
        private var params: GroupListParams? = null
        private var response: GroupListPageResponse? = null

        internal fun from(groupListPageAsync: GroupListPageAsync) = apply {
            service = groupListPageAsync.service
            params = groupListPageAsync.params
            response = groupListPageAsync.response
        }

        fun service(service: GroupServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: GroupListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: GroupListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [GroupListPageAsync].
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
        fun build(): GroupListPageAsync =
            GroupListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is GroupListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "GroupListPageAsync{service=$service, params=$params, response=$response}"
}
