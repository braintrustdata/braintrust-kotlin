// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ViewOptionsTest {

    @Test
    fun createViewOptions() {
        val viewOptions =
            ViewOptions.builder()
                .columnOrder(listOf("string"))
                .columnSizing(ViewOptions.ColumnSizing.builder().build())
                .columnVisibility(ViewOptions.ColumnVisibility.builder().build())
                .build()
        assertThat(viewOptions).isNotNull
        assertThat(viewOptions.columnOrder()).containsExactly("string")
        assertThat(viewOptions.columnSizing()).isEqualTo(ViewOptions.ColumnSizing.builder().build())
        assertThat(viewOptions.columnVisibility())
            .isEqualTo(ViewOptions.ColumnVisibility.builder().build())
    }
}
