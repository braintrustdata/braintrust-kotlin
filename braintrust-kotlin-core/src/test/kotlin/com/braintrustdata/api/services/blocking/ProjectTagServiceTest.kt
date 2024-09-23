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
import com.braintrustdata.api.services.blocking.ProjectTagService
import com.braintrustdata.api.models.ProjectTagListPage
import com.braintrustdata.api.models.ProjectTagListParams
import com.braintrustdata.api.models.*

@ExtendWith(TestServerExtension::class)
class ProjectTagServiceTest {

    @Test
    fun callCreate() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val projectTagService = client.projectTag()
      val projectTag = projectTagService.create(ProjectTagCreateParams.builder()
          .name("name")
          .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .color("color")
          .description("description")
          .build())
      println(projectTag)
      projectTag.validate()
    }

    @Test
    fun callRetrieve() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val projectTagService = client.projectTag()
      val projectTag = projectTagService.retrieve(ProjectTagRetrieveParams.builder()
          .projectTagId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(projectTag)
      projectTag.validate()
    }

    @Test
    fun callUpdate() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val projectTagService = client.projectTag()
      val projectTag = projectTagService.update(ProjectTagUpdateParams.builder()
          .projectTagId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .color("color")
          .description("description")
          .name("name")
          .build())
      println(projectTag)
      projectTag.validate()
    }

    @Test
    fun callList() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val projectTagService = client.projectTag()
      val response = projectTagService.list(ProjectTagListParams.builder().build())
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
      val projectTagService = client.projectTag()
      val projectTag = projectTagService.delete(ProjectTagDeleteParams.builder()
          .projectTagId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(projectTag)
      projectTag.validate()
    }

    @Test
    fun callReplace() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val projectTagService = client.projectTag()
      val projectTag = projectTagService.replace(ProjectTagReplaceParams.builder()
          .name("name")
          .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .color("color")
          .description("description")
          .build())
      println(projectTag)
      projectTag.validate()
    }
}
