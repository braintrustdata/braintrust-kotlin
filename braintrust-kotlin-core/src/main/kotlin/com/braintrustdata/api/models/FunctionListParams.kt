// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.core.toUnmodifiable
import com.braintrustdata.api.models.*
import java.util.Objects

class FunctionListParams
constructor(
    private val endingBefore: String?,
    private val functionName: String?,
    private val ids: Ids?,
    private val limit: Long?,
    private val orgName: String?,
    private val projectId: String?,
    private val projectName: String?,
    private val slug: String?,
    private val startingAfter: String?,
    private val version: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun endingBefore(): String? = endingBefore

    fun functionName(): String? = functionName

    fun ids(): Ids? = ids

    fun limit(): Long? = limit

    fun orgName(): String? = orgName

    fun projectId(): String? = projectId

    fun projectName(): String? = projectName

    fun slug(): String? = slug

    fun startingAfter(): String? = startingAfter

    fun version(): String? = version

    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.endingBefore?.let { params.put("ending_before", listOf(it.toString())) }
        this.functionName?.let { params.put("function_name", listOf(it.toString())) }
        this.ids?.let { params.put("ids", listOf(it.toString())) }
        this.limit?.let { params.put("limit", listOf(it.toString())) }
        this.orgName?.let { params.put("org_name", listOf(it.toString())) }
        this.projectId?.let { params.put("project_id", listOf(it.toString())) }
        this.projectName?.let { params.put("project_name", listOf(it.toString())) }
        this.slug?.let { params.put("slug", listOf(it.toString())) }
        this.startingAfter?.let { params.put("starting_after", listOf(it.toString())) }
        this.version?.let { params.put("version", listOf(it.toString())) }
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

        return other is FunctionListParams &&
            this.endingBefore == other.endingBefore &&
            this.functionName == other.functionName &&
            this.ids == other.ids &&
            this.limit == other.limit &&
            this.orgName == other.orgName &&
            this.projectId == other.projectId &&
            this.projectName == other.projectName &&
            this.slug == other.slug &&
            this.startingAfter == other.startingAfter &&
            this.version == other.version &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            endingBefore,
            functionName,
            ids,
            limit,
            orgName,
            projectId,
            projectName,
            slug,
            startingAfter,
            version,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "FunctionListParams{endingBefore=$endingBefore, functionName=$functionName, ids=$ids, limit=$limit, orgName=$orgName, projectId=$projectId, projectName=$projectName, slug=$slug, startingAfter=$startingAfter, version=$version, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var endingBefore: String? = null
        private var functionName: String? = null
        private var ids: Ids? = null
        private var limit: Long? = null
        private var orgName: String? = null
        private var projectId: String? = null
        private var projectName: String? = null
        private var slug: String? = null
        private var startingAfter: String? = null
        private var version: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(functionListParams: FunctionListParams) = apply {
            this.endingBefore = functionListParams.endingBefore
            this.functionName = functionListParams.functionName
            this.ids = functionListParams.ids
            this.limit = functionListParams.limit
            this.orgName = functionListParams.orgName
            this.projectId = functionListParams.projectId
            this.projectName = functionListParams.projectName
            this.slug = functionListParams.slug
            this.startingAfter = functionListParams.startingAfter
            this.version = functionListParams.version
            additionalQueryParams(functionListParams.additionalQueryParams)
            additionalHeaders(functionListParams.additionalHeaders)
            additionalBodyProperties(functionListParams.additionalBodyProperties)
        }

        /**
         * Pagination cursor id.
         *
         * For example, if the initial item in the last page you fetched had an id of `foo`, pass
         * `ending_before=foo` to fetch the previous page. Note: you may only pass one of
         * `starting_after` and `ending_before`
         */
        fun endingBefore(endingBefore: String) = apply { this.endingBefore = endingBefore }

        /** Name of the function to search for */
        fun functionName(functionName: String) = apply { this.functionName = functionName }

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

        /** Filter search results to within a particular organization */
        fun orgName(orgName: String) = apply { this.orgName = orgName }

        /** Project id */
        fun projectId(projectId: String) = apply { this.projectId = projectId }

        /** Name of the project to search for */
        fun projectName(projectName: String) = apply { this.projectName = projectName }

        /** Retrieve prompt with a specific slug */
        fun slug(slug: String) = apply { this.slug = slug }

        /**
         * Pagination cursor id.
         *
         * For example, if the final item in the last page you fetched had an id of `foo`, pass
         * `starting_after=foo` to fetch the next page. Note: you may only pass one of
         * `starting_after` and `ending_before`
         */
        fun startingAfter(startingAfter: String) = apply { this.startingAfter = startingAfter }

        /**
         * Retrieve prompt at a specific version.
         *
         * The version id can either be a transaction id (e.g. '1000192656880881099') or a version
         * identifier (e.g. '81cd05ee665fdfb3').
         */
        fun version(version: String) = apply { this.version = version }

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

        fun build(): FunctionListParams =
            FunctionListParams(
                endingBefore,
                functionName,
                ids,
                limit,
                orgName,
                projectId,
                projectName,
                slug,
                startingAfter,
                version,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }
}
