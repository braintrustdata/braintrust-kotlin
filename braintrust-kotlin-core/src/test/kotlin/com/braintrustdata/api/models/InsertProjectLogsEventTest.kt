// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InsertProjectLogsEventTest {

    @Test
    fun create() {
        val insertProjectLogsEvent =
            InsertProjectLogsEvent.builder()
                .id("id")
                ._isMerge(true)
                .addMergePath(listOf("string"))
                ._objectDelete(true)
                ._parentId("_parent_id")
                .context(
                    InsertProjectLogsEvent.Context.builder()
                        .callerFilename("caller_filename")
                        .callerFunctionname("caller_functionname")
                        .callerLineno(0L)
                        .build()
                )
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .error(JsonValue.from(mapOf<String, Any>()))
                .expected(JsonValue.from(mapOf<String, Any>()))
                .input(JsonValue.from(mapOf<String, Any>()))
                .metadata(InsertProjectLogsEvent.Metadata.builder().model("model").build())
                .metrics(
                    InsertProjectLogsEvent.Metrics.builder()
                        .callerFilename(JsonValue.from(mapOf<String, Any>()))
                        .callerFunctionname(JsonValue.from(mapOf<String, Any>()))
                        .callerLineno(JsonValue.from(mapOf<String, Any>()))
                        .completionTokens(0L)
                        .end(0.0)
                        .promptTokens(0L)
                        .start(0.0)
                        .tokens(0L)
                        .build()
                )
                .origin(
                    ObjectReference.builder()
                        .id("id")
                        ._xactId("_xact_id")
                        .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .objectType(ObjectReference.ObjectType.EXPERIMENT)
                        .created("created")
                        .build()
                )
                .output(JsonValue.from(mapOf<String, Any>()))
                .rootSpanId("root_span_id")
                .scores(
                    InsertProjectLogsEvent.Scores.builder()
                        .putAdditionalProperty("foo", JsonValue.from(0))
                        .build()
                )
                .spanAttributes(SpanAttributes.builder().name("name").type(SpanType.LLM).build())
                .spanId("span_id")
                .addSpanParent("string")
                .addTag("string")
                .build()

        assertThat(insertProjectLogsEvent.id()).isEqualTo("id")
        assertThat(insertProjectLogsEvent._isMerge()).isEqualTo(true)
        assertThat(insertProjectLogsEvent._mergePaths()).containsExactly(listOf("string"))
        assertThat(insertProjectLogsEvent._objectDelete()).isEqualTo(true)
        assertThat(insertProjectLogsEvent._parentId()).isEqualTo("_parent_id")
        assertThat(insertProjectLogsEvent.context())
            .isEqualTo(
                InsertProjectLogsEvent.Context.builder()
                    .callerFilename("caller_filename")
                    .callerFunctionname("caller_functionname")
                    .callerLineno(0L)
                    .build()
            )
        assertThat(insertProjectLogsEvent.created())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(insertProjectLogsEvent._error()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertProjectLogsEvent._expected())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertProjectLogsEvent._input()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertProjectLogsEvent.metadata())
            .isEqualTo(InsertProjectLogsEvent.Metadata.builder().model("model").build())
        assertThat(insertProjectLogsEvent.metrics())
            .isEqualTo(
                InsertProjectLogsEvent.Metrics.builder()
                    .callerFilename(JsonValue.from(mapOf<String, Any>()))
                    .callerFunctionname(JsonValue.from(mapOf<String, Any>()))
                    .callerLineno(JsonValue.from(mapOf<String, Any>()))
                    .completionTokens(0L)
                    .end(0.0)
                    .promptTokens(0L)
                    .start(0.0)
                    .tokens(0L)
                    .build()
            )
        assertThat(insertProjectLogsEvent.origin())
            .isEqualTo(
                ObjectReference.builder()
                    .id("id")
                    ._xactId("_xact_id")
                    .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .objectType(ObjectReference.ObjectType.EXPERIMENT)
                    .created("created")
                    .build()
            )
        assertThat(insertProjectLogsEvent._output()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertProjectLogsEvent.rootSpanId()).isEqualTo("root_span_id")
        assertThat(insertProjectLogsEvent.scores())
            .isEqualTo(
                InsertProjectLogsEvent.Scores.builder()
                    .putAdditionalProperty("foo", JsonValue.from(0))
                    .build()
            )
        assertThat(insertProjectLogsEvent.spanAttributes())
            .isEqualTo(SpanAttributes.builder().name("name").type(SpanType.LLM).build())
        assertThat(insertProjectLogsEvent.spanId()).isEqualTo("span_id")
        assertThat(insertProjectLogsEvent.spanParents()).containsExactly("string")
        assertThat(insertProjectLogsEvent.tags()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val insertProjectLogsEvent =
            InsertProjectLogsEvent.builder()
                .id("id")
                ._isMerge(true)
                .addMergePath(listOf("string"))
                ._objectDelete(true)
                ._parentId("_parent_id")
                .context(
                    InsertProjectLogsEvent.Context.builder()
                        .callerFilename("caller_filename")
                        .callerFunctionname("caller_functionname")
                        .callerLineno(0L)
                        .build()
                )
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .error(JsonValue.from(mapOf<String, Any>()))
                .expected(JsonValue.from(mapOf<String, Any>()))
                .input(JsonValue.from(mapOf<String, Any>()))
                .metadata(InsertProjectLogsEvent.Metadata.builder().model("model").build())
                .metrics(
                    InsertProjectLogsEvent.Metrics.builder()
                        .callerFilename(JsonValue.from(mapOf<String, Any>()))
                        .callerFunctionname(JsonValue.from(mapOf<String, Any>()))
                        .callerLineno(JsonValue.from(mapOf<String, Any>()))
                        .completionTokens(0L)
                        .end(0.0)
                        .promptTokens(0L)
                        .start(0.0)
                        .tokens(0L)
                        .build()
                )
                .origin(
                    ObjectReference.builder()
                        .id("id")
                        ._xactId("_xact_id")
                        .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .objectType(ObjectReference.ObjectType.EXPERIMENT)
                        .created("created")
                        .build()
                )
                .output(JsonValue.from(mapOf<String, Any>()))
                .rootSpanId("root_span_id")
                .scores(
                    InsertProjectLogsEvent.Scores.builder()
                        .putAdditionalProperty("foo", JsonValue.from(0))
                        .build()
                )
                .spanAttributes(SpanAttributes.builder().name("name").type(SpanType.LLM).build())
                .spanId("span_id")
                .addSpanParent("string")
                .addTag("string")
                .build()

        val roundtrippedInsertProjectLogsEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(insertProjectLogsEvent),
                jacksonTypeRef<InsertProjectLogsEvent>(),
            )

        assertThat(roundtrippedInsertProjectLogsEvent).isEqualTo(insertProjectLogsEvent)
    }
}
