// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonNull
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InsertDatasetEventMergeTest {

    @Test
    fun createInsertDatasetEventMerge() {
        val insertDatasetEventMerge =
            InsertDatasetEventMerge.builder()
                ._isMerge(true)
                .id("id")
                ._mergePaths(listOf(listOf("string")))
                ._objectDelete(true)
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .expected(JsonNull.of())
                .input(JsonNull.of())
                .metadata(InsertDatasetEventMerge.Metadata.builder().build())
                .tags(listOf("string"))
                .build()
        assertThat(insertDatasetEventMerge).isNotNull
        assertThat(insertDatasetEventMerge._isMerge()).isEqualTo(true)
        assertThat(insertDatasetEventMerge.id()).isEqualTo("id")
        assertThat(insertDatasetEventMerge._mergePaths()).containsExactly(listOf("string"))
        assertThat(insertDatasetEventMerge._objectDelete()).isEqualTo(true)
        assertThat(insertDatasetEventMerge.created())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(insertDatasetEventMerge._expected()).isEqualTo(JsonNull.of())
        assertThat(insertDatasetEventMerge._input()).isEqualTo(JsonNull.of())
        assertThat(insertDatasetEventMerge.metadata())
            .isEqualTo(InsertDatasetEventMerge.Metadata.builder().build())
        assertThat(insertDatasetEventMerge.tags()).containsExactly("string")
    }
}
