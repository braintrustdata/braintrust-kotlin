// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PromptOptionsTest {

    @Test
    fun createPromptOptions() {
        val promptOptions =
            PromptOptions.builder()
                .model("model")
                .params(
                    PromptOptions.Params.ofOpenAIModelParams(
                        PromptOptions.Params.OpenAIModelParams.builder()
                            .frequencyPenalty(0.0)
                            .functionCall(
                                PromptOptions.Params.OpenAIModelParams.FunctionCall.ofAuto(
                                    PromptOptions.Params.OpenAIModelParams.FunctionCall.Auto.AUTO
                                )
                            )
                            .maxTokens(0.0)
                            .n(0.0)
                            .presencePenalty(0.0)
                            .responseFormat(
                                PromptOptions.Params.OpenAIModelParams.ResponseFormat.ofJsonObject(
                                    PromptOptions.Params.OpenAIModelParams.ResponseFormat.JsonObject
                                        .builder()
                                        .type(
                                            PromptOptions.Params.OpenAIModelParams.ResponseFormat
                                                .JsonObject
                                                .Type
                                                .JSON_OBJECT
                                        )
                                        .build()
                                )
                            )
                            .stop(listOf("string"))
                            .temperature(0.0)
                            .toolChoice(
                                PromptOptions.Params.OpenAIModelParams.ToolChoice.ofAuto(
                                    PromptOptions.Params.OpenAIModelParams.ToolChoice.Auto.AUTO
                                )
                            )
                            .topP(0.0)
                            .useCache(true)
                            .build()
                    )
                )
                .position("position")
                .build()
        assertThat(promptOptions).isNotNull
        assertThat(promptOptions.model()).isEqualTo("model")
        assertThat(promptOptions.params())
            .isEqualTo(
                PromptOptions.Params.ofOpenAIModelParams(
                    PromptOptions.Params.OpenAIModelParams.builder()
                        .frequencyPenalty(0.0)
                        .functionCall(
                            PromptOptions.Params.OpenAIModelParams.FunctionCall.ofAuto(
                                PromptOptions.Params.OpenAIModelParams.FunctionCall.Auto.AUTO
                            )
                        )
                        .maxTokens(0.0)
                        .n(0.0)
                        .presencePenalty(0.0)
                        .responseFormat(
                            PromptOptions.Params.OpenAIModelParams.ResponseFormat.ofJsonObject(
                                PromptOptions.Params.OpenAIModelParams.ResponseFormat.JsonObject
                                    .builder()
                                    .type(
                                        PromptOptions.Params.OpenAIModelParams.ResponseFormat
                                            .JsonObject
                                            .Type
                                            .JSON_OBJECT
                                    )
                                    .build()
                            )
                        )
                        .stop(listOf("string"))
                        .temperature(0.0)
                        .toolChoice(
                            PromptOptions.Params.OpenAIModelParams.ToolChoice.ofAuto(
                                PromptOptions.Params.OpenAIModelParams.ToolChoice.Auto.AUTO
                            )
                        )
                        .topP(0.0)
                        .useCache(true)
                        .build()
                )
            )
        assertThat(promptOptions.position()).isEqualTo("position")
    }
}
