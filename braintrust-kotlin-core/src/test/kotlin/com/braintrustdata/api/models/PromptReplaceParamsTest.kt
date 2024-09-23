// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.apache.hc.core5.http.ContentType
import com.braintrustdata.api.core.ContentTypes
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonString
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.MultipartFormValue
import com.braintrustdata.api.models.*
import com.braintrustdata.api.models.PromptReplaceParams
import com.braintrustdata.api.models.PromptReplaceParams.PromptReplaceBody

class PromptReplaceParamsTest {

    @Test
    fun createPromptReplaceParams() {
      PromptReplaceParams.builder()
          .name("name")
          .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .slug("slug")
          .description("description")
          .functionType(PromptReplaceParams.FunctionType.TASK)
          .promptData(PromptData.builder()
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
              .build())
          .tags(listOf("string"))
          .build()
    }

    @Test
    fun getBody() {
      val params = PromptReplaceParams.builder()
          .name("name")
          .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .slug("slug")
          .description("description")
          .functionType(PromptReplaceParams.FunctionType.TASK)
          .promptData(PromptData.builder()
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
              .build())
          .tags(listOf("string"))
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.name()).isEqualTo("name")
      assertThat(body.projectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(body.slug()).isEqualTo("slug")
      assertThat(body.description()).isEqualTo("description")
      assertThat(body.functionType()).isEqualTo(PromptReplaceParams.FunctionType.TASK)
      assertThat(body.promptData()).isEqualTo(PromptData.builder()
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
          .build())
      assertThat(body.tags()).isEqualTo(listOf("string"))
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = PromptReplaceParams.builder()
          .name("name")
          .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .slug("slug")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.name()).isEqualTo("name")
      assertThat(body.projectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(body.slug()).isEqualTo("slug")
    }
}
