// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.AclServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/** @see [AclServiceAsync.list] */
class AclListPageAsync
private constructor(
    private val service: AclServiceAsync,
    private val params: AclListParams,
    private val response: AclListPageResponse,
) {

    /**
     * Delegates to [AclListPageResponse], but gracefully handles missing data.
     *
     * @see [AclListPageResponse.objects]
     */
    fun objects(): List<Acl> = response._objects().getNullable("objects") ?: emptyList()

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

    suspend fun getNextPage(): AclListPageAsync? = getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

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
