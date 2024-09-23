// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonString
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.models.PromptData

class PromptDataTest {

    @Test
    fun createPromptData() {
      val promptData = PromptData.builder()
          .options(PromptData.Options.builder()
              .model("model")
              .params(PromptData.Options.Params.ofOpenAIModelParams(PromptData.Options.Params.OpenAIModelParams.builder()
                  .frequencyPenalty(42.23)
                  .functionCall(PromptData.Options.Params.OpenAIModelParams.FunctionCall.ofAuto(PromptData.Options.Params.OpenAIModelParams.FunctionCall.Auto.AUTO))
                  .maxTokens(42.23)
                  .n(42.23)
                  .presencePenalty(42.23)
                  .responseFormat(PromptData.Options.Params.OpenAIModelParams.ResponseFormat.builder()
                      .type(PromptData.Options.Params.OpenAIModelParams.ResponseFormat.Type.JSON_OBJECT)
                      .build())
                  .stop(listOf("string"))
                  .temperature(42.23)
                  .toolChoice(PromptData.Options.Params.OpenAIModelParams.ToolChoice.ofAuto(PromptData.Options.Params.OpenAIModelParams.ToolChoice.Auto.AUTO))
                  .topP(42.23)
                  .useCache(true)
                  .build()))
              .position("position")
              .build())
          .origin(PromptData.Origin.builder()
              .projectId("project_id")
              .promptId("prompt_id")
              .promptVersion("prompt_version")
              .build())
          .parser(PromptData.Parser.builder()
              .choiceScores(PromptData.Parser.ChoiceScores.builder().build())
              .type(PromptData.Parser.Type.LLM_CLASSIFIER)
              .useCot(true)
              .build())
          .prompt(PromptData.Prompt.ofCompletion(PromptData.Prompt.Completion.builder()
              .content("content")
              .type(PromptData.Prompt.Completion.Type.COMPLETION)
              .build()))
          .build()
      assertThat(promptData).isNotNull
      assertThat(promptData.options()).isEqualTo(PromptData.Options.builder()
          .model("model")
          .params(PromptData.Options.Params.ofOpenAIModelParams(PromptData.Options.Params.OpenAIModelParams.builder()
              .frequencyPenalty(42.23)
              .functionCall(PromptData.Options.Params.OpenAIModelParams.FunctionCall.ofAuto(PromptData.Options.Params.OpenAIModelParams.FunctionCall.Auto.AUTO))
              .maxTokens(42.23)
              .n(42.23)
              .presencePenalty(42.23)
              .responseFormat(PromptData.Options.Params.OpenAIModelParams.ResponseFormat.builder()
                  .type(PromptData.Options.Params.OpenAIModelParams.ResponseFormat.Type.JSON_OBJECT)
                  .build())
              .stop(listOf("string"))
              .temperature(42.23)
              .toolChoice(PromptData.Options.Params.OpenAIModelParams.ToolChoice.ofAuto(PromptData.Options.Params.OpenAIModelParams.ToolChoice.Auto.AUTO))
              .topP(42.23)
              .useCache(true)
              .build()))
          .position("position")
          .build())
      assertThat(promptData.origin()).isEqualTo(PromptData.Origin.builder()
          .projectId("project_id")
          .promptId("prompt_id")
          .promptVersion("prompt_version")
          .build())
      assertThat(promptData.parser()).isEqualTo(PromptData.Parser.builder()
          .choiceScores(PromptData.Parser.ChoiceScores.builder().build())
          .type(PromptData.Parser.Type.LLM_CLASSIFIER)
          .useCot(true)
          .build())
      assertThat(promptData.prompt()).isEqualTo(PromptData.Prompt.ofCompletion(PromptData.Prompt.Completion.builder()
          .content("content")
          .type(PromptData.Prompt.Completion.Type.COMPLETION)
          .build()))
    }
}
