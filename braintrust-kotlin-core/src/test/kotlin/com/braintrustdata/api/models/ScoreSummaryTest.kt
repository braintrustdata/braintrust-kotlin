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
import com.braintrustdata.api.models.ScoreSummary

class ScoreSummaryTest {

    @Test
    fun createScoreSummary() {
      val scoreSummary = ScoreSummary.builder()
          .improvements(123L)
          .name("name")
          .regressions(123L)
          .score(1.0)
          .diff(1.0)
          .build()
      assertThat(scoreSummary).isNotNull
      assertThat(scoreSummary.improvements()).isEqualTo(123L)
      assertThat(scoreSummary.name()).isEqualTo("name")
      assertThat(scoreSummary.regressions()).isEqualTo(123L)
      assertThat(scoreSummary.score()).isEqualTo(1.0)
      assertThat(scoreSummary.diff()).isEqualTo(1.0)
    }
}
