// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonNull
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InsertExperimentEventReplaceTest {

    @Test
    fun createInsertExperimentEventReplace() {
        val insertExperimentEventReplace =
            InsertExperimentEventReplace.builder()
                .id("id")
                ._isMerge(true)
                ._objectDelete(true)
                ._parentId("_parent_id")
                .context(
                    InsertExperimentEventReplace.Context.builder()
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
                .metadata(InsertExperimentEventReplace.Metadata.builder().build())
                .metrics(
                    InsertExperimentEventReplace.Metrics.builder()
                        .callerFilename(JsonNull.of())
                        .callerFunctionname(JsonNull.of())
                        .callerLineno(JsonNull.of())
                        .completionTokens(123L)
                        .end(42.23)
                        .promptTokens(123L)
                        .start(42.23)
                        .tokens(123L)
                        .build()
                )
                .output(JsonNull.of())
                .scores(InsertExperimentEventReplace.Scores.builder().build())
                .spanAttributes(
                    InsertExperimentEventReplace.SpanAttributes.builder()
                        .name("name")
                        .type(InsertExperimentEventReplace.SpanAttributes.Type.LLM)
                        .build()
                )
                .tags(listOf("string"))
                .build()
        assertThat(insertExperimentEventReplace).isNotNull
        assertThat(insertExperimentEventReplace.id()).isEqualTo("id")
        assertThat(insertExperimentEventReplace._isMerge()).isEqualTo(true)
        assertThat(insertExperimentEventReplace._objectDelete()).isEqualTo(true)
        assertThat(insertExperimentEventReplace._parentId()).isEqualTo("_parent_id")
        assertThat(insertExperimentEventReplace.context())
            .isEqualTo(
                InsertExperimentEventReplace.Context.builder()
                    .callerFilename("caller_filename")
                    .callerFunctionname("caller_functionname")
                    .callerLineno(123L)
                    .build()
            )
        assertThat(insertExperimentEventReplace.created())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(insertExperimentEventReplace.datasetRecordId()).isEqualTo("dataset_record_id")
        assertThat(insertExperimentEventReplace._error()).isEqualTo(JsonNull.of())
        assertThat(insertExperimentEventReplace._expected()).isEqualTo(JsonNull.of())
        assertThat(insertExperimentEventReplace._input()).isEqualTo(JsonNull.of())
        assertThat(insertExperimentEventReplace.metadata())
            .isEqualTo(InsertExperimentEventReplace.Metadata.builder().build())
        assertThat(insertExperimentEventReplace.metrics())
            .isEqualTo(
                InsertExperimentEventReplace.Metrics.builder()
                    .callerFilename(JsonNull.of())
                    .callerFunctionname(JsonNull.of())
                    .callerLineno(JsonNull.of())
                    .completionTokens(123L)
                    .end(42.23)
                    .promptTokens(123L)
                    .start(42.23)
                    .tokens(123L)
                    .build()
            )
        assertThat(insertExperimentEventReplace._output()).isEqualTo(JsonNull.of())
        assertThat(insertExperimentEventReplace.scores())
            .isEqualTo(InsertExperimentEventReplace.Scores.builder().build())
        assertThat(insertExperimentEventReplace.spanAttributes())
            .isEqualTo(
                InsertExperimentEventReplace.SpanAttributes.builder()
                    .name("name")
                    .type(InsertExperimentEventReplace.SpanAttributes.Type.LLM)
                    .build()
            )
        assertThat(insertExperimentEventReplace.tags()).containsExactly("string")
    }
}
