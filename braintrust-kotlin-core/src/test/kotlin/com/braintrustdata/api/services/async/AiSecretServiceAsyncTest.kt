// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.TestServerExtension
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClientAsync
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.models.AiSecretCreateParams
import com.braintrustdata.api.models.AiSecretDeleteParams
import com.braintrustdata.api.models.AiSecretFindAndDeleteParams
import com.braintrustdata.api.models.AiSecretListParams
import com.braintrustdata.api.models.AiSecretReplaceParams
import com.braintrustdata.api.models.AiSecretRetrieveParams
import com.braintrustdata.api.models.AiSecretUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AiSecretServiceAsyncTest {

    @Test
    suspend fun create() {
      val client = BraintrustOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val aiSecretServiceAsync = client.aiSecrets()

      val aISecret = aiSecretServiceAsync.create(AiSecretCreateParams.builder()
          .name("name")
          .metadata(AiSecretCreateParams.Metadata.builder()
              .putAdditionalProperty("foo", JsonValue.from("bar"))
              .build())
          .orgName("org_name")
          .secret("secret")
          .type("type")
          .build())

      aISecret.validate()
    }

    @Test
    suspend fun retrieve() {
      val client = BraintrustOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val aiSecretServiceAsync = client.aiSecrets()

      val aISecret = aiSecretServiceAsync.retrieve(AiSecretRetrieveParams.builder()
          .aiSecretId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())

      aISecret.validate()
    }

    @Test
    suspend fun update() {
      val client = BraintrustOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val aiSecretServiceAsync = client.aiSecrets()

      val aISecret = aiSecretServiceAsync.update(AiSecretUpdateParams.builder()
          .aiSecretId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .metadata(AiSecretUpdateParams.Metadata.builder()
              .putAdditionalProperty("foo", JsonValue.from("bar"))
              .build())
          .name("name")
          .secret("secret")
          .type("type")
          .build())

      aISecret.validate()
    }

    @Test
    suspend fun list() {
      val client = BraintrustOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val aiSecretServiceAsync = client.aiSecrets()

      val page = aiSecretServiceAsync.list()

      page.response().validate()
    }

    @Test
    suspend fun delete() {
      val client = BraintrustOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val aiSecretServiceAsync = client.aiSecrets()

      val aISecret = aiSecretServiceAsync.delete(AiSecretDeleteParams.builder()
          .aiSecretId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())

      aISecret.validate()
    }

    @Test
    suspend fun findAndDelete() {
      val client = BraintrustOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val aiSecretServiceAsync = client.aiSecrets()

      val aISecret = aiSecretServiceAsync.findAndDelete(AiSecretFindAndDeleteParams.builder()
          .name("name")
          .orgName("org_name")
          .build())

      aISecret.validate()
    }

    @Test
    suspend fun replace() {
      val client = BraintrustOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val aiSecretServiceAsync = client.aiSecrets()

      val aISecret = aiSecretServiceAsync.replace(AiSecretReplaceParams.builder()
          .name("name")
          .metadata(AiSecretReplaceParams.Metadata.builder()
              .putAdditionalProperty("foo", JsonValue.from("bar"))
              .build())
          .orgName("org_name")
          .secret("secret")
          .type("type")
          .build())

      aISecret.validate()
    }
}
