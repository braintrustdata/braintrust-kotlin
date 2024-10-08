// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking

import com.braintrustdata.api.TestServerExtension
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClient
import com.braintrustdata.api.models.*
import com.braintrustdata.api.models.ProjectScoreListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ProjectScoreServiceTest {

    @Test
    fun callCreate() {
        val client =
            BraintrustOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val projectScoreService = client.projectScores()
        val projectScore =
            projectScoreService.create(
                ProjectScoreCreateParams.builder()
                    .name("name")
                    .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .scoreType(ProjectScoreType.SLIDER)
                    .categories(
                        ProjectScoreCreateParams.Categories.ofProjectScoreCategories(
                            listOf(ProjectScoreCategory.builder().name("name").value(42.23).build())
                        )
                    )
                    .config(
                        ProjectScoreConfig.builder()
                            .destination(ProjectScoreConfig.Destination.EXPECTED)
                            .multiSelect(true)
                            .online(
                                OnlineScoreConfig.builder()
                                    .samplingRate(1.0)
                                    .scorers(
                                        listOf(
                                            OnlineScoreConfig.Scorer.ofFunction(
                                                OnlineScoreConfig.Scorer.Function.builder()
                                                    .id("id")
                                                    .type(
                                                        OnlineScoreConfig.Scorer.Function.Type
                                                            .FUNCTION
                                                    )
                                                    .build()
                                            )
                                        )
                                    )
                                    .applyToRootSpan(true)
                                    .applyToSpanNames(listOf("string"))
                                    .build()
                            )
                            .build()
                    )
                    .description("description")
                    .build()
            )
        println(projectScore)
        projectScore.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            BraintrustOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val projectScoreService = client.projectScores()
        val projectScore =
            projectScoreService.retrieve(
                ProjectScoreRetrieveParams.builder()
                    .projectScoreId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(projectScore)
        projectScore.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            BraintrustOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val projectScoreService = client.projectScores()
        val projectScore =
            projectScoreService.update(
                ProjectScoreUpdateParams.builder()
                    .projectScoreId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .categories(
                        ProjectScoreUpdateParams.Categories.ofProjectScoreCategories(
                            listOf(ProjectScoreCategory.builder().name("name").value(42.23).build())
                        )
                    )
                    .config(
                        ProjectScoreConfig.builder()
                            .destination(ProjectScoreConfig.Destination.EXPECTED)
                            .multiSelect(true)
                            .online(
                                OnlineScoreConfig.builder()
                                    .samplingRate(1.0)
                                    .scorers(
                                        listOf(
                                            OnlineScoreConfig.Scorer.ofFunction(
                                                OnlineScoreConfig.Scorer.Function.builder()
                                                    .id("id")
                                                    .type(
                                                        OnlineScoreConfig.Scorer.Function.Type
                                                            .FUNCTION
                                                    )
                                                    .build()
                                            )
                                        )
                                    )
                                    .applyToRootSpan(true)
                                    .applyToSpanNames(listOf("string"))
                                    .build()
                            )
                            .build()
                    )
                    .description("description")
                    .name("name")
                    .scoreType(ProjectScoreType.SLIDER)
                    .build()
            )
        println(projectScore)
        projectScore.validate()
    }

    @Test
    fun callList() {
        val client =
            BraintrustOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val projectScoreService = client.projectScores()
        val response = projectScoreService.list(ProjectScoreListParams.builder().build())
        println(response)
        response.objects().forEach { it.validate() }
    }

    @Test
    fun callDelete() {
        val client =
            BraintrustOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val projectScoreService = client.projectScores()
        val projectScore =
            projectScoreService.delete(
                ProjectScoreDeleteParams.builder()
                    .projectScoreId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(projectScore)
        projectScore.validate()
    }

    @Test
    fun callReplace() {
        val client =
            BraintrustOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val projectScoreService = client.projectScores()
        val projectScore =
            projectScoreService.replace(
                ProjectScoreReplaceParams.builder()
                    .name("name")
                    .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .scoreType(ProjectScoreType.SLIDER)
                    .categories(
                        ProjectScoreReplaceParams.Categories.ofProjectScoreCategories(
                            listOf(ProjectScoreCategory.builder().name("name").value(42.23).build())
                        )
                    )
                    .config(
                        ProjectScoreConfig.builder()
                            .destination(ProjectScoreConfig.Destination.EXPECTED)
                            .multiSelect(true)
                            .online(
                                OnlineScoreConfig.builder()
                                    .samplingRate(1.0)
                                    .scorers(
                                        listOf(
                                            OnlineScoreConfig.Scorer.ofFunction(
                                                OnlineScoreConfig.Scorer.Function.builder()
                                                    .id("id")
                                                    .type(
                                                        OnlineScoreConfig.Scorer.Function.Type
                                                            .FUNCTION
                                                    )
                                                    .build()
                                            )
                                        )
                                    )
                                    .applyToRootSpan(true)
                                    .applyToSpanNames(listOf("string"))
                                    .build()
                            )
                            .build()
                    )
                    .description("description")
                    .build()
            )
        println(projectScore)
        projectScore.validate()
    }
}
