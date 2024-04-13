package com.trackmyfamily.commons.service

interface AuthService {

    fun authenticateToken(token: String)
}