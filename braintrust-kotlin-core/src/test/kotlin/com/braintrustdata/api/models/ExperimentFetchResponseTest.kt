// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExperimentFetchResponseTest {

    @Test
    fun createExperimentFetchResponse() {
        val experimentFetchResponse =
            ExperimentFetchResponse.builder()
                .events(
                    listOf(
                        ExperimentFetchResponse.Event.builder()
                            .id("id")
                            ._xactId("_xact_id")
                            .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .experimentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .rootSpanId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .spanId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .context(
                                ExperimentFetchResponse.Event.Context.builder()
                                    .callerFilename("caller_filename")
                                    .callerFunctionname("caller_functionname")
                                    .callerLineno(123L)
                                    .build()
                            )
                            .datasetRecordId("dataset_record_id")
                            .expected(JsonValue.from(mapOf<String, Any>()))
                            .input(JsonValue.from(mapOf<String, Any>()))
                            .metadata(ExperimentFetchResponse.Event.Metadata.builder().build())
                            .metrics(
                                ExperimentFetchResponse.Event.Metrics.builder()
                                    .completionTokens(123L)
                                    .end(42.23)
                                    .promptTokens(123L)
                                    .start(42.23)
                                    .tokens(123L)
                                    .build()
                            )
                            .output(JsonValue.from(mapOf<String, Any>()))
                            .scores(ExperimentFetchResponse.Event.Scores.builder().build())
                            .spanAttributes(
                                ExperimentFetchResponse.Event.SpanAttributes.builder()
                                    .name("name")
                                    .type(ExperimentFetchResponse.Event.SpanAttributes.Type.LLM)
                                    .build()
                            )
                            .spanParents(listOf("string"))
                            .tags(listOf("string"))
                            .build()
                    )
                )
                .cursor("cursor")
                .build()
        assertThat(experimentFetchResponse).isNotNull
        assertThat(experimentFetchResponse.events())
            .containsExactly(
                ExperimentFetchResponse.Event.builder()
                    .id("id")
                    ._xactId("_xact_id")
                    .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .experimentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .rootSpanId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .spanId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .context(
                        ExperimentFetchResponse.Event.Context.builder()
                            .callerFilename("caller_filename")
                            .callerFunctionname("caller_functionname")
                            .callerLineno(123L)
                            .build()
                    )
                    .datasetRecordId("dataset_record_id")
                    .expected(JsonValue.from(mapOf<String, Any>()))
                    .input(JsonValue.from(mapOf<String, Any>()))
                    .metadata(ExperimentFetchResponse.Event.Metadata.builder().build())
                    .metrics(
                        ExperimentFetchResponse.Event.Metrics.builder()
                            .completionTokens(123L)
                            .end(42.23)
                            .promptTokens(123L)
                            .start(42.23)
                            .tokens(123L)
                            .build()
                    )
                    .output(JsonValue.from(mapOf<String, Any>()))
                    .scores(ExperimentFetchResponse.Event.Scores.builder().build())
                    .spanAttributes(
                        ExperimentFetchResponse.Event.SpanAttributes.builder()
                            .name("name")
                            .type(ExperimentFetchResponse.Event.SpanAttributes.Type.LLM)
                            .build()
                    )
                    .spanParents(listOf("string"))
                    .tags(listOf("string"))
                    .build()
            )
        assertThat(experimentFetchResponse.cursor()).isEqualTo("cursor")
    }
}