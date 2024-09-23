// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InsertProjectLogsEventMergeTest {

    @Test
    fun createInsertProjectLogsEventMerge() {
        val insertProjectLogsEventMerge =
            InsertProjectLogsEventMerge.builder()
                ._isMerge(true)
                .id("id")
                ._mergePaths(listOf(listOf("string")))
                ._objectDelete(true)
                .context(
                    InsertProjectLogsEventMerge.Context.builder()
                        .callerFilename("caller_filename")
                        .callerFunctionname("caller_functionname")
                        .callerLineno(123L)
                        .build()
                )
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .error(JsonValue.from(mapOf<String, Any>()))
                .expected(JsonValue.from(mapOf<String, Any>()))
                .input(JsonValue.from(mapOf<String, Any>()))
                .metadata(InsertProjectLogsEventMerge.Metadata.builder().build())
                .metrics(
                    InsertProjectLogsEventMerge.Metrics.builder()
                        .completionTokens(123L)
                        .end(42.23)
                        .promptTokens(123L)
                        .start(42.23)
                        .tokens(123L)
                        .build()
                )
                .output(JsonValue.from(mapOf<String, Any>()))
                .scores(InsertProjectLogsEventMerge.Scores.builder().build())
                .spanAttributes(
                    InsertProjectLogsEventMerge.SpanAttributes.builder()
                        .name("name")
                        .type(InsertProjectLogsEventMerge.SpanAttributes.Type.LLM)
                        .build()
                )
                .tags(listOf("string"))
                .build()
        assertThat(insertProjectLogsEventMerge).isNotNull
        assertThat(insertProjectLogsEventMerge._isMerge()).isEqualTo(true)
        assertThat(insertProjectLogsEventMerge.id()).isEqualTo("id")
        assertThat(insertProjectLogsEventMerge._mergePaths()).containsExactly(listOf("string"))
        assertThat(insertProjectLogsEventMerge._objectDelete()).isEqualTo(true)
        assertThat(insertProjectLogsEventMerge.context())
            .isEqualTo(
                InsertProjectLogsEventMerge.Context.builder()
                    .callerFilename("caller_filename")
                    .callerFunctionname("caller_functionname")
                    .callerLineno(123L)
                    .build()
            )
        assertThat(insertProjectLogsEventMerge.created())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(insertProjectLogsEventMerge._error())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertProjectLogsEventMerge._expected())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertProjectLogsEventMerge._input())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertProjectLogsEventMerge.metadata())
            .isEqualTo(InsertProjectLogsEventMerge.Metadata.builder().build())
        assertThat(insertProjectLogsEventMerge.metrics())
            .isEqualTo(
                InsertProjectLogsEventMerge.Metrics.builder()
                    .completionTokens(123L)
                    .end(42.23)
                    .promptTokens(123L)
                    .start(42.23)
                    .tokens(123L)
                    .build()
            )
        assertThat(insertProjectLogsEventMerge._output())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertProjectLogsEventMerge.scores())
            .isEqualTo(InsertProjectLogsEventMerge.Scores.builder().build())
        assertThat(insertProjectLogsEventMerge.spanAttributes())
            .isEqualTo(
                InsertProjectLogsEventMerge.SpanAttributes.builder()
                    .name("name")
                    .type(InsertProjectLogsEventMerge.SpanAttributes.Type.LLM)
                    .build()
            )
        assertThat(insertProjectLogsEventMerge.tags()).containsExactly("string")
    }
}
