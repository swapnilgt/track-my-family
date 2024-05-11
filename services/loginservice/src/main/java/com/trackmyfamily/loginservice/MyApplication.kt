package com.trackmyfamily.loginservice

import com.trackmyfamily.commons.BaseApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.trackmyfamily.commons")
@ComponentScan("com.trackmyfamily.loginservice")
open class MyApplication: BaseApplication() {

}

fun main(args: Array<String>) {
    runApplication<MyApplication>(*args)
}