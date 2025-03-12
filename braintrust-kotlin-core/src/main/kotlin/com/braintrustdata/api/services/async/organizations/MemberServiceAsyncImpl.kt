// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async.organizations

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.handlers.errorHandler
import com.braintrustdata.api.core.handlers.jsonHandler
import com.braintrustdata.api.core.handlers.withErrorHandler
import com.braintrustdata.api.core.http.HttpMethod
import com.braintrustdata.api.core.http.HttpRequest
import com.braintrustdata.api.core.http.HttpResponse.Handler
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.core.http.json
import com.braintrustdata.api.core.http.parseable
import com.braintrustdata.api.core.prepareAsync
import com.braintrustdata.api.errors.BraintrustError
import com.braintrustdata.api.models.OrganizationMemberUpdateParams
import com.braintrustdata.api.models.PatchOrganizationMembersOutput

class MemberServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : MemberServiceAsync {

    private val withRawResponse: MemberServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): MemberServiceAsync.WithRawResponse = withRawResponse

    override suspend fun update(params: OrganizationMemberUpdateParams, requestOptions: RequestOptions): PatchOrganizationMembersOutput =
        // patch /v1/organization/members
        withRawResponse().update(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : MemberServiceAsync.WithRawResponse {

        private val errorHandler: Handler<BraintrustError> = errorHandler(clientOptions.jsonMapper)

        private val updateHandler: Handler<PatchOrganizationMembersOutput> = jsonHandler<PatchOrganizationMembersOutput>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun update(params: OrganizationMemberUpdateParams, requestOptions: RequestOptions): HttpResponseFor<PatchOrganizationMembersOutput> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PATCH)
            .addPathSegments("v1", "organization", "members")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.executeAsync(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  updateHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }
    }
}
