package com.trackmyfamily.commons.authenticate

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Aspect
@Order(0)
class Authenticator {

    @Order(0)
    @Around("@annotation(com.trackmyfamily.commons.annotations.Authenticated)")
    fun proceed(call: ProceedingJoinPoint): Any {
        System.out.println("Hey I am here ....")
        throw RuntimeException("la la la")
        //return call.proceed()
    }

}
