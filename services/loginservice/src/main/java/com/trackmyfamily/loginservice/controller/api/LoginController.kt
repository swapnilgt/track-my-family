package com.trackmyfamily.loginservice.controller.api

import com.trackmyfamily.commons.annotations.Authenticated
import com.trackmyfamily.loginservice.controller.response.OnboardUserResponseV1
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class LoginController {

    @PostMapping("/v1/onboard-user")
    @Authenticated
    fun onboardUserV1(): OnboardUserResponseV1 {
        return OnboardUserResponseV1("temp")
    }
    
}