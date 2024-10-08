// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonNull
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProjectLogsEventTest {

    @Test
    fun createProjectLogsEvent() {
        val projectLogsEvent =
            ProjectLogsEvent.builder()
                .id("id")
                ._xactId("_xact_id")
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .logId(ProjectLogsEvent.LogId.G)
                .orgId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .rootSpanId("root_span_id")
                .spanId("span_id")
                .context(
                    ProjectLogsEvent.Context.builder()
                        .callerFilename("caller_filename")
                        .callerFunctionname("caller_functionname")
                        .callerLineno(123L)
                        .build()
                )
                .error(JsonNull.of())
                .expected(JsonNull.of())
                .input(JsonNull.of())
                .metadata(ProjectLogsEvent.Metadata.builder().build())
                .metrics(
                    ProjectLogsEvent.Metrics.builder()
                        .completionTokens(123L)
                        .end(42.23)
                        .promptTokens(123L)
                        .start(42.23)
                        .tokens(123L)
                        .build()
                )
                .output(JsonNull.of())
                .scores(ProjectLogsEvent.Scores.builder().build())
                .spanAttributes(
                    ProjectLogsEvent.SpanAttributes.builder()
                        .name("name")
                        .type(ProjectLogsEvent.SpanAttributes.Type.LLM)
                        .build()
                )
                .spanParents(listOf("string"))
                .tags(listOf("string"))
                .build()
        assertThat(projectLogsEvent).isNotNull
        assertThat(projectLogsEvent.id()).isEqualTo("id")
        assertThat(projectLogsEvent._xactId()).isEqualTo("_xact_id")
        assertThat(projectLogsEvent.created())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(projectLogsEvent.logId()).isEqualTo(ProjectLogsEvent.LogId.G)
        assertThat(projectLogsEvent.orgId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(projectLogsEvent.projectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(projectLogsEvent.rootSpanId()).isEqualTo("root_span_id")
        assertThat(projectLogsEvent.spanId()).isEqualTo("span_id")
        assertThat(projectLogsEvent.context())
            .isEqualTo(
                ProjectLogsEvent.Context.builder()
                    .callerFilename("caller_filename")
                    .callerFunctionname("caller_functionname")
                    .callerLineno(123L)
                    .build()
            )
        assertThat(projectLogsEvent._error()).isEqualTo(JsonNull.of())
        assertThat(projectLogsEvent._expected()).isEqualTo(JsonNull.of())
        assertThat(projectLogsEvent._input()).isEqualTo(JsonNull.of())
        assertThat(projectLogsEvent.metadata())
            .isEqualTo(ProjectLogsEvent.Metadata.builder().build())
        assertThat(projectLogsEvent.metrics())
            .isEqualTo(
                ProjectLogsEvent.Metrics.builder()
                    .completionTokens(123L)
                    .end(42.23)
                    .promptTokens(123L)
                    .start(42.23)
                    .tokens(123L)
                    .build()
            )
        assertThat(projectLogsEvent._output()).isEqualTo(JsonNull.of())
        assertThat(projectLogsEvent.scores()).isEqualTo(ProjectLogsEvent.Scores.builder().build())
        assertThat(projectLogsEvent.spanAttributes())
            .isEqualTo(
                ProjectLogsEvent.SpanAttributes.builder()
                    .name("name")
                    .type(ProjectLogsEvent.SpanAttributes.Type.LLM)
                    .build()
            )
        assertThat(projectLogsEvent.spanParents()).containsExactly("string")
        assertThat(projectLogsEvent.tags()).containsExactly("string")
    }
}
