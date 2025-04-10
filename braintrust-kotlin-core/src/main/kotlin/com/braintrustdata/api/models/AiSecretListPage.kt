// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.blocking.AiSecretService
import java.util.Objects

/**
 * List out all ai_secrets. The ai_secrets are sorted by creation date, with the most
 * recently-created ai_secrets coming first
 */
class AiSecretListPage
private constructor(
    private val aiSecretsService: AiSecretService,
    private val params: AiSecretListParams,
    private val response: AiSecretListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): AiSecretListPageResponse = response

    /**
     * Delegates to [AiSecretListPageResponse], but gracefully handles missing data.
     *
     * @see [AiSecretListPageResponse.objects]
     */
    fun objects(): List<AISecret> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AiSecretListPage && aiSecretsService == other.aiSecretsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(aiSecretsService, params, response) /* spotless:on */

    override fun toString() =
        "AiSecretListPage{aiSecretsService=$aiSecretsService, params=$params, response=$response}"

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

    fun getNextPage(): AiSecretListPage? {
        return getNextPageParams()?.let { aiSecretsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            aiSecretsService: AiSecretService,
            params: AiSecretListParams,
            response: AiSecretListPageResponse,
        ) = AiSecretListPage(aiSecretsService, params, response)
    }

    class AutoPager(private val firstPage: AiSecretListPage) : Sequence<AISecret> {

        override fun iterator(): Iterator<AISecret> = iterator {
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
}
