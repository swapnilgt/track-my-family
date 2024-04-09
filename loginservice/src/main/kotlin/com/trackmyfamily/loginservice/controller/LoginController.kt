package com.trackmyfamily.loginservice.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping

@Controller
class LoginController {


    @PostMapping(
        path= arrayOf("/onboarduser"),
        consumes = arrayOf("application/json"),
        produces = arrayOf("application/json")
    )
    fun onboardUser() {

    }

    

}