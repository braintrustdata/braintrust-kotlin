// File generated from our OpenAPI spec by Stainless.

package com.braintrust.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PromptDeleteResponseTest {

    @Test
    fun createPromptDeleteResponse() {
        val promptDeleteResponse =
            PromptDeleteResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                ._xactId("string")
                .logId(PromptDeleteResponse.LogId.P)
                .name("string")
                .orgId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .slug("string")
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("string")
                .metadata(PromptDeleteResponse.Metadata.builder().build())
                .promptData(
                    PromptDeleteResponse.PromptData.builder()
                        .options(
                            PromptDeleteResponse.PromptData.Options.builder()
                                .model("string")
                                .params(
                                    PromptDeleteResponse.PromptData.Options.Params.ofUnionMember0(
                                        PromptDeleteResponse.PromptData.Options.Params.UnionMember0
                                            .builder()
                                            .frequencyPenalty(42.23)
                                            .functionCall(
                                                PromptDeleteResponse.PromptData.Options.Params
                                                    .UnionMember0
                                                    .FunctionCall
                                                    .ofUnionMember0(
                                                        PromptDeleteResponse.PromptData.Options
                                                            .Params
                                                            .UnionMember0
                                                            .FunctionCall
                                                            .UnionMember0
                                                            .AUTO
                                                    )
                                            )
                                            .maxTokens(42.23)
                                            .n(42.23)
                                            .presencePenalty(42.23)
                                            .responseFormat(
                                                PromptDeleteResponse.PromptData.Options.Params
                                                    .UnionMember0
                                                    .ResponseFormat
                                                    .builder()
                                                    .type(
                                                        PromptDeleteResponse.PromptData.Options
                                                            .Params
                                                            .UnionMember0
                                                            .ResponseFormat
                                                            .Type
                                                            .JSON_OBJECT
                                                    )
                                                    .build()
                                            )
                                            .stop(listOf("string"))
                                            .temperature(42.23)
                                            .toolChoice(
                                                PromptDeleteResponse.PromptData.Options.Params
                                                    .UnionMember0
                                                    .ToolChoice
                                                    .ofUnionMember0(
                                                        PromptDeleteResponse.PromptData.Options
                                                            .Params
                                                            .UnionMember0
                                                            .ToolChoice
                                                            .UnionMember0
                                                            .AUTO
                                                    )
                                            )
                                            .topP(42.23)
                                            .useCache(true)
                                            .build()
                                    )
                                )
                                .position("string")
                                .build()
                        )
                        .origin(
                            PromptDeleteResponse.PromptData.Origin.builder()
                                .projectId("string")
                                .promptId("string")
                                .promptVersion("string")
                                .build()
                        )
                        .prompt(
                            PromptDeleteResponse.PromptData.Prompt.ofUnionMember0(
                                PromptDeleteResponse.PromptData.Prompt.UnionMember0.builder()
                                    .content("string")
                                    .type(
                                        PromptDeleteResponse.PromptData.Prompt.UnionMember0.Type
                                            .COMPLETION
                                    )
                                    .build()
                            )
                        )
                        .build()
                )
                .tags(listOf("string"))
                .build()
        assertThat(promptDeleteResponse).isNotNull
        assertThat(promptDeleteResponse.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(promptDeleteResponse._xactId()).isEqualTo("string")
        assertThat(promptDeleteResponse.logId()).isEqualTo(PromptDeleteResponse.LogId.P)
        assertThat(promptDeleteResponse.name()).isEqualTo("string")
        assertThat(promptDeleteResponse.orgId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(promptDeleteResponse.projectId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(promptDeleteResponse.slug()).isEqualTo("string")
        assertThat(promptDeleteResponse.created())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(promptDeleteResponse.description()).isEqualTo("string")
        assertThat(promptDeleteResponse.metadata())
            .isEqualTo(PromptDeleteResponse.Metadata.builder().build())
        assertThat(promptDeleteResponse.promptData())
            .isEqualTo(
                PromptDeleteResponse.PromptData.builder()
                    .options(
                        PromptDeleteResponse.PromptData.Options.builder()
                            .model("string")
                            .params(
                                PromptDeleteResponse.PromptData.Options.Params.ofUnionMember0(
                                    PromptDeleteResponse.PromptData.Options.Params.UnionMember0
                                        .builder()
                                        .frequencyPenalty(42.23)
                                        .functionCall(
                                            PromptDeleteResponse.PromptData.Options.Params
                                                .UnionMember0
                                                .FunctionCall
                                                .ofUnionMember0(
                                                    PromptDeleteResponse.PromptData.Options.Params
                                                        .UnionMember0
                                                        .FunctionCall
                                                        .UnionMember0
                                                        .AUTO
                                                )
                                        )
                                        .maxTokens(42.23)
                                        .n(42.23)
                                        .presencePenalty(42.23)
                                        .responseFormat(
                                            PromptDeleteResponse.PromptData.Options.Params
                                                .UnionMember0
                                                .ResponseFormat
                                                .builder()
                                                .type(
                                                    PromptDeleteResponse.PromptData.Options.Params
                                                        .UnionMember0
                                                        .ResponseFormat
                                                        .Type
                                                        .JSON_OBJECT
                                                )
                                                .build()
                                        )
                                        .stop(listOf("string"))
                                        .temperature(42.23)
                                        .toolChoice(
                                            PromptDeleteResponse.PromptData.Options.Params
                                                .UnionMember0
                                                .ToolChoice
                                                .ofUnionMember0(
                                                    PromptDeleteResponse.PromptData.Options.Params
                                                        .UnionMember0
                                                        .ToolChoice
                                                        .UnionMember0
                                                        .AUTO
                                                )
                                        )
                                        .topP(42.23)
                                        .useCache(true)
                                        .build()
                                )
                            )
                            .position("string")
                            .build()
                    )
                    .origin(
                        PromptDeleteResponse.PromptData.Origin.builder()
                            .projectId("string")
                            .promptId("string")
                            .promptVersion("string")
                            .build()
                    )
                    .prompt(
                        PromptDeleteResponse.PromptData.Prompt.ofUnionMember0(
                            PromptDeleteResponse.PromptData.Prompt.UnionMember0.builder()
                                .content("string")
                                .type(
                                    PromptDeleteResponse.PromptData.Prompt.UnionMember0.Type
                                        .COMPLETION
                                )
                                .build()
                        )
                    )
                    .build()
            )
        assertThat(promptDeleteResponse.tags()).containsExactly("string")
    }
}
