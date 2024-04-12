package com.trackmyfamily.commons

import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.AbstractAuthenticationToken


class CandidateAuthentication(
    val request: HttpServletRequest
) : AbstractAuthenticationToken(mutableListOf())
{

    override fun getCredentials(): Any {
        return "null"
    }

    override fun getPrincipal(): Any {
        return "null"
    }


}
