package com.braintrust.api.errors

class BraintrustIoException constructor(message: String? = null, cause: Throwable? = null) :
    BraintrustException(message, cause)
