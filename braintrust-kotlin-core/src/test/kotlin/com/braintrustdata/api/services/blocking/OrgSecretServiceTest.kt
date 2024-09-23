// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.BeforeEach
import com.braintrustdata.api.TestServerExtension
import com.braintrustdata.api.client.BraintrustClient
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClient
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonString
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.http.BinaryResponseContent
import com.braintrustdata.api.services.blocking.OrgSecretService
import com.braintrustdata.api.models.OrgSecretListPage
import com.braintrustdata.api.models.OrgSecretListParams
import com.braintrustdata.api.models.*

@ExtendWith(TestServerExtension::class)
class OrgSecretServiceTest {

    @Test
    fun callCreate() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val orgSecretService = client.orgSecret()
      val orgSecret = orgSecretService.create(OrgSecretCreateParams.builder()
          .name("name")
          .metadata(OrgSecretCreateParams.Metadata.builder().build())
          .orgName("org_name")
          .secret("secret")
          .type("type")
          .build())
      println(orgSecret)
      orgSecret.validate()
    }

    @Test
    fun callRetrieve() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val orgSecretService = client.orgSecret()
      val orgSecret = orgSecretService.retrieve(OrgSecretRetrieveParams.builder()
          .orgSecretId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(orgSecret)
      orgSecret.validate()
    }

    @Test
    fun callUpdate() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val orgSecretService = client.orgSecret()
      val orgSecret = orgSecretService.update(OrgSecretUpdateParams.builder()
          .orgSecretId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .metadata(OrgSecretUpdateParams.Metadata.builder().build())
          .name("name")
          .secret("secret")
          .type("type")
          .build())
      println(orgSecret)
      orgSecret.validate()
    }

    @Test
    fun callList() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val orgSecretService = client.orgSecret()
      val response = orgSecretService.list(OrgSecretListParams.builder().build())
      println(response)
      response.objects().forEach {
          it.validate()
      }
    }

    @Test
    fun callDelete() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val orgSecretService = client.orgSecret()
      val orgSecret = orgSecretService.delete(OrgSecretDeleteParams.builder()
          .orgSecretId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(orgSecret)
      orgSecret.validate()
    }

    @Test
    fun callReplace() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val orgSecretService = client.orgSecret()
      val orgSecret = orgSecretService.replace(OrgSecretReplaceParams.builder()
          .name("name")
          .metadata(OrgSecretReplaceParams.Metadata.builder().build())
          .orgName("org_name")
          .secret("secret")
          .type("type")
          .build())
      println(orgSecret)
      orgSecret.validate()
    }
}
