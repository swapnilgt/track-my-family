package com.trackmyfamily.commons.service

import com.trackmyfamily.commons.authenticate.models.DecodedToken

interface AuthService {

    fun authenticateToken(token: String): DecodedToken
}