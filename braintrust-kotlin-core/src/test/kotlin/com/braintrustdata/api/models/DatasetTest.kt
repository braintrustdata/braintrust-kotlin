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
import com.braintrustdata.api.models.Dataset

class DatasetTest {

    @Test
    fun createDataset() {
      val dataset = Dataset.builder()
          .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .name("name")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .deletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .description("description")
          .metadata(Dataset.Metadata.builder().build())
          .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(dataset).isNotNull
      assertThat(dataset.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(dataset.name()).isEqualTo("name")
      assertThat(dataset.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(dataset.deletedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(dataset.description()).isEqualTo("description")
      assertThat(dataset.metadata()).isEqualTo(Dataset.Metadata.builder().build())
      assertThat(dataset.projectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(dataset.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
