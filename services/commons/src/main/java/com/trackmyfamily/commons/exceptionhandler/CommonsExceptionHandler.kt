package com.trackmyfamily.commons.exceptionhandler

import com.trackmyfamily.commons.authenticate.models.UnauthorizedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CommonsExceptionHandler {

    @ExceptionHandler(UnauthorizedException::class)
    fun handleUnauthorizedException(ex: UnauthorizedException): ResponseEntity<CommonException> {
        return ResponseEntity(
            CommonException(
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.name,
                ex.localizedMessage
            ),
            HttpStatus.UNAUTHORIZED
        )
    }
}