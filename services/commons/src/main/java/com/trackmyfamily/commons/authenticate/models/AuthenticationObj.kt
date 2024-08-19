package com.trackmyfamily.commons.authenticate.models

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority

data class AuthenticationObj(
    private val email: String,
    private val name: String,
    private val decodedToken: DecodedToken

): Authentication {

    override fun getName(): String {
        return email
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf()
    }

    override fun getCredentials(): Any {
        return email
    }

    override fun getDetails(): Any {
        return decodedToken
    }

    override fun getPrincipal(): Any {
        return email
    }

    override fun isAuthenticated(): Boolean {
        return true
    }

    override fun setAuthenticated(isAuthenticated: Boolean) {
        throw IllegalAccessException("Not Allowed")
    }
}