package com.trackmyfamily.commons

import com.trackmyfamily.commons.service.FirebaseAuthService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean

abstract class BaseApplication {

    @Value("\${firebase.auth.key.path}")
    lateinit var keyPath: String

    @Bean
    open fun authFilter(): AuthenticationInterceptor {
        return AuthenticationInterceptor()
    }

    @Bean
    open fun firebaseAuthService(): FirebaseAuthService {
        val authService =  FirebaseAuthService(keyPath)
        assert(authService != null)
        return authService
    }

}