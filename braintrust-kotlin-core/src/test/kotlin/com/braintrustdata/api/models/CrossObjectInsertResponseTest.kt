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
import com.braintrustdata.api.models.CrossObjectInsertResponse

class CrossObjectInsertResponseTest {

    @Test
    fun createCrossObjectInsertResponse() {
      val crossObjectInsertResponse = CrossObjectInsertResponse.builder()
          .dataset(CrossObjectInsertResponse.Dataset.builder().build())
          .experiment(CrossObjectInsertResponse.Experiment.builder().build())
          .projectLogs(CrossObjectInsertResponse.ProjectLogs.builder().build())
          .build()
      assertThat(crossObjectInsertResponse).isNotNull
      assertThat(crossObjectInsertResponse.dataset()).isEqualTo(CrossObjectInsertResponse.Dataset.builder().build())
      assertThat(crossObjectInsertResponse.experiment()).isEqualTo(CrossObjectInsertResponse.Experiment.builder().build())
      assertThat(crossObjectInsertResponse.projectLogs()).isEqualTo(CrossObjectInsertResponse.ProjectLogs.builder().build())
    }
}
