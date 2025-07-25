// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.AutoPagerAsync
import com.braintrustdata.api.core.PageAsync
import com.braintrustdata.api.core.checkRequired
import com.braintrustdata.api.services.async.PromptServiceAsync
import java.util.Objects

/** @see PromptServiceAsync.list */
class PromptListPageAsync
private constructor(
    private val service: PromptServiceAsync,
    private val params: PromptListParams,
    private val response: PromptListPageResponse,
) : PageAsync<Prompt> {

    /**
     * Delegates to [PromptListPageResponse], but gracefully handles missing data.
     *
     * @see PromptListPageResponse.objects
     */
    fun objects(): List<Prompt> = response._objects().getNullable("objects") ?: emptyList()

    override fun items(): List<Prompt> = objects()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): PromptListParams =
        if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(items().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(items().last()._id().getNullable("id")).build()
        }

    override suspend fun nextPage(): PromptListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Prompt> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): PromptListParams = params

    /** The response that this page was parsed from. */
    fun response(): PromptListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PromptListPageAsync].
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

    /** A builder for [PromptListPageAsync]. */
    class Builder internal constructor() {

        private var service: PromptServiceAsync? = null
        private var params: PromptListParams? = null
        private var response: PromptListPageResponse? = null

        internal fun from(promptListPageAsync: PromptListPageAsync) = apply {
            service = promptListPageAsync.service
            params = promptListPageAsync.params
            response = promptListPageAsync.response
        }

        fun service(service: PromptServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: PromptListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PromptListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [PromptListPageAsync].
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
        fun build(): PromptListPageAsync =
            PromptListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PromptListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "PromptListPageAsync{service=$service, params=$params, response=$response}"
}
