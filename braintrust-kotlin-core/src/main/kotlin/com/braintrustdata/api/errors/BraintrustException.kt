package com.braintrustdata.api.errors

open class BraintrustException constructor(message: String? = null, cause: Throwable? = null) :
    RuntimeException(message, cause)
