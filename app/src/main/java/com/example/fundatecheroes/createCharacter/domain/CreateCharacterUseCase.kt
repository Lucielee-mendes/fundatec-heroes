package com.example.fundatecheroes.createCharacter.domain

import com.example.fundatecheroes.createCharacter.data.local.CharacterDao
import com.example.fundatecheroes.createCharacter.data.remote.CreateCharacterResponse
import com.example.fundatecheroes.createCharacter.data.repository.CreateCharacterRepository
import com.example.fundatecheroes.login.data.repository.LoginRepository
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

//    suspend fun getLastCacheTimestamp(): Long? {
//        // Chame o CharacterDao para obter o último timestamp
//        return characterDao.getLastCacheTimestamp()
//    }

    suspend fun removeCharacter(characterId: Int):Boolean {
        return repository.removeCharacter(characterId);
    }
}
