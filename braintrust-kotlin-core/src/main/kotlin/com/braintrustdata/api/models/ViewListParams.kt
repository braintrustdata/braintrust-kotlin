// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.core.toUnmodifiable
import com.braintrustdata.api.models.*
import java.util.Objects

class ViewListParams
constructor(
    private val objectId: String,
    private val objectType: AclObjectType?,
    private val endingBefore: String?,
    private val ids: Ids?,
    private val limit: Long?,
    private val startingAfter: String?,
    private val viewName: String?,
    private val viewType: ViewType?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun objectId(): String = objectId

    fun objectType(): AclObjectType? = objectType

    fun endingBefore(): String? = endingBefore

    fun ids(): Ids? = ids

    fun limit(): Long? = limit

    fun startingAfter(): String? = startingAfter

    fun viewName(): String? = viewName

    fun viewType(): ViewType? = viewType

    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.objectId.let { params.put("object_id", listOf(it.toString())) }
        this.objectType.let { params.put("object_type", listOf(it.toString())) }
        this.endingBefore?.let { params.put("ending_before", listOf(it.toString())) }
        this.ids?.let { params.put("ids", listOf(it.toString())) }
        this.limit?.let { params.put("limit", listOf(it.toString())) }
        this.startingAfter?.let { params.put("starting_after", listOf(it.toString())) }
        this.viewName?.let { params.put("view_name", listOf(it.toString())) }
        this.viewType?.let { params.put("view_type", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ViewListParams &&
            this.objectId == other.objectId &&
            this.objectType == other.objectType &&
            this.endingBefore == other.endingBefore &&
            this.ids == other.ids &&
            this.limit == other.limit &&
            this.startingAfter == other.startingAfter &&
            this.viewName == other.viewName &&
            this.viewType == other.viewType &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            objectId,
            objectType,
            endingBefore,
            ids,
            limit,
            startingAfter,
            viewName,
            viewType,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "ViewListParams{objectId=$objectId, objectType=$objectType, endingBefore=$endingBefore, ids=$ids, limit=$limit, startingAfter=$startingAfter, viewName=$viewName, viewType=$viewType, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var objectId: String? = null
        private var objectType: AclObjectType? = null
        private var endingBefore: String? = null
        private var ids: Ids? = null
        private var limit: Long? = null
        private var startingAfter: String? = null
        private var viewName: String? = null
        private var viewType: ViewType? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(viewListParams: ViewListParams) = apply {
            this.objectId = viewListParams.objectId
            this.objectType = viewListParams.objectType
            this.endingBefore = viewListParams.endingBefore
            this.ids = viewListParams.ids
            this.limit = viewListParams.limit
            this.startingAfter = viewListParams.startingAfter
            this.viewName = viewListParams.viewName
            this.viewType = viewListParams.viewType
            additionalQueryParams(viewListParams.additionalQueryParams)
            additionalHeaders(viewListParams.additionalHeaders)
            additionalBodyProperties(viewListParams.additionalBodyProperties)
        }

        /** The id of the object the ACL applies to */
        fun objectId(objectId: String) = apply { this.objectId = objectId }

        /** The object type that the ACL applies to */
        fun objectType(objectType: AclObjectType) = apply { this.objectType = objectType }

        /**
         * Pagination cursor id.
         *
         * For example, if the initial item in the last page you fetched had an id of `foo`, pass
         * `ending_before=foo` to fetch the previous page. Note: you may only pass one of
         * `starting_after` and `ending_before`
         */
        fun endingBefore(endingBefore: String) = apply { this.endingBefore = endingBefore }

        /**
         * Filter search results to a particular set of object IDs. To specify a list of IDs,
         * include the query param multiple times
         */
        fun ids(ids: Ids) = apply { this.ids = ids }

        /**
         * Filter search results to a particular set of object IDs. To specify a list of IDs,
         * include the query param multiple times
         */
        fun ids(string: String) = apply { this.ids = Ids.ofString(string) }

        /**
         * Filter search results to a particular set of object IDs. To specify a list of IDs,
         * include the query param multiple times
         */
        fun ids(strings: List<String>) = apply { this.ids = Ids.ofStrings(strings) }

        /** Limit the number of objects to return */
        fun limit(limit: Long) = apply { this.limit = limit }

        /**
         * Pagination cursor id.
         *
         * For example, if the final item in the last page you fetched had an id of `foo`, pass
         * `starting_after=foo` to fetch the next page. Note: you may only pass one of
         * `starting_after` and `ending_before`
         */
        fun startingAfter(startingAfter: String) = apply { this.startingAfter = startingAfter }

        /** Name of the view to search for */
        fun viewName(viewName: String) = apply { this.viewName = viewName }

        /** Type of table that the view corresponds to. */
        fun viewType(viewType: ViewType) = apply { this.viewType = viewType }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): ViewListParams =
            ViewListParams(
                checkNotNull(objectId) { "`objectId` is required but was not set" },
                objectType,
                endingBefore,
                ids,
                limit,
                startingAfter,
                viewName,
                viewType,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }
}
