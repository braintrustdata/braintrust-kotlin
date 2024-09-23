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
import com.braintrustdata.api.models.InsertDatasetEventReplace

class InsertDatasetEventReplaceTest {

    @Test
    fun createInsertDatasetEventReplace() {
      val insertDatasetEventReplace = InsertDatasetEventReplace.builder()
          .id("id")
          ._isMerge(true)
          ._objectDelete(true)
          ._parentId("_parent_id")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .expected(JsonValue.from(mapOf<String, Any>()))
          .input(JsonValue.from(mapOf<String, Any>()))
          .metadata(InsertDatasetEventReplace.Metadata.builder().build())
          .tags(listOf("string"))
          .build()
      assertThat(insertDatasetEventReplace).isNotNull
      assertThat(insertDatasetEventReplace.id()).isEqualTo("id")
      assertThat(insertDatasetEventReplace._isMerge()).isEqualTo(true)
      assertThat(insertDatasetEventReplace._objectDelete()).isEqualTo(true)
      assertThat(insertDatasetEventReplace._parentId()).isEqualTo("_parent_id")
      assertThat(insertDatasetEventReplace.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(insertDatasetEventReplace._expected()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
      assertThat(insertDatasetEventReplace._input()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
      assertThat(insertDatasetEventReplace.metadata()).isEqualTo(InsertDatasetEventReplace.Metadata.builder().build())
      assertThat(insertDatasetEventReplace.tags()).containsExactly("string")
    }
}
