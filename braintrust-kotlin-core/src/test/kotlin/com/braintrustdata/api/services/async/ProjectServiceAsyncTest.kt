// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.TestServerExtension
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClientAsync
import com.braintrustdata.api.models.ProjectCreateParams
import com.braintrustdata.api.models.ProjectDeleteParams
import com.braintrustdata.api.models.ProjectRetrieveParams
import com.braintrustdata.api.models.ProjectSettings
import com.braintrustdata.api.models.ProjectUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ProjectServiceAsyncTest {

    @Test
    suspend fun create() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val projectServiceAsync = client.projects()

        val project =
            projectServiceAsync.create(
                ProjectCreateParams.builder().name("x").orgName("org_name").build()
            )

        project.validate()
    }

    @Test
    suspend fun retrieve() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val projectServiceAsync = client.projects()

        val project =
            projectServiceAsync.retrieve(
                ProjectRetrieveParams.builder()
                    .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        project.validate()
    }

    @Test
    suspend fun update() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val projectServiceAsync = client.projects()

        val project =
            projectServiceAsync.update(
                ProjectUpdateParams.builder()
                    .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .name("name")
                    .settings(
                        ProjectSettings.builder()
                            .baselineExperimentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .comparisonKey("comparison_key")
                            .addSpanFieldOrder(
                                ProjectSettings.SpanFieldOrder.builder()
                                    .columnId("column_id")
                                    .objectType("object_type")
                                    .position("position")
                                    .layout(ProjectSettings.SpanFieldOrder.Layout.FULL)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        project.validate()
    }

    @Test
    suspend fun list() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val projectServiceAsync = client.projects()

        val page = projectServiceAsync.list()

        page.response().validate()
    }

    @Test
    suspend fun delete() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val projectServiceAsync = client.projects()

        val project =
            projectServiceAsync.delete(
                ProjectDeleteParams.builder()
                    .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        project.validate()
    }
}
