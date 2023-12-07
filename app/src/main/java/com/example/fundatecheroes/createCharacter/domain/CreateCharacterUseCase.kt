package com.example.fundatecheroes.createCharacter.domain

import com.example.fundatecheroes.createCharacter.data.CreateCharacterRequest
import com.example.fundatecheroes.createCharacter.data.local.CharacterDao
import com.example.fundatecheroes.createCharacter.data.repository.CreateCharacterRepository
import java.time.LocalDateTime


class CreateCharacterUseCase(
    private val repository: CreateCharacterRepository,
    private val characterDao: CharacterDao
) {
    suspend fun createCharacter(
        name: String,
        description: String,
        image: String,
        type: String,
        company: String,
        age: Int,
        birthday: LocalDateTime
    ): Boolean {
        return repository.createCharacter(
            name = name,
            description = description,
            image = image,
            type = type,
            company = company,
            age = age,
            birthday = birthday
        )
    }

}
