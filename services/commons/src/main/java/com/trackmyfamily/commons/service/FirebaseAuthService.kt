package com.trackmyfamily.commons.service

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.trackmyfamily.commons.authenticate.models.DecodedToken
import org.springframework.stereotype.Service
import java.io.FileInputStream

@Service
class FirebaseAuthService(keyPath: String): AuthService {

    init {
        val serviceAccount = FileInputStream(keyPath)
        val options = FirebaseOptions.Builder().setCredentials(
            GoogleCredentials.fromStream(serviceAccount)
        ).build()
        FirebaseApp.initializeApp(options)
    }

    override fun authenticateToken(token: String): DecodedToken {
        return DecodedToken.from(FirebaseAuth.getInstance().verifyIdToken(token))
    }
}