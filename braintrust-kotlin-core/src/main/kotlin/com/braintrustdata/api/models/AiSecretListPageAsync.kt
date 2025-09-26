// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.AutoPagerAsync
import com.braintrustdata.api.core.PageAsync
import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.AiSecretServiceAsync
import java.util.Objects

/** @see AiSecretServiceAsync.list */
class AiSecretListPageAsync
private constructor(
    private val service: AiSecretServiceAsync,
    private val params: AiSecretListParams,
    private val response: AiSecretListPageResponse,
) : PageAsync<AISecret> {

    /**
     * Delegates to [AiSecretListPageResponse], but gracefully handles missing data.
     *
     * @see AiSecretListPageResponse.objects
     */
    fun objects(): List<AISecret> = response._objects().getNullable("objects") ?: emptyList()

    override fun items(): List<AISecret> = objects()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): AiSecretListParams =
        if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(items().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(items().last()._id().getNullable("id")).build()
        }

    override suspend fun nextPage(): AiSecretListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<AISecret> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): AiSecretListParams = params

    /** The response that this page was parsed from. */
    fun response(): AiSecretListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AiSecretListPageAsync].
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

    /** A builder for [AiSecretListPageAsync]. */
    class Builder internal constructor() {

        private var service: AiSecretServiceAsync? = null
        private var params: AiSecretListParams? = null
        private var response: AiSecretListPageResponse? = null

        internal fun from(aiSecretListPageAsync: AiSecretListPageAsync) = apply {
            service = aiSecretListPageAsync.service
            params = aiSecretListPageAsync.params
            response = aiSecretListPageAsync.response
        }

        fun service(service: AiSecretServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: AiSecretListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AiSecretListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AiSecretListPageAsync].
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
        fun build(): AiSecretListPageAsync =
            AiSecretListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AiSecretListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "AiSecretListPageAsync{service=$service, params=$params, response=$response}"
}
