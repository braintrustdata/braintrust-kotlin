// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async.project

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
import com.braintrustdata.api.models.FeedbackResponseSchema
import com.braintrustdata.api.models.FetchProjectLogsEventsResponse
import com.braintrustdata.api.models.InsertEventsResponse
import com.braintrustdata.api.models.ProjectLogFeedbackParams
import com.braintrustdata.api.models.ProjectLogFetchParams
import com.braintrustdata.api.models.ProjectLogFetchPostParams
import com.braintrustdata.api.models.ProjectLogInsertParams
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

class LogServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : LogServiceAsync {

    private val errorHandler: Handler<BraintrustError> = errorHandler(clientOptions.jsonMapper)

    private val feedbackHandler: Handler<FeedbackResponseSchema> =
    jsonHandler<FeedbackResponseSchema>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Log feedback for a set of project logs events */
    override suspend fun feedback(params: ProjectLogFeedbackParams, requestOptions: RequestOptions): FeedbackResponseSchema {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("v1", "project_logs", params.getPathParam(0), "feedback")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              feedbackHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val fetchHandler: Handler<FetchProjectLogsEventsResponse> =
    jsonHandler<FetchProjectLogsEventsResponse>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Fetch the events in a project logs. Equivalent to the POST form of the same
     * path, but with the parameters in the URL query rather than in the request body
     */
    override suspend fun fetch(params: ProjectLogFetchParams, requestOptions: RequestOptions): FetchProjectLogsEventsResponse {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("v1", "project_logs", params.getPathParam(0), "fetch")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              fetchHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val fetchPostHandler: Handler<FetchProjectLogsEventsResponse> =
    jsonHandler<FetchProjectLogsEventsResponse>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Fetch the events in a project logs. Equivalent to the GET form of the same path,
     * but with the parameters in the request body rather than in the URL query
     */
    override suspend fun fetchPost(params: ProjectLogFetchPostParams, requestOptions: RequestOptions): FetchProjectLogsEventsResponse {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("v1", "project_logs", params.getPathParam(0), "fetch")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              fetchPostHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val insertHandler: Handler<InsertEventsResponse> =
    jsonHandler<InsertEventsResponse>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Insert a set of events into the project logs */
    override suspend fun insert(params: ProjectLogInsertParams, requestOptions: RequestOptions): InsertEventsResponse {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("v1", "project_logs", params.getPathParam(0), "insert")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              insertHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
