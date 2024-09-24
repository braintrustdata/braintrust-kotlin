// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PromptTest {

    @Test
    fun createPrompt() {
        val prompt =
            Prompt.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                ._xactId("_xact_id")
                .logId(Prompt.LogId.P)
                .name("name")
                .orgId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .slug("slug")
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("description")
                .functionType(Prompt.FunctionType.LLM)
                .metadata(Prompt.Metadata.builder().build())
                .promptData(
                    PromptData.builder()
                        .options(
                            PromptData.Options.builder()
                                .model("model")
                                .params(
                                    PromptData.Options.Params.ofOpenAIModelParams(
                                        PromptData.Options.Params.OpenAIModelParams.builder()
                                            .frequencyPenalty(42.23)
                                            .functionCall(
                                                PromptData.Options.Params.OpenAIModelParams
                                                    .FunctionCall
                                                    .ofAuto(
                                                        PromptData.Options.Params.OpenAIModelParams
                                                            .FunctionCall
                                                            .Auto
                                                            .AUTO
                                                    )
                                            )
                                            .maxTokens(42.23)
                                            .n(42.23)
                                            .presencePenalty(42.23)
                                            .responseFormat(
                                                PromptData.Options.Params.OpenAIModelParams
                                                    .ResponseFormat
                                                    .builder()
                                                    .type(
                                                        PromptData.Options.Params.OpenAIModelParams
                                                            .ResponseFormat
                                                            .Type
                                                            .JSON_OBJECT
                                                    )
                                                    .build()
                                            )
                                            .stop(listOf("string"))
                                            .temperature(42.23)
                                            .toolChoice(
                                                PromptData.Options.Params.OpenAIModelParams
                                                    .ToolChoice
                                                    .ofAuto(
                                                        PromptData.Options.Params.OpenAIModelParams
                                                            .ToolChoice
                                                            .Auto
                                                            .AUTO
                                                    )
                                            )
                                            .topP(42.23)
                                            .useCache(true)
                                            .build()
                                    )
                                )
                                .position("position")
                                .build()
                        )
                        .origin(
                            PromptData.Origin.builder()
                                .projectId("project_id")
                                .promptId("prompt_id")
                                .promptVersion("prompt_version")
                                .build()
                        )
                        .parser(
                            PromptData.Parser.builder()
                                .choiceScores(PromptData.Parser.ChoiceScores.builder().build())
                                .type(PromptData.Parser.Type.LLM_CLASSIFIER)
                                .useCot(true)
                                .build()
                        )
                        .prompt(
                            PromptData.Prompt.ofCompletion(
                                PromptData.Prompt.Completion.builder()
                                    .content("content")
                                    .type(PromptData.Prompt.Completion.Type.COMPLETION)
                                    .build()
                            )
                        )
                        .toolFunctions(
                            listOf(
                                PromptData.ToolFunction.ofFunction(
                                    PromptData.ToolFunction.Function.builder()
                                        .id("id")
                                        .type(PromptData.ToolFunction.Function.Type.FUNCTION)
                                        .build()
                                )
                            )
                        )
                        .build()
                )
                .tags(listOf("string"))
                .build()
        assertThat(prompt).isNotNull
        assertThat(prompt.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(prompt._xactId()).isEqualTo("_xact_id")
        assertThat(prompt.logId()).isEqualTo(Prompt.LogId.P)
        assertThat(prompt.name()).isEqualTo("name")
        assertThat(prompt.orgId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(prompt.projectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(prompt.slug()).isEqualTo("slug")
        assertThat(prompt.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(prompt.description()).isEqualTo("description")
        assertThat(prompt.functionType()).isEqualTo(Prompt.FunctionType.LLM)
        assertThat(prompt.metadata()).isEqualTo(Prompt.Metadata.builder().build())
        assertThat(prompt.promptData())
            .isEqualTo(
                PromptData.builder()
                    .options(
                        PromptData.Options.builder()
                            .model("model")
                            .params(
                                PromptData.Options.Params.ofOpenAIModelParams(
                                    PromptData.Options.Params.OpenAIModelParams.builder()
                                        .frequencyPenalty(42.23)
                                        .functionCall(
                                            PromptData.Options.Params.OpenAIModelParams.FunctionCall
                                                .ofAuto(
                                                    PromptData.Options.Params.OpenAIModelParams
                                                        .FunctionCall
                                                        .Auto
                                                        .AUTO
                                                )
                                        )
                                        .maxTokens(42.23)
                                        .n(42.23)
                                        .presencePenalty(42.23)
                                        .responseFormat(
                                            PromptData.Options.Params.OpenAIModelParams
                                                .ResponseFormat
                                                .builder()
                                                .type(
                                                    PromptData.Options.Params.OpenAIModelParams
                                                        .ResponseFormat
                                                        .Type
                                                        .JSON_OBJECT
                                                )
                                                .build()
                                        )
                                        .stop(listOf("string"))
                                        .temperature(42.23)
                                        .toolChoice(
                                            PromptData.Options.Params.OpenAIModelParams.ToolChoice
                                                .ofAuto(
                                                    PromptData.Options.Params.OpenAIModelParams
                                                        .ToolChoice
                                                        .Auto
                                                        .AUTO
                                                )
                                        )
                                        .topP(42.23)
                                        .useCache(true)
                                        .build()
                                )
                            )
                            .position("position")
                            .build()
                    )
                    .origin(
                        PromptData.Origin.builder()
                            .projectId("project_id")
                            .promptId("prompt_id")
                            .promptVersion("prompt_version")
                            .build()
                    )
                    .parser(
                        PromptData.Parser.builder()
                            .choiceScores(PromptData.Parser.ChoiceScores.builder().build())
                            .type(PromptData.Parser.Type.LLM_CLASSIFIER)
                            .useCot(true)
                            .build()
                    )
                    .prompt(
                        PromptData.Prompt.ofCompletion(
                            PromptData.Prompt.Completion.builder()
                                .content("content")
                                .type(PromptData.Prompt.Completion.Type.COMPLETION)
                                .build()
                        )
                    )
                    .toolFunctions(
                        listOf(
                            PromptData.ToolFunction.ofFunction(
                                PromptData.ToolFunction.Function.builder()
                                    .id("id")
                                    .type(PromptData.ToolFunction.Function.Type.FUNCTION)
                                    .build()
                            )
                        )
                    )
                    .build()
            )
        assertThat(prompt.tags()).containsExactly("string")
    }
}
