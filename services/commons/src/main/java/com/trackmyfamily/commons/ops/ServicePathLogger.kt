package com.trackmyfamily.commons.ops

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping

@Component
class ServicePathLogger() {

    @Autowired
    private lateinit var handlerMapping: RequestMappingHandlerMapping

    @EventListener(ApplicationReadyEvent::class)
    fun logServicePaths() {
        val mappings = handlerMapping.handlerMethods.keys
        mappings.forEach { mapping ->
            val pattern = mapping.patternsCondition?.patterns?.first()
            println("Mapped  $pattern")
        }
    }

}