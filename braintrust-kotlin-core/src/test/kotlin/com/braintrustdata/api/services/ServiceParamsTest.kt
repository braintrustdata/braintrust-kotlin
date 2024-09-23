// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.put
import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.deleteRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import java.io.IOException
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import com.braintrustdata.api.client.BraintrustClient
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClient
import com.braintrustdata.api.core.jsonMapper
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonString
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.errors.BraintrustError
import com.braintrustdata.api.errors.BraintrustInvalidDataException
import com.braintrustdata.api.errors.BraintrustServiceException
import com.braintrustdata.api.errors.UnexpectedStatusCodeException
import com.braintrustdata.api.models.ProjectListPage
import com.braintrustdata.api.models.ProjectListParams
import com.braintrustdata.api.models.*

@WireMockTest
class ServiceParamsTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private lateinit var client: BraintrustClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
      client = BraintrustOkHttpClient.builder()
          .apiKey("My API Key")
          .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
          .build()
    }

    @Test
    fun projectsCreateWithAdditionalParams() {
      val additionalHeaders = mutableMapOf<String, List<String>>()

      additionalHeaders.put("x-test-header", listOf("abc1234"))

      val additionalQueryParams = mutableMapOf<String, List<String>>()

      additionalQueryParams.put("test_query_param", listOf("def567"))

      val additionalBodyProperties = mutableMapOf<String, JsonValue>()

      additionalBodyProperties.put("testBodyProperty", JsonString.of("ghi890"))

      val params = ProjectCreateParams.builder()
          .name("name")
          .orgName("org_name")
          .additionalHeaders(additionalHeaders)
          .additionalBodyProperties(additionalBodyProperties)
          .additionalQueryParams(additionalQueryParams)
          .build()

      val apiResponse = Project.builder()
          .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .name("name")
          .orgId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .deletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .settings(Project.Settings.builder()
              .comparisonKey("comparison_key")
              .build())
          .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()

      stubFor(post(anyUrl())
          .withHeader("x-test-header", equalTo("abc1234"))
          .withQueryParam("test_query_param", equalTo("def567"))
          .withRequestBody(matchingJsonPath("$.testBodyProperty", equalTo("ghi890")))
          .willReturn(ok(JSON_MAPPER.writeValueAsString(apiResponse))))

      client.project().create(params)

      verify(postRequestedFor(anyUrl()))
    }
}
