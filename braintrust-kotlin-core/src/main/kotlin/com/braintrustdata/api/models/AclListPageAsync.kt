// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.AutoPagerAsync
import com.braintrustdata.api.core.PageAsync
import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.AclServiceAsync
import java.util.Objects

/** @see AclServiceAsync.list */
class AclListPageAsync
private constructor(
    private val service: AclServiceAsync,
    private val params: AclListParams,
    private val response: AclListPageResponse,
) : PageAsync<Acl> {

    /**
     * Delegates to [AclListPageResponse], but gracefully handles missing data.
     *
     * @see AclListPageResponse.objects
     */
    fun objects(): List<Acl> = response._objects().getNullable("objects") ?: emptyList()

    override fun items(): List<Acl> = objects()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): AclListParams =
        if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(items().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(items().last()._id().getNullable("id")).build()
        }

    override suspend fun nextPage(): AclListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Acl> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): AclListParams = params

    /** The response that this page was parsed from. */
    fun response(): AclListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AclListPageAsync].
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

    /** A builder for [AclListPageAsync]. */
    class Builder internal constructor() {

        private var service: AclServiceAsync? = null
        private var params: AclListParams? = null
        private var response: AclListPageResponse? = null

        internal fun from(aclListPageAsync: AclListPageAsync) = apply {
            service = aclListPageAsync.service
            params = aclListPageAsync.params
            response = aclListPageAsync.response
        }

        fun service(service: AclServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: AclListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AclListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AclListPageAsync].
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
        fun build(): AclListPageAsync =
            AclListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AclListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "AclListPageAsync{service=$service, params=$params, response=$response}"
}
