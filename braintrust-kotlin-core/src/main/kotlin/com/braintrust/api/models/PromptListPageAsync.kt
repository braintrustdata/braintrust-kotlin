// File generated from our OpenAPI spec by Stainless.

package com.braintrust.api.models

import com.braintrust.api.core.ExcludeMissing
import com.braintrust.api.core.JsonField
import com.braintrust.api.core.JsonMissing
import com.braintrust.api.core.JsonValue
import com.braintrust.api.core.NoAutoDetect
import com.braintrust.api.core.toUnmodifiable
import com.braintrust.api.services.async.PromptServiceAsync
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

class PromptListPageAsync
private constructor(
    private val promptService: PromptServiceAsync,
    private val params: PromptListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun objects(): List<PromptListResponse> = response().objects()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PromptListPageAsync &&
            this.promptService == other.promptService &&
            this.params == other.params &&
            this.response == other.response
    }

    override fun hashCode(): Int {
        return Objects.hash(
            promptService,
            params,
            response,
        )
    }

    override fun toString() =
        "PromptListPageAsync{promptService=$promptService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !objects().isEmpty()
    }

    fun getNextPageParams(): PromptListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            PromptListParams.builder().from(params).endingBefore(objects().first().id()).build()
        } else {
            PromptListParams.builder().from(params).startingAfter(objects().last().id()).build()
        }
    }

    suspend fun getNextPage(): PromptListPageAsync? {
        return getNextPageParams()?.let { promptService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(promptService: PromptServiceAsync, params: PromptListParams, response: Response) =
            PromptListPageAsync(
                promptService,
                params,
                response,
            )
    }

    @JsonDeserialize(builder = Response.Builder::class)
    @NoAutoDetect
    class Response
    constructor(
        private val objects: JsonField<List<PromptListResponse>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun objects(): List<PromptListResponse> = objects.getNullable("objects") ?: listOf()

        @JsonProperty("objects") fun _objects(): JsonField<List<PromptListResponse>>? = objects

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Response = apply {
            if (!validated) {
                objects().map { it.validate() }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Response &&
                this.objects == other.objects &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            return Objects.hash(objects, additionalProperties)
        }

        override fun toString() =
            "PromptListPageAsync.Response{objects=$objects, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var objects: JsonField<List<PromptListResponse>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(page: Response) = apply {
                this.objects = page.objects
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun objects(objects: List<PromptListResponse>) = objects(JsonField.of(objects))

            @JsonProperty("objects")
            fun objects(objects: JsonField<List<PromptListResponse>>) = apply {
                this.objects = objects
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(objects, additionalProperties.toUnmodifiable())
        }
    }

    class AutoPager
    constructor(
        private val firstPage: PromptListPageAsync,
    ) : Flow<PromptListResponse> {

        override suspend fun collect(collector: FlowCollector<PromptListResponse>) {
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
}
