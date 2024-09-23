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
import com.braintrustdata.api.models.ViewDataSearch

class ViewDataSearchTest {

    @Test
    fun createViewDataSearch() {
      val viewDataSearch = ViewDataSearch.builder()
          .filter(listOf(JsonValue.from(mapOf<String, Any>())))
          .match(listOf(JsonValue.from(mapOf<String, Any>())))
          .sort(listOf(JsonValue.from(mapOf<String, Any>())))
          .tag(listOf(JsonValue.from(mapOf<String, Any>())))
          .build()
      assertThat(viewDataSearch).isNotNull
      assertThat(viewDataSearch.filter()).containsExactly(JsonValue.from(mapOf<String, Any>()))
      assertThat(viewDataSearch.match()).containsExactly(JsonValue.from(mapOf<String, Any>()))
      assertThat(viewDataSearch.sort()).containsExactly(JsonValue.from(mapOf<String, Any>()))
      assertThat(viewDataSearch.tag()).containsExactly(JsonValue.from(mapOf<String, Any>()))
    }
}
