// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InsertExperimentEventTest {

    @Test
    fun createInsertExperimentEvent() {
        val insertExperimentEvent =
            InsertExperimentEvent.builder()
                .id("id")
                ._isMerge(true)
                .addMergePath(listOf("string"))
                ._objectDelete(true)
                ._parentId("_parent_id")
                .context(
                    InsertExperimentEvent.Context.builder()
                        .callerFilename("caller_filename")
                        .callerFunctionname("caller_functionname")
                        .callerLineno(0L)
                        .build()
                )
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .error(JsonValue.from(mapOf<String, Any>()))
                .expected(JsonValue.from(mapOf<String, Any>()))
                .input(JsonValue.from(mapOf<String, Any>()))
                .metadata(InsertExperimentEvent.Metadata.builder().model("model").build())
                .metrics(
                    InsertExperimentEvent.Metrics.builder()
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
                    InsertExperimentEvent.Scores.builder()
                        .putAdditionalProperty("foo", JsonValue.from(0))
                        .build()
                )
                .spanAttributes(SpanAttributes.builder().name("name").type(SpanType.LLM).build())
                .spanId("span_id")
                .addSpanParent("string")
                .addTag("string")
                .build()
        assertThat(insertExperimentEvent).isNotNull
        assertThat(insertExperimentEvent.id()).isEqualTo("id")
        assertThat(insertExperimentEvent._isMerge()).isEqualTo(true)
        assertThat(insertExperimentEvent._mergePaths()).containsExactly(listOf("string"))
        assertThat(insertExperimentEvent._objectDelete()).isEqualTo(true)
        assertThat(insertExperimentEvent._parentId()).isEqualTo("_parent_id")
        assertThat(insertExperimentEvent.context())
            .isEqualTo(
                InsertExperimentEvent.Context.builder()
                    .callerFilename("caller_filename")
                    .callerFunctionname("caller_functionname")
                    .callerLineno(0L)
                    .build()
            )
        assertThat(insertExperimentEvent.created())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(insertExperimentEvent._error()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertExperimentEvent._expected())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertExperimentEvent._input()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertExperimentEvent.metadata())
            .isEqualTo(InsertExperimentEvent.Metadata.builder().model("model").build())
        assertThat(insertExperimentEvent.metrics())
            .isEqualTo(
                InsertExperimentEvent.Metrics.builder()
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
        assertThat(insertExperimentEvent.origin())
            .isEqualTo(
                ObjectReference.builder()
                    .id("id")
                    ._xactId("_xact_id")
                    .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .objectType(ObjectReference.ObjectType.EXPERIMENT)
                    .created("created")
                    .build()
            )
        assertThat(insertExperimentEvent._output()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(insertExperimentEvent.rootSpanId()).isEqualTo("root_span_id")
        assertThat(insertExperimentEvent.scores())
            .isEqualTo(
                InsertExperimentEvent.Scores.builder()
                    .putAdditionalProperty("foo", JsonValue.from(0))
                    .build()
            )
        assertThat(insertExperimentEvent.spanAttributes())
            .isEqualTo(SpanAttributes.builder().name("name").type(SpanType.LLM).build())
        assertThat(insertExperimentEvent.spanId()).isEqualTo("span_id")
        assertThat(insertExperimentEvent.spanParents()).containsExactly("string")
        assertThat(insertExperimentEvent.tags()).containsExactly("string")
    }
}
