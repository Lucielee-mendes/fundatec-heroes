package com.example.fundatecheroes.login.data.remote

import com.example.fundatecheroes.login.data.local.UserEntity
import java.util.Date

data class LoginResponse(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
)

fun LoginResponse.toUserEntity(): UserEntity? {
    return UserEntity(
        id = id,
        name = name,
        email = email,
        password = password,
        date = Date()
    )
}