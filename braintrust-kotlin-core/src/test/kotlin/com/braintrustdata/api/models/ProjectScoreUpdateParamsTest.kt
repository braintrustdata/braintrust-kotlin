// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.apache.hc.core5.http.ContentType
import com.braintrustdata.api.core.ContentTypes
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonString
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.MultipartFormValue
import com.braintrustdata.api.models.*
import com.braintrustdata.api.models.ProjectScoreUpdateParams
import com.braintrustdata.api.models.ProjectScoreUpdateParams.ProjectScoreUpdateBody

class ProjectScoreUpdateParamsTest {

    @Test
    fun createProjectScoreUpdateParams() {
      ProjectScoreUpdateParams.builder()
          .projectScoreId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .categories(ProjectScoreUpdateParams.Categories.ofList<ProjectScoreCategory>(listOf(ProjectScoreCategory.builder()
              .name("name")
              .value(42.23)
              .build())))
          .description("description")
          .name("name")
          .scoreType(ProjectScoreUpdateParams.ScoreType.SLIDER)
          .build()
    }

    @Test
    fun getBody() {
      val params = ProjectScoreUpdateParams.builder()
          .projectScoreId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .categories(ProjectScoreUpdateParams.Categories.ofList<ProjectScoreCategory>(listOf(ProjectScoreCategory.builder()
              .name("name")
              .value(42.23)
              .build())))
          .description("description")
          .name("name")
          .scoreType(ProjectScoreUpdateParams.ScoreType.SLIDER)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.categories()).isEqualTo(ProjectScoreUpdateParams.Categories.ofList<ProjectScoreCategory>(listOf(ProjectScoreCategory.builder()
          .name("name")
          .value(42.23)
          .build())))
      assertThat(body.description()).isEqualTo("description")
      assertThat(body.name()).isEqualTo("name")
      assertThat(body.scoreType()).isEqualTo(ProjectScoreUpdateParams.ScoreType.SLIDER)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = ProjectScoreUpdateParams.builder()
          .projectScoreId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = ProjectScoreUpdateParams.builder()
          .projectScoreId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(params).isNotNull
      // path param "projectScoreId"
      assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
