package com.trackmyfamily.commons

import org.springframework.context.annotation.Bean

abstract class BaseApplication {

    @Bean
    open fun authFilter(): AuthenticationInterceptor {
        return AuthenticationInterceptor()
    }

}