// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpMethod
import com.braintrustdata.api.core.http.HttpRequest
import com.braintrustdata.api.core.http.HttpResponse.Handler
import com.braintrustdata.api.errors.BraintrustError
import com.braintrustdata.api.models.User
import com.braintrustdata.api.models.UserListPage
import com.braintrustdata.api.models.UserListParams
import com.braintrustdata.api.models.UserRetrieveParams
import com.braintrustdata.api.services.errorHandler
import com.braintrustdata.api.services.jsonHandler
import com.braintrustdata.api.services.withErrorHandler

class UserServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : UserService {

    private val errorHandler: Handler<BraintrustError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<User> =
        jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get a user object by its id */
    override fun retrieve(params: UserRetrieveParams, requestOptions: RequestOptions): User {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "user", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<UserListPage.Response> =
        jsonHandler<UserListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * List out all users. The users are sorted by creation date, with the most recently-created
     * users coming first
     */
    override fun list(params: UserListParams, requestOptions: RequestOptions): UserListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "user")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { UserListPage.of(this, params, it) }
        }
    }
}
