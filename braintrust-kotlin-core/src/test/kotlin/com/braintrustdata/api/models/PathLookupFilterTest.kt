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
import com.braintrustdata.api.models.PathLookupFilter

class PathLookupFilterTest {

    @Test
    fun createPathLookupFilter() {
      val pathLookupFilter = PathLookupFilter.builder()
          .path(listOf("string"))
          .type(PathLookupFilter.Type.PATH_LOOKUP)
          .value(JsonValue.from(mapOf<String, Any>()))
          .build()
      assertThat(pathLookupFilter).isNotNull
      assertThat(pathLookupFilter.path()).containsExactly("string")
      assertThat(pathLookupFilter.type()).isEqualTo(PathLookupFilter.Type.PATH_LOOKUP)
      assertThat(pathLookupFilter._value()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }
}
