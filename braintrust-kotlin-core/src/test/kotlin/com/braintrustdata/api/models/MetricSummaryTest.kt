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
import com.braintrustdata.api.models.MetricSummary

class MetricSummaryTest {

    @Test
    fun createMetricSummary() {
      val metricSummary = MetricSummary.builder()
          .improvements(123L)
          .metric(42.23)
          .name("name")
          .regressions(123L)
          .unit("unit")
          .diff(42.23)
          .build()
      assertThat(metricSummary).isNotNull
      assertThat(metricSummary.improvements()).isEqualTo(123L)
      assertThat(metricSummary.metric()).isEqualTo(42.23)
      assertThat(metricSummary.name()).isEqualTo("name")
      assertThat(metricSummary.regressions()).isEqualTo(123L)
      assertThat(metricSummary.unit()).isEqualTo("unit")
      assertThat(metricSummary.diff()).isEqualTo(42.23)
    }
}
