package com.example.fundatecheroes.createCharacter.domain

import com.example.fundatecheroes.createCharacter.data.CreateCharacterRequest
import com.example.fundatecheroes.createCharacter.data.repository.CreateCharacterRepository


class CreateCharacterUseCase(
    private val repository: CreateCharacterRepository
) {
    suspend fun createCharacter(
        name: String,
        type: String,
        company: String
    ): Boolean {
        return repository.createCharacter(
            name,
            type,
            company
        )
    }
}
