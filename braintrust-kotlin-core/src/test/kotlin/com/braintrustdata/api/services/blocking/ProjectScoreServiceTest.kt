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
import com.braintrustdata.api.services.blocking.ProjectScoreService
import com.braintrustdata.api.models.ProjectScoreListPage
import com.braintrustdata.api.models.ProjectScoreListParams
import com.braintrustdata.api.models.*

@ExtendWith(TestServerExtension::class)
class ProjectScoreServiceTest {

    @Test
    fun callCreate() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val projectScoreService = client.projectScore()
      val projectScore = projectScoreService.create(ProjectScoreCreateParams.builder()
          .name("name")
          .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .scoreType(ProjectScoreCreateParams.ScoreType.SLIDER)
          .categories(ProjectScoreCreateParams.Categories.ofList<ProjectScoreCategory>(listOf(ProjectScoreCategory.builder()
              .name("name")
              .value(42.23)
              .build())))
          .description("description")
          .build())
      println(projectScore)
      projectScore.validate()
    }

    @Test
    fun callRetrieve() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val projectScoreService = client.projectScore()
      val projectScore = projectScoreService.retrieve(ProjectScoreRetrieveParams.builder()
          .projectScoreId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(projectScore)
      projectScore.validate()
    }

    @Test
    fun callUpdate() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val projectScoreService = client.projectScore()
      val projectScore = projectScoreService.update(ProjectScoreUpdateParams.builder()
          .projectScoreId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .categories(ProjectScoreUpdateParams.Categories.ofList<ProjectScoreCategory>(listOf(ProjectScoreCategory.builder()
              .name("name")
              .value(42.23)
              .build())))
          .description("description")
          .name("name")
          .scoreType(ProjectScoreUpdateParams.ScoreType.SLIDER)
          .build())
      println(projectScore)
      projectScore.validate()
    }

    @Test
    fun callList() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val projectScoreService = client.projectScore()
      val response = projectScoreService.list(ProjectScoreListParams.builder().build())
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
      val projectScoreService = client.projectScore()
      val projectScore = projectScoreService.delete(ProjectScoreDeleteParams.builder()
          .projectScoreId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(projectScore)
      projectScore.validate()
    }

    @Test
    fun callReplace() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val projectScoreService = client.projectScore()
      val projectScore = projectScoreService.replace(ProjectScoreReplaceParams.builder()
          .name("name")
          .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .scoreType(ProjectScoreReplaceParams.ScoreType.SLIDER)
          .categories(ProjectScoreReplaceParams.Categories.ofList<ProjectScoreCategory>(listOf(ProjectScoreCategory.builder()
              .name("name")
              .value(42.23)
              .build())))
          .description("description")
          .build())
      println(projectScore)
      projectScore.validate()
    }
}
