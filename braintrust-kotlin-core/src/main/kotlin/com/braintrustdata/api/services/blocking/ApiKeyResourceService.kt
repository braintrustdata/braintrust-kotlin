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
import com.braintrustdata.api.models.ApiKey
import com.braintrustdata.api.models.ApiKeyResourceCreateParams
import com.braintrustdata.api.models.ApiKeyResourceDeleteParams
import com.braintrustdata.api.models.ApiKeyResourceListPage
import com.braintrustdata.api.models.ApiKeyResourceListParams
import com.braintrustdata.api.models.ApiKeyResourceRetrieveParams
import com.braintrustdata.api.models.CreateApiKeyOutput
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

interface ApiKeyResourceService {

    /**
     * Create a new api_key. It is possible to have multiple API keys with the same
     * name. There is no de-duplication
     */
    fun create(params: ApiKeyResourceCreateParams, requestOptions: RequestOptions = RequestOptions.none()): CreateApiKeyOutput

    /** Get an api_key object by its id */
    fun retrieve(params: ApiKeyResourceRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): ApiKey

    /**
     * List out all api_keys. The api_keys are sorted by creation date, with the most
     * recently-created api_keys coming first
     */
    fun list(params: ApiKeyResourceListParams, requestOptions: RequestOptions = RequestOptions.none()): ApiKeyResourceListPage

    /** Delete an api_key object by its id */
    fun delete(params: ApiKeyResourceDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): ApiKey
}
