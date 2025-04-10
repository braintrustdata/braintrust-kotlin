// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.AiSecretServiceAsync
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/** @see [AiSecretServiceAsync.list] */
class AiSecretListPageAsync
private constructor(
    private val service: AiSecretServiceAsync,
    private val params: AiSecretListParams,
    private val response: AiSecretListPageResponse,
) {

    /**
     * Delegates to [AiSecretListPageResponse], but gracefully handles missing data.
     *
     * @see [AiSecretListPageResponse.objects]
     */
    fun objects(): List<AISecret> = response._objects().getNullable("objects") ?: emptyList()

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): AiSecretListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    suspend fun getNextPage(): AiSecretListPageAsync? =
        getNextPageParams()?.let { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

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

    class AutoPager(private val firstPage: AiSecretListPageAsync) : Flow<AISecret> {

        override suspend fun collect(collector: FlowCollector<AISecret>) {
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

        return /* spotless:off */ other is AiSecretListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "AiSecretListPageAsync{service=$service, params=$params, response=$response}"
}
