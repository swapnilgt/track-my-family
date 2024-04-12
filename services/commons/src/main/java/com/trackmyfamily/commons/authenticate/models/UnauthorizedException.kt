package com.trackmyfamily.commons.authenticate.models

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class UnauthorizedException: RuntimeException {

    constructor(): super(("Unauthorized"))

    constructor(cause: Throwable) : super("Unauthorize: ${cause.localizedMessage}", cause)

    constructor(msg: String): super("Unauthorized: $msg")


}