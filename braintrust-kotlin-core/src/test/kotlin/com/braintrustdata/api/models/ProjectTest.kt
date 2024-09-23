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
import com.braintrustdata.api.models.Project

class ProjectTest {

    @Test
    fun createProject() {
      val project = Project.builder()
          .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .name("name")
          .orgId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .deletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .settings(Project.Settings.builder()
              .comparisonKey("comparison_key")
              .build())
          .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(project).isNotNull
      assertThat(project.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(project.name()).isEqualTo("name")
      assertThat(project.orgId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(project.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(project.deletedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(project.settings()).isEqualTo(Project.Settings.builder()
          .comparisonKey("comparison_key")
          .build())
      assertThat(project.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
