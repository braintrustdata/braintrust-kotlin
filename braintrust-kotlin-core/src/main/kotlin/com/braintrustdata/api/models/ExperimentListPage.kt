// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.blocking.ExperimentService
import java.util.Objects

/**
 * List out all experiments. The experiments are sorted by creation date, with the most
 * recently-created experiments coming first
 */
class ExperimentListPage
private constructor(
    private val experimentsService: ExperimentService,
    private val params: ExperimentListParams,
    private val response: ExperimentListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ExperimentListPageResponse = response

    /**
     * Delegates to [ExperimentListPageResponse], but gracefully handles missing data.
     *
     * @see [ExperimentListPageResponse.objects]
     */
    fun objects(): List<Experiment> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ExperimentListPage && experimentsService == other.experimentsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(experimentsService, params, response) /* spotless:on */

    override fun toString() =
        "ExperimentListPage{experimentsService=$experimentsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): ExperimentListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    fun getNextPage(): ExperimentListPage? {
        return getNextPageParams()?.let { experimentsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(
            experimentsService: ExperimentService,
            params: ExperimentListParams,
            response: ExperimentListPageResponse,
        ) = ExperimentListPage(experimentsService, params, response)
    }

    class AutoPager(private val firstPage: ExperimentListPage) : Sequence<Experiment> {

        override fun iterator(): Iterator<Experiment> = iterator {
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
