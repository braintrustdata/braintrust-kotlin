// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.braintrustdata.api.services.blocking

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
import com.braintrustdata.api.models.Experiment
import com.braintrustdata.api.models.ExperimentCreateParams
import com.braintrustdata.api.models.ExperimentDeleteParams
import com.braintrustdata.api.models.ExperimentFeedbackParams
import com.braintrustdata.api.models.ExperimentFetchParams
import com.braintrustdata.api.models.ExperimentFetchPostParams
import com.braintrustdata.api.models.ExperimentInsertParams
import com.braintrustdata.api.models.ExperimentListPage
import com.braintrustdata.api.models.ExperimentListParams
import com.braintrustdata.api.models.ExperimentRetrieveParams
import com.braintrustdata.api.models.ExperimentSummarizeParams
import com.braintrustdata.api.models.ExperimentUpdateParams
import com.braintrustdata.api.models.FeedbackResponseSchema
import com.braintrustdata.api.models.FetchExperimentEventsResponse
import com.braintrustdata.api.models.InsertEventsResponse
import com.braintrustdata.api.models.SummarizeExperimentResponse
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

interface ExperimentService {

    /**
     * Create a new experiment. If there is an existing experiment in the project with
     * the same name as the one specified in the request, will return the existing
     * experiment unmodified
     */
    fun create(params: ExperimentCreateParams, requestOptions: RequestOptions = RequestOptions.none()): Experiment

    /** Get an experiment object by its id */
    fun retrieve(params: ExperimentRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): Experiment

    /**
     * Partially update an experiment object. Specify the fields to update in the
     * payload. Any object-type fields will be deep-merged with existing content.
     * Currently we do not support removing fields or setting them to null.
     */
    fun update(params: ExperimentUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): Experiment

    /**
     * List out all experiments. The experiments are sorted by creation date, with the
     * most recently-created experiments coming first
     */
    fun list(params: ExperimentListParams, requestOptions: RequestOptions = RequestOptions.none()): ExperimentListPage

    /** Delete an experiment object by its id */
    fun delete(params: ExperimentDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): Experiment

    /** Log feedback for a set of experiment events */
    fun feedback(params: ExperimentFeedbackParams, requestOptions: RequestOptions = RequestOptions.none()): FeedbackResponseSchema

    /**
     * Fetch the events in an experiment. Equivalent to the POST form of the same path,
     * but with the parameters in the URL query rather than in the request body
     */
    fun fetch(params: ExperimentFetchParams, requestOptions: RequestOptions = RequestOptions.none()): FetchExperimentEventsResponse

    /**
     * Fetch the events in an experiment. Equivalent to the GET form of the same path,
     * but with the parameters in the request body rather than in the URL query
     */
    fun fetchPost(params: ExperimentFetchPostParams, requestOptions: RequestOptions = RequestOptions.none()): FetchExperimentEventsResponse

    /** Insert a set of events into the experiment */
    fun insert(params: ExperimentInsertParams, requestOptions: RequestOptions = RequestOptions.none()): InsertEventsResponse

    /** Summarize experiment */
    fun summarize(params: ExperimentSummarizeParams, requestOptions: RequestOptions = RequestOptions.none()): SummarizeExperimentResponse
}
