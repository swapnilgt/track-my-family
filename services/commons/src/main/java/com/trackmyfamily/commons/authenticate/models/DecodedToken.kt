package com.trackmyfamily.commons.authenticate.models

import com.google.firebase.auth.FirebaseToken

data class DecodedToken(
    val name: String,

    val email: String,

    val claims: Map<String, Any>
) {
    companion object {

        fun from(input: FirebaseToken): DecodedToken {
            return DecodedToken(
                input.name,
                input.email,
                input.claims
            )
        }

    }
}