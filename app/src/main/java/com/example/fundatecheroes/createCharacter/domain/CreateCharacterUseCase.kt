package com.example.fundatecheroes.createCharacter.domain

import com.example.fundatecheroes.createCharacter.data.remote.CreateCharacterResponse
import com.example.fundatecheroes.createCharacter.data.repository.CreateCharacterRepository
import java.time.LocalDate


class CreateCharacterUseCase() {
    private val repository: CreateCharacterRepository by lazy {
        CreateCharacterRepository()
    }
    suspend fun createCharacter(
        name: String,
        description: String,
        image: String,
        characterType: String,
        universeType: String,
        age: Int,
        birthday: LocalDate?
    ): Boolean {
        return repository.createCharacter(
            name = name,
            description = description,
            image = image,
            characterType = characterType,
            universeType = universeType,
            age = age,
            birthday = birthday
        )
    }
    suspend fun listCharacter(): List<CreateCharacterResponse> {
        return repository.listCharacter();
    }

    suspend fun removeCharacter(characterId: Int):Boolean {
        return repository.removeCharacter(characterId);
    }
}
