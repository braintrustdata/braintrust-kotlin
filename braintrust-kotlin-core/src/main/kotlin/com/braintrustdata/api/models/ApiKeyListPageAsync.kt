// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.AutoPagerAsync
import com.braintrustdata.api.core.PageAsync
import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.ApiKeyServiceAsync
import java.util.Objects

/** @see ApiKeyServiceAsync.list */
class ApiKeyListPageAsync
private constructor(
    private val service: ApiKeyServiceAsync,
    private val params: ApiKeyListParams,
    private val response: ApiKeyListPageResponse,
) : PageAsync<ApiKey> {

    /**
     * Delegates to [ApiKeyListPageResponse], but gracefully handles missing data.
     *
     * @see ApiKeyListPageResponse.objects
     */
    fun objects(): List<ApiKey> = response._objects().getNullable("objects") ?: emptyList()

    override fun items(): List<ApiKey> = objects()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ApiKeyListParams =
        if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(items().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(items().last()._id().getNullable("id")).build()
        }

    override suspend fun nextPage(): ApiKeyListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<ApiKey> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ApiKeyListParams = params

    /** The response that this page was parsed from. */
    fun response(): ApiKeyListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ApiKeyListPageAsync].
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

    /** A builder for [ApiKeyListPageAsync]. */
    class Builder internal constructor() {

        private var service: ApiKeyServiceAsync? = null
        private var params: ApiKeyListParams? = null
        private var response: ApiKeyListPageResponse? = null

        internal fun from(apiKeyListPageAsync: ApiKeyListPageAsync) = apply {
            service = apiKeyListPageAsync.service
            params = apiKeyListPageAsync.params
            response = apiKeyListPageAsync.response
        }

        fun service(service: ApiKeyServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ApiKeyListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ApiKeyListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ApiKeyListPageAsync].
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
        fun build(): ApiKeyListPageAsync =
            ApiKeyListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ApiKeyListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ApiKeyListPageAsync{service=$service, params=$params, response=$response}"
}
