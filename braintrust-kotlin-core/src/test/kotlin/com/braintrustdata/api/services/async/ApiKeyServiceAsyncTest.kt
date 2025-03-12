// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.TestServerExtension
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClientAsync
import com.braintrustdata.api.models.ApiKeyCreateParams
import com.braintrustdata.api.models.ApiKeyDeleteParams
import com.braintrustdata.api.models.ApiKeyListParams
import com.braintrustdata.api.models.ApiKeyRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ApiKeyServiceAsyncTest {

    @Test
    suspend fun create() {
      val client = BraintrustOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val apiKeyServiceAsync = client.apiKeys()

      val createApiKeyOutput = apiKeyServiceAsync.create(ApiKeyCreateParams.builder()
          .name("name")
          .orgName("org_name")
          .build())

      createApiKeyOutput.validate()
    }

    @Test
    suspend fun retrieve() {
      val client = BraintrustOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val apiKeyServiceAsync = client.apiKeys()

      val apiKey = apiKeyServiceAsync.retrieve(ApiKeyRetrieveParams.builder()
          .apiKeyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())

      apiKey.validate()
    }

    @Test
    suspend fun list() {
      val client = BraintrustOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val apiKeyServiceAsync = client.apiKeys()

      val page = apiKeyServiceAsync.list()

      page.response().validate()
    }

    @Test
    suspend fun delete() {
      val client = BraintrustOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val apiKeyServiceAsync = client.apiKeys()

      val apiKey = apiKeyServiceAsync.delete(ApiKeyDeleteParams.builder()
          .apiKeyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())

      apiKey.validate()
    }
}
