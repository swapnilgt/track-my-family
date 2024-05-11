package com.trackmyfamily.commons.authenticate.models

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class UnauthorizedException: RuntimeException {

    companion object {
        fun wrap(throwable: Throwable): UnauthorizedException {
            if(throwable.cause != null) {
                return UnauthorizedException(throwable.cause!!)
            }
            return UnauthorizedException(throwable.localizedMessage)

        }
    }

    constructor(): super(("Unauthorized"))

    constructor(cause: Throwable) : super("Unauthorized: ${cause.localizedMessage}", cause)

    constructor(msg: String): super("Unauthorized: $msg")


}