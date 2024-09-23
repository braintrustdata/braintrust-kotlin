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
import com.braintrustdata.api.models.ViewDeleteParams
import com.braintrustdata.api.models.ViewDeleteParams.ViewDeleteBody

class ViewDeleteParamsTest {

    @Test
    fun createViewDeleteParams() {
      ViewDeleteParams.builder()
          .viewId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectType(ViewDeleteParams.ObjectType.ORGANIZATION)
          .build()
    }

    @Test
    fun getBody() {
      val params = ViewDeleteParams.builder()
          .viewId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectType(ViewDeleteParams.ObjectType.ORGANIZATION)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.objectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(body.objectType()).isEqualTo(ViewDeleteParams.ObjectType.ORGANIZATION)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = ViewDeleteParams.builder()
          .viewId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.objectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Test
    fun getPathParam() {
      val params = ViewDeleteParams.builder()
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
