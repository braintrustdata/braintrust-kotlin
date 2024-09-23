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
import com.braintrustdata.api.models.DataSummary

class DataSummaryTest {

    @Test
    fun createDataSummary() {
      val dataSummary = DataSummary.builder()
          .totalRecords(123L)
          .build()
      assertThat(dataSummary).isNotNull
      assertThat(dataSummary.totalRecords()).isEqualTo(123L)
    }
}
