// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.TestServerExtension
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClientAsync
import com.braintrustdata.api.models.OrganizationUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrganizationServiceAsyncTest {

    @Test
    suspend fun retrieve() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val organizationServiceAsync = client.organizations()

        val organization = organizationServiceAsync.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        organization.validate()
    }

    @Test
    suspend fun update() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val organizationServiceAsync = client.organizations()

        val organization =
            organizationServiceAsync.update(
                OrganizationUpdateParams.builder()
                    .organizationId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .apiUrl("api_url")
                    .isUniversalApi(true)
                    .name("name")
                    .proxyUrl("proxy_url")
                    .realtimeUrl("realtime_url")
                    .build()
            )

        organization.validate()
    }

    @Test
    suspend fun list() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val organizationServiceAsync = client.organizations()

        val page = organizationServiceAsync.list()

        page.response().validate()
    }

    @Test
    suspend fun delete() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val organizationServiceAsync = client.organizations()

        val organization = organizationServiceAsync.delete("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        organization.validate()
    }
}
