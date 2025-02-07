// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InsertDatasetEventTest {

    @Test
    fun createInsertDatasetEvent() {
        val insertDatasetEvent =
            InsertDatasetEvent.builder()
                .id("id")
                ._isMerge(true)
                .addMergePath(listOf("string"))
                ._objectDelete(true)
                ._parentId("_parent_id")
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .expected(JsonValue.from(mapOf<String, Any>()))
                .input(JsonValue.from(mapOf<String, Any>()))
                .metadata(
                    InsertDatasetEvent.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .rootSpanId("root_span_id")
                .spanId("span_id")
                .addSpanParent("string")
                .addTag("string")
                .build()
        assertThat(insertDatasetEvent).isNotNull
        assertThat(insertDatasetEvent.id()).isEqualTo("id")
        assertThat(insertDatasetEvent._isMerge()).isEqualTo(true)
        assertThat(insertDatasetEvent._mergePaths()).containsExactly(listOf("string"))
        assertThat(insertDatasetEvent._objectDelete()).isEqualTo(true)
        assertThat(insertDatasetEvent._parentId()).isEqualTo("_parent_id")
        assertThat(insertDatasetEvent.created())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(insertDatasetEvent._expected()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertDatasetEvent._input()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertDatasetEvent.metadata())
            .isEqualTo(
                InsertDatasetEvent.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(insertDatasetEvent.rootSpanId()).isEqualTo("root_span_id")
        assertThat(insertDatasetEvent.spanId()).isEqualTo("span_id")
        assertThat(insertDatasetEvent.spanParents()).containsExactly("string")
        assertThat(insertDatasetEvent.tags()).containsExactly("string")
    }
}
