package com.example.fundatecheroes.createCharacter.data.repository

import android.util.Log
import com.example.fundatecheroes.createCharacter.data.CreateCharacterRequest
import com.example.fundatecheroes.createCharacter.data.local.CharacterDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CreateCharacterRepository(
    private val characterService: CreateCharacterService,
    private val characterDao: CharacterDao
) {

    suspend fun createCharacter(
        name: String,
        type: String,
        company: String
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = characterService.createCharacter(
                    createCharacterRequest = CreateCharacterRequest(
                        name = name,
                        type = type,
                        company = company
                    )
                )
                if (response.isSuccessful) {
                    characterDao.clearCharacterCache()
                    true
                } else {
                    false
                }
            } catch (ex: Exception) {
                Log.e("CreateCharacter", ex.message.toString())
                false
            }
        }
    }
    suspend fun clearCharacterCache() {
        characterDao.clearCharacterCache()
    }

}