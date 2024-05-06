package com.braintrust.api.errors

class BraintrustInvalidDataException
constructor(message: String? = null, cause: Throwable? = null) :
    BraintrustException(message, cause)
