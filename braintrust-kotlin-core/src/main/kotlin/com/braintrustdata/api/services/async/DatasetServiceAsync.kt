// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.braintrustdata.api.services.async

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import kotlin.LazyThreadSafetyMode.PUBLICATION
import java.time.LocalDate
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.stream.Stream
import com.braintrustdata.api.core.Enum
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.errors.BraintrustInvalidDataException
import com.braintrustdata.api.models.Dataset
import com.braintrustdata.api.models.DatasetCreateParams
import com.braintrustdata.api.models.DatasetDeleteParams
import com.braintrustdata.api.models.DatasetFeedbackParams
import com.braintrustdata.api.models.DatasetFetchParams
import com.braintrustdata.api.models.DatasetFetchPostParams
import com.braintrustdata.api.models.DatasetInsertParams
import com.braintrustdata.api.models.DatasetListPageAsync
import com.braintrustdata.api.models.DatasetListParams
import com.braintrustdata.api.models.DatasetRetrieveParams
import com.braintrustdata.api.models.DatasetSummarizeParams
import com.braintrustdata.api.models.DatasetUpdateParams
import com.braintrustdata.api.models.FeedbackResponseSchema
import com.braintrustdata.api.models.FetchDatasetEventsResponse
import com.braintrustdata.api.models.InsertEventsResponse
import com.braintrustdata.api.models.SummarizeDatasetResponse
import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.http.HttpMethod
import com.braintrustdata.api.core.http.HttpRequest
import com.braintrustdata.api.core.http.HttpResponse.Handler
import com.braintrustdata.api.core.http.BinaryResponseContent
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.errors.BraintrustError
import com.braintrustdata.api.services.emptyHandler
import com.braintrustdata.api.services.errorHandler
import com.braintrustdata.api.services.json
import com.braintrustdata.api.services.jsonHandler
import com.braintrustdata.api.services.multipartFormData
import com.braintrustdata.api.services.stringHandler
import com.braintrustdata.api.services.binaryHandler
import com.braintrustdata.api.services.withErrorHandler

interface DatasetServiceAsync {

    /**
     * Create a new dataset. If there is an existing dataset in the project with the
     * same name as the one specified in the request, will return the existing dataset
     * unmodified
     */
    suspend fun create(params: DatasetCreateParams, requestOptions: RequestOptions = RequestOptions.none()): Dataset

    /** Get a dataset object by its id */
    suspend fun retrieve(params: DatasetRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): Dataset

    /**
     * Partially update a dataset object. Specify the fields to update in the payload.
     * Any object-type fields will be deep-merged with existing content. Currently we
     * do not support removing fields or setting them to null.
     */
    suspend fun update(params: DatasetUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): Dataset

    /**
     * List out all datasets. The datasets are sorted by creation date, with the most
     * recently-created datasets coming first
     */
    suspend fun list(params: DatasetListParams, requestOptions: RequestOptions = RequestOptions.none()): DatasetListPageAsync

    /** Delete a dataset object by its id */
    suspend fun delete(params: DatasetDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): Dataset

    /** Log feedback for a set of dataset events */
    suspend fun feedback(params: DatasetFeedbackParams, requestOptions: RequestOptions = RequestOptions.none()): FeedbackResponseSchema

    /**
     * Fetch the events in a dataset. Equivalent to the POST form of the same path, but
     * with the parameters in the URL query rather than in the request body
     */
    suspend fun fetch(params: DatasetFetchParams, requestOptions: RequestOptions = RequestOptions.none()): FetchDatasetEventsResponse

    /**
     * Fetch the events in a dataset. Equivalent to the GET form of the same path, but
     * with the parameters in the request body rather than in the URL query
     */
    suspend fun fetchPost(params: DatasetFetchPostParams, requestOptions: RequestOptions = RequestOptions.none()): FetchDatasetEventsResponse

    /** Insert a set of events into the dataset */
    suspend fun insert(params: DatasetInsertParams, requestOptions: RequestOptions = RequestOptions.none()): InsertEventsResponse

    /** Summarize dataset */
    suspend fun summarize(params: DatasetSummarizeParams, requestOptions: RequestOptions = RequestOptions.none()): SummarizeDatasetResponse
}
