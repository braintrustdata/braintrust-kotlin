// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.BeforeEach
import com.braintrustdata.api.TestServerExtension
import com.braintrustdata.api.client.BraintrustClient
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClient
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonString
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.http.BinaryResponseContent
import com.braintrustdata.api.services.blocking.UserService
import com.braintrustdata.api.models.UserListPage
import com.braintrustdata.api.models.UserListParams
import com.braintrustdata.api.models.*

@ExtendWith(TestServerExtension::class)
class UserServiceTest {

    @Test
    fun callRetrieve() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val userService = client.user()
      val user = userService.retrieve(UserRetrieveParams.builder()
          .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(user)
      user.validate()
    }

    @Test
    fun callList() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val userService = client.user()
      val response = userService.list(UserListParams.builder().build())
      println(response)
      response.objects().forEach {
          it.validate()
      }
    }
}
