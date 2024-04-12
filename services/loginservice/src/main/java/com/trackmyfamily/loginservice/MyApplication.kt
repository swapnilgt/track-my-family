package com.trackmyfamily.loginservice

import com.trackmyfamily.commons.BaseApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class MyApplication: BaseApplication() {



}

fun main(args: Array<String>) {
    runApplication<MyApplication>(*args)
}