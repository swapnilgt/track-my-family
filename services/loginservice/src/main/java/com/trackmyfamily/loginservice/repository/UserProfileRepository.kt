package com.trackmyfamily.loginservice.repository

import com.trackmyfamily.loginservice.repository.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.UUID

@RepositoryRestResource
internal interface UserProfileRepository:  JpaRepository<User, UUID>