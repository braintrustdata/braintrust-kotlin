// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SpanAttributesTest {

    @Test
    fun createSpanAttributes() {
        val spanAttributes =
            SpanAttributes.builder().name("name").type(SpanAttributes.Type.LLM).build()
        assertThat(spanAttributes).isNotNull
        assertThat(spanAttributes.name()).isEqualTo("name")
        assertThat(spanAttributes.type()).isEqualTo(SpanAttributes.Type.LLM)
    }
}
