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
import com.braintrustdata.api.models.ViewData

class ViewDataTest {

    @Test
    fun createViewData() {
      val viewData = ViewData.builder()
          .search(ViewDataSearch.builder()
              .filter(listOf(JsonValue.from(mapOf<String, Any>())))
              .match(listOf(JsonValue.from(mapOf<String, Any>())))
              .sort(listOf(JsonValue.from(mapOf<String, Any>())))
              .tag(listOf(JsonValue.from(mapOf<String, Any>())))
              .build())
          .build()
      assertThat(viewData).isNotNull
      assertThat(viewData.search()).isEqualTo(ViewDataSearch.builder()
          .filter(listOf(JsonValue.from(mapOf<String, Any>())))
          .match(listOf(JsonValue.from(mapOf<String, Any>())))
          .sort(listOf(JsonValue.from(mapOf<String, Any>())))
          .tag(listOf(JsonValue.from(mapOf<String, Any>())))
          .build())
    }
}
