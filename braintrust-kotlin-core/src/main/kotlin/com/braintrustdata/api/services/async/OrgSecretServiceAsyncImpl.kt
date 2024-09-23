// File generated from our OpenAPI spec by Stainless.

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
import com.braintrustdata.api.models.OrgSecret
import com.braintrustdata.api.models.OrgSecretCreateParams
import com.braintrustdata.api.models.OrgSecretDeleteParams
import com.braintrustdata.api.models.OrgSecretListPageAsync
import com.braintrustdata.api.models.OrgSecretListParams
import com.braintrustdata.api.models.OrgSecretReplaceParams
import com.braintrustdata.api.models.OrgSecretRetrieveParams
import com.braintrustdata.api.models.OrgSecretUpdateParams
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

class OrgSecretServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : OrgSecretServiceAsync {

    private val errorHandler: Handler<BraintrustError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<OrgSecret> =
    jsonHandler<OrgSecret>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Create a new org_secret. If there is an existing org_secret with the same name
     * as the one specified in the request, will return the existing org_secret
     * unmodified
     */
    override suspend fun create(params: OrgSecretCreateParams, requestOptions: RequestOptions): OrgSecret {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("v1", "org_secret")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              createHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val retrieveHandler: Handler<OrgSecret> =
    jsonHandler<OrgSecret>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Get an org_secret object by its id */
    override suspend fun retrieve(params: OrgSecretRetrieveParams, requestOptions: RequestOptions): OrgSecret {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("v1", "org_secret", params.getPathParam(0))
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              retrieveHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val updateHandler: Handler<OrgSecret> =
    jsonHandler<OrgSecret>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Partially update an org_secret object. Specify the fields to update in the
     * payload. Any object-type fields will be deep-merged with existing content.
     * Currently we do not support removing fields or setting them to null.
     */
    override suspend fun update(params: OrgSecretUpdateParams, requestOptions: RequestOptions): OrgSecret {
      val request = HttpRequest.builder()
        .method(HttpMethod.PATCH)
        .addPathSegments("v1", "org_secret", params.getPathParam(0))
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              updateHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val listHandler: Handler<OrgSecretListPageAsync.Response> =
    jsonHandler<OrgSecretListPageAsync.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * List out all org_secrets. The org_secrets are sorted by creation date, with the
     * most recently-created org_secrets coming first
     */
    override suspend fun list(params: OrgSecretListParams, requestOptions: RequestOptions): OrgSecretListPageAsync {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("v1", "org_secret")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              listHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
          .let {
              OrgSecretListPageAsync.of(this, params, it)
          }
      }
    }

    private val deleteHandler: Handler<OrgSecret> =
    jsonHandler<OrgSecret>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Delete an org_secret object by its id */
    override suspend fun delete(params: OrgSecretDeleteParams, requestOptions: RequestOptions): OrgSecret {
      val request = HttpRequest.builder()
        .method(HttpMethod.DELETE)
        .addPathSegments("v1", "org_secret", params.getPathParam(0))
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .apply {
            params.getBody()?.also {
                body(json(clientOptions.jsonMapper, it))
            }
        }
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              deleteHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val replaceHandler: Handler<OrgSecret> =
    jsonHandler<OrgSecret>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Create or replace org_secret. If there is an existing org_secret with the same
     * name as the one specified in the request, will replace the existing org_secret
     * with the provided fields
     */
    override suspend fun replace(params: OrgSecretReplaceParams, requestOptions: RequestOptions): OrgSecret {
      val request = HttpRequest.builder()
        .method(HttpMethod.PUT)
        .addPathSegments("v1", "org_secret")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              replaceHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
