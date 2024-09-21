package com.braintrustdata.api.errors

class BraintrustInvalidDataException(message: String? = null, cause: Throwable? = null) :
    BraintrustException(message, cause)
