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
import com.braintrustdata.api.models.ViewOptions

class ViewOptionsTest {

    @Test
    fun createViewOptions() {
      val viewOptions = ViewOptions.builder()
          .columnOrder(listOf("string"))
          .columnSizing(ViewOptions.ColumnSizing.builder().build())
          .columnVisibility(ViewOptions.ColumnVisibility.builder().build())
          .build()
      assertThat(viewOptions).isNotNull
      assertThat(viewOptions.columnOrder()).containsExactly("string")
      assertThat(viewOptions.columnSizing()).isEqualTo(ViewOptions.ColumnSizing.builder().build())
      assertThat(viewOptions.columnVisibility()).isEqualTo(ViewOptions.ColumnVisibility.builder().build())
    }
}
