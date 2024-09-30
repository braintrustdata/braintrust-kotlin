// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonNull
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InsertExperimentEventMergeTest {

    @Test
    fun createInsertExperimentEventMerge() {
        val insertExperimentEventMerge =
            InsertExperimentEventMerge.builder()
                ._isMerge(true)
                .id("id")
                ._mergePaths(listOf(listOf("string")))
                ._objectDelete(true)
                .context(
                    InsertExperimentEventMerge.Context.builder()
                        .callerFilename("caller_filename")
                        .callerFunctionname("caller_functionname")
                        .callerLineno(123L)
                        .build()
                )
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .datasetRecordId("dataset_record_id")
                .error(JsonNull.of())
                .expected(JsonNull.of())
                .input(JsonNull.of())
                .metadata(InsertExperimentEventMerge.Metadata.builder().build())
                .metrics(
                    InsertExperimentEventMerge.Metrics.builder()
                        .completionTokens(123L)
                        .end(42.23)
                        .promptTokens(123L)
                        .start(42.23)
                        .tokens(123L)
                        .build()
                )
                .output(JsonNull.of())
                .scores(InsertExperimentEventMerge.Scores.builder().build())
                .spanAttributes(
                    InsertExperimentEventMerge.SpanAttributes.builder()
                        .name("name")
                        .type(InsertExperimentEventMerge.SpanAttributes.Type.LLM)
                        .build()
                )
                .tags(listOf("string"))
                .build()
        assertThat(insertExperimentEventMerge).isNotNull
        assertThat(insertExperimentEventMerge._isMerge()).isEqualTo(true)
        assertThat(insertExperimentEventMerge.id()).isEqualTo("id")
        assertThat(insertExperimentEventMerge._mergePaths()).containsExactly(listOf("string"))
        assertThat(insertExperimentEventMerge._objectDelete()).isEqualTo(true)
        assertThat(insertExperimentEventMerge.context())
            .isEqualTo(
                InsertExperimentEventMerge.Context.builder()
                    .callerFilename("caller_filename")
                    .callerFunctionname("caller_functionname")
                    .callerLineno(123L)
                    .build()
            )
        assertThat(insertExperimentEventMerge.created())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(insertExperimentEventMerge.datasetRecordId()).isEqualTo("dataset_record_id")
        assertThat(insertExperimentEventMerge._error()).isEqualTo(JsonNull.of())
        assertThat(insertExperimentEventMerge._expected()).isEqualTo(JsonNull.of())
        assertThat(insertExperimentEventMerge._input()).isEqualTo(JsonNull.of())
        assertThat(insertExperimentEventMerge.metadata())
            .isEqualTo(InsertExperimentEventMerge.Metadata.builder().build())
        assertThat(insertExperimentEventMerge.metrics())
            .isEqualTo(
                InsertExperimentEventMerge.Metrics.builder()
                    .completionTokens(123L)
                    .end(42.23)
                    .promptTokens(123L)
                    .start(42.23)
                    .tokens(123L)
                    .build()
            )
        assertThat(insertExperimentEventMerge._output()).isEqualTo(JsonNull.of())
        assertThat(insertExperimentEventMerge.scores())
            .isEqualTo(InsertExperimentEventMerge.Scores.builder().build())
        assertThat(insertExperimentEventMerge.spanAttributes())
            .isEqualTo(
                InsertExperimentEventMerge.SpanAttributes.builder()
                    .name("name")
                    .type(InsertExperimentEventMerge.SpanAttributes.Type.LLM)
                    .build()
            )
        assertThat(insertExperimentEventMerge.tags()).containsExactly("string")
    }
}
