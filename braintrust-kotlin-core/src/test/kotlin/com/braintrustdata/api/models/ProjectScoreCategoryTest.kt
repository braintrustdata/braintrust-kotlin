// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonString
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.models.ProjectScoreCategory

class ProjectScoreCategoryTest {

    @Test
    fun createProjectScoreCategory() {
      val projectScoreCategory = ProjectScoreCategory.builder()
          .name("name")
          .value(42.23)
          .build()
      assertThat(projectScoreCategory).isNotNull
      assertThat(projectScoreCategory.name()).isEqualTo("name")
      assertThat(projectScoreCategory.value()).isEqualTo(42.23)
    }
}
