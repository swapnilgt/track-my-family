package com.trackmyfamily.loginservice.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "user_profile")
data class User(

    @Id
    private val id: UUID,

    private val first_name: String,

    private val last_name: String?,

    private val email: String
)