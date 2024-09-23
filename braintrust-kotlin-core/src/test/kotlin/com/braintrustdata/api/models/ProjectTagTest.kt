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
import com.braintrustdata.api.models.ProjectTag

class ProjectTagTest {

    @Test
    fun createProjectTag() {
      val projectTag = ProjectTag.builder()
          .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .name("name")
          .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .color("color")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .description("description")
          .build()
      assertThat(projectTag).isNotNull
      assertThat(projectTag.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(projectTag.name()).isEqualTo("name")
      assertThat(projectTag.projectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(projectTag.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(projectTag.color()).isEqualTo("color")
      assertThat(projectTag.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(projectTag.description()).isEqualTo("description")
    }
}
