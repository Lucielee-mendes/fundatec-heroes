package com.example.fundatecheroes.createCharacter.data.repository

import android.util.Log
import com.example.fundatecheroes.createCharacter.data.CreateCharacterRequest
import com.example.fundatecheroes.createCharacter.data.local.CharacterDao
import com.example.fundatecheroes.createCharacter.data.remote.CreateCharacterResponse
import com.example.fundatecheroes.database.FHDatabase
import com.example.fundatecheroes.home.domain.CharacterModel
import com.example.fundatecheroes.login.data.local.UserDao
import com.example.fundatecheroes.login.data.repository.LoginRepository
import com.example.fundatecheroes.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDate

class CreateCharacterRepository {

    private val repository = RetrofitNetworkClient.createNetworkClient(
        baseUrl = "https://fundatec.herokuapp.com"
    ).create(CreateCharacterService::class.java)

    private val loginRepository: LoginRepository by lazy {
        LoginRepository()
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
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.createCharacter(
                    idUser = loginRepository.getUserId(),
                    createCharacterRequest = CreateCharacterRequest(
                        name = name,
                        description = description,
                        image = image,
                        characterType = characterType,
                        universeType = universeType,
                        age = age,
                        birthday = null
                    )
                )
                if (response.isSuccessful) {
//                    characterDao.clearCharacterCache()
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

    // revisar
    suspend fun clearCharacterCache() {
//        characterDao.clearCharacterCache()
    }

    suspend fun listCharacter(): List<CreateCharacterResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.listCharacter(
                    idUser = loginRepository.getUserId()
                )
                response.body() ?: listOf()
            } catch (ex: Exception) {
                Log.e("listCharacter", ex.message.toString())
                listOf();
            }
        }
    }

    suspend fun removeCharacter(characterId: Int): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.removeCharacter(
                    characterId
                )
                response.code() == 204
            } catch (ex: Exception) {
                Log.e("removeCharacter", ex.message.toString())
                false
            }
        }


    }
}