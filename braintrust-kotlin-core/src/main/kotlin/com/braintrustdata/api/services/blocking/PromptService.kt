// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.braintrustdata.api.services.blocking

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.Prompt
import com.braintrustdata.api.models.PromptCreateParams
import com.braintrustdata.api.models.PromptDeleteParams
import com.braintrustdata.api.models.PromptFeedbackParams
import com.braintrustdata.api.models.PromptListPage
import com.braintrustdata.api.models.PromptListParams
import com.braintrustdata.api.models.PromptReplaceParams
import com.braintrustdata.api.models.PromptRetrieveParams
import com.braintrustdata.api.models.PromptUpdateParams

interface PromptService {

    /**
     * Create a new prompt. If there is an existing prompt in the project with the same slug as the
     * one specified in the request, will return the existing prompt unmodified
     */
    fun create(
        params: PromptCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Prompt

    /** Get a prompt object by its id */
    fun retrieve(
        params: PromptRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Prompt

    /**
     * Partially update a prompt object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    fun update(
        params: PromptUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Prompt

    /**
     * List out all prompts. The prompts are sorted by creation date, with the most recently-created
     * prompts coming first
     */
    fun list(
        params: PromptListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PromptListPage

    /** Delete a prompt object by its id */
    fun delete(
        params: PromptDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Prompt

    /** Log feedback for a set of prompt events */
    fun feedback(
        params: PromptFeedbackParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )

    /**
     * NOTE: This operation is deprecated and will be removed in a future revision of the API.
     * Create or replace a new prompt. If there is an existing prompt in the project with the same
     * slug as the one specified in the request, will return the existing prompt unmodified, will
     * replace the existing prompt with the provided fields
     */
    fun replace(
        params: PromptReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Prompt
}