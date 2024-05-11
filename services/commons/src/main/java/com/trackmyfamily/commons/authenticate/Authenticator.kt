package com.trackmyfamily.commons.authenticate

import com.trackmyfamily.commons.ApplicationContextProvider
import com.trackmyfamily.commons.CandidateAuthentication
import com.trackmyfamily.commons.authenticate.models.UnauthorizedException
import com.trackmyfamily.commons.service.FirebaseAuthService
import jakarta.servlet.http.HttpServletRequest
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.core.annotation.Order
import org.springframework.http.HttpHeaders
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
@Aspect
@Order(0)
class Authenticator constructor() {

    private val context: ApplicationContext = ApplicationContextProvider.getApplicationContext()

    // Solution for aspect working - https://stackoverflow.com/a/77438231/2606411

    @Order(0)
    @Around("@annotation(com.trackmyfamily.commons.annotations.Authenticated)")
    fun proceed(call: ProceedingJoinPoint): Any {
        authenticate()
        return call.proceed()
    }

    private fun authenticate() {
        val authentication = SecurityContextHolder.getContext().authentication as CandidateAuthentication
        val request = authentication.request
        if(canAuthenticate(request)) {
            // Authenticate using firebase admin SDK
            context.getBean(FirebaseAuthService::class.java)
            .authenticateToken(
                request.getHeader(HttpHeaders.AUTHORIZATION)
                    .replace("Bearer ", "")
            )
        } else {
            throw UnauthorizedException("BEARER_TOKEN_NOT_FOUND")
        }
    }

    private fun canAuthenticate(request: HttpServletRequest): Boolean {
        val authHeader = request.getHeader(HttpHeaders.AUTHORIZATION)
        return authHeader != null && authHeader.lowercase().startsWith("bearer ")
    }

}
