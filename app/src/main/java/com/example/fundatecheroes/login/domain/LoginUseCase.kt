package com.example.fundatecheroes.login.domain

import com.example.fundatecheroes.login.data.repository.LoginRepository

class LoginUseCase {
    private val repository by lazy {
        LoginRepository()
    }

    suspend fun createUser(
        name: String,
        email: String,
        password: String,
    ): Boolean {
        return repository.createUser(
            name = name,
            email = email,
            password = password,
        )
    }
}