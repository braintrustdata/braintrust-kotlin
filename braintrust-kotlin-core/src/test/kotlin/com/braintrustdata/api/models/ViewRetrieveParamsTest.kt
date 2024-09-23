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
import com.braintrustdata.api.models.ViewRetrieveParams

class ViewRetrieveParamsTest {

    @Test
    fun createViewRetrieveParams() {
      ViewRetrieveParams.builder()
          .viewId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectType(ViewRetrieveParams.ObjectType.ORGANIZATION)
          .build()
    }

    @Test
    fun getQueryParams() {
      val params = ViewRetrieveParams.builder()
          .viewId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectType(ViewRetrieveParams.ObjectType.ORGANIZATION)
          .build()
      val expected = mutableMapOf<String, List<String>>()
      expected.put("object_id", listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
      expected.put("object_type", listOf(ViewRetrieveParams.ObjectType.ORGANIZATION.toString()))
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
      val params = ViewRetrieveParams.builder()
          .viewId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      val expected = mutableMapOf<String, List<String>>()
      expected.put("object_id", listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
      val params = ViewRetrieveParams.builder()
          .viewId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(params).isNotNull
      // path param "viewId"
      assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
