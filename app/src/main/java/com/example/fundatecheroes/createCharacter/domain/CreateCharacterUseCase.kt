package com.example.fundatecheroes.createCharacter.domain

import com.example.fundatecheroes.createCharacter.data.local.CharacterDao
import com.example.fundatecheroes.createCharacter.data.remote.CreateCharacterResponse
import com.example.fundatecheroes.createCharacter.data.repository.CreateCharacterRepository
import java.time.LocalDate


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
        birthday: LocalDate
    ): Boolean {
        return repository.createCharacter(
            name = name,
            description = description,
            image = image,
            type = type,
            company = company,
            age = age
        )
    }
    suspend fun listCharacter(): List<CreateCharacterResponse> {
        return repository.listCharacter();
    }

}
