// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.TestServerExtension
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClientAsync
import com.braintrustdata.api.models.GroupCreateParams
import com.braintrustdata.api.models.GroupReplaceParams
import com.braintrustdata.api.models.GroupUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GroupServiceAsyncTest {

    @Test
    suspend fun create() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val groupServiceAsync = client.groups()

        val group =
            groupServiceAsync.create(
                GroupCreateParams.builder()
                    .name("x")
                    .description("description")
                    .addMemberGroup("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addMemberUser("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orgName("org_name")
                    .build()
            )

        group.validate()
    }

    @Test
    suspend fun retrieve() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val groupServiceAsync = client.groups()

        val group = groupServiceAsync.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        group.validate()
    }

    @Test
    suspend fun update() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val groupServiceAsync = client.groups()

        val group =
            groupServiceAsync.update(
                GroupUpdateParams.builder()
                    .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addAddMemberGroup("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addAddMemberUser("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .description("description")
                    .name("x")
                    .addRemoveMemberGroup("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addRemoveMemberUser("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        group.validate()
    }

    @Test
    suspend fun list() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val groupServiceAsync = client.groups()

        val page = groupServiceAsync.list()

        page.response().validate()
    }

    @Test
    suspend fun delete() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val groupServiceAsync = client.groups()

        val group = groupServiceAsync.delete("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        group.validate()
    }

    @Test
    suspend fun replace() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val groupServiceAsync = client.groups()

        val group =
            groupServiceAsync.replace(
                GroupReplaceParams.builder()
                    .name("x")
                    .description("description")
                    .addMemberGroup("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addMemberUser("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orgName("org_name")
                    .build()
            )

        group.validate()
    }
}
