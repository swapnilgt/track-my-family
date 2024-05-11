package com.trackmyfamily.commons

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class ApplicationContextProvider: ApplicationContextAware {

    companion object {
        private lateinit var CONTEXT: ApplicationContext

        fun getApplicationContext(): ApplicationContext {
            return CONTEXT
        }
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        CONTEXT = applicationContext
    }
}