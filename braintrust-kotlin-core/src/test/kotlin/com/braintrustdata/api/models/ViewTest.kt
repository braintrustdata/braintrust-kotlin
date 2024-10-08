// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonNull
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ViewTest {

    @Test
    fun createView() {
        val view =
            View.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .name("name")
                .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .objectType(View.ObjectType.ORGANIZATION)
                .viewType(View.ViewType.PROJECTS)
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .deletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .options(
                    ViewOptions.builder()
                        .columnOrder(listOf("string"))
                        .columnSizing(ViewOptions.ColumnSizing.builder().build())
                        .columnVisibility(ViewOptions.ColumnVisibility.builder().build())
                        .build()
                )
                .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .viewData(
                    ViewData.builder()
                        .search(
                            ViewDataSearch.builder()
                                .filter(listOf(JsonNull.of()))
                                .match(listOf(JsonNull.of()))
                                .sort(listOf(JsonNull.of()))
                                .tag(listOf(JsonNull.of()))
                                .build()
                        )
                        .build()
                )
                .build()
        assertThat(view).isNotNull
        assertThat(view.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(view.name()).isEqualTo("name")
        assertThat(view.objectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(view.objectType()).isEqualTo(View.ObjectType.ORGANIZATION)
        assertThat(view.viewType()).isEqualTo(View.ViewType.PROJECTS)
        assertThat(view.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(view.deletedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(view.options())
            .isEqualTo(
                ViewOptions.builder()
                    .columnOrder(listOf("string"))
                    .columnSizing(ViewOptions.ColumnSizing.builder().build())
                    .columnVisibility(ViewOptions.ColumnVisibility.builder().build())
                    .build()
            )
        assertThat(view.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(view.viewData())
            .isEqualTo(
                ViewData.builder()
                    .search(
                        ViewDataSearch.builder()
                            .filter(listOf(JsonNull.of()))
                            .match(listOf(JsonNull.of()))
                            .sort(listOf(JsonNull.of()))
                            .tag(listOf(JsonNull.of()))
                            .build()
                    )
                    .build()
            )
    }
}
