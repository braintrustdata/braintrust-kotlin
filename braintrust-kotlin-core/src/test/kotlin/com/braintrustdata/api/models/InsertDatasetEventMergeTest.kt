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
import com.braintrustdata.api.models.InsertDatasetEventMerge

class InsertDatasetEventMergeTest {

    @Test
    fun createInsertDatasetEventMerge() {
      val insertDatasetEventMerge = InsertDatasetEventMerge.builder()
          ._isMerge(true)
          .id("id")
          ._mergePaths(listOf(listOf("string")))
          ._objectDelete(true)
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .expected(JsonValue.from(mapOf<String, Any>()))
          .input(JsonValue.from(mapOf<String, Any>()))
          .metadata(InsertDatasetEventMerge.Metadata.builder().build())
          .tags(listOf("string"))
          .build()
      assertThat(insertDatasetEventMerge).isNotNull
      assertThat(insertDatasetEventMerge._isMerge()).isEqualTo(true)
      assertThat(insertDatasetEventMerge.id()).isEqualTo("id")
      assertThat(insertDatasetEventMerge._mergePaths()).containsExactly(listOf("string"))
      assertThat(insertDatasetEventMerge._objectDelete()).isEqualTo(true)
      assertThat(insertDatasetEventMerge.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(insertDatasetEventMerge._expected()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
      assertThat(insertDatasetEventMerge._input()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
      assertThat(insertDatasetEventMerge.metadata()).isEqualTo(InsertDatasetEventMerge.Metadata.builder().build())
      assertThat(insertDatasetEventMerge.tags()).containsExactly("string")
    }
}
