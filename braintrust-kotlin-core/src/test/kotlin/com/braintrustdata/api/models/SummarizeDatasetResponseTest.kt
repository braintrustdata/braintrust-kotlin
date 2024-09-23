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
import com.braintrustdata.api.models.SummarizeDatasetResponse

class SummarizeDatasetResponseTest {

    @Test
    fun createSummarizeDatasetResponse() {
      val summarizeDatasetResponse = SummarizeDatasetResponse.builder()
          .datasetName("dataset_name")
          .datasetUrl("https://example.com")
          .projectName("project_name")
          .projectUrl("https://example.com")
          .dataSummary(DataSummary.builder()
              .totalRecords(123L)
              .build())
          .build()
      assertThat(summarizeDatasetResponse).isNotNull
      assertThat(summarizeDatasetResponse.datasetName()).isEqualTo("dataset_name")
      assertThat(summarizeDatasetResponse.datasetUrl()).isEqualTo("https://example.com")
      assertThat(summarizeDatasetResponse.projectName()).isEqualTo("project_name")
      assertThat(summarizeDatasetResponse.projectUrl()).isEqualTo("https://example.com")
      assertThat(summarizeDatasetResponse.dataSummary()).isEqualTo(DataSummary.builder()
          .totalRecords(123L)
          .build())
    }
}
