package com.example.fundatecheroes.createCharacter.data.repository

import android.util.Log
import com.example.fundatecheroes.createCharacter.data.CreateCharacterRequest
import com.example.fundatecheroes.createCharacter.data.local.CharacterDao
import com.example.fundatecheroes.createCharacter.data.remote.CreateCharacterResponse
import com.example.fundatecheroes.login.data.repository.LoginRepository
import com.example.fundatecheroes.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class CreateCharacterRepository(
    private val characterService: CreateCharacterService,
    private val characterDao: CharacterDao
) {

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
        type: String,
        company: String,
        age: Int,
        birthday: LocalDateTime?
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.createCharacter(
                    idUser = loginRepository.getUserId(),
                    createCharacterRequest = CreateCharacterRequest(
                        name = name,
                        description = description,
                        image = image,
                        type = type,
                        company = company,
                        age = age,
                        birthday = null
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

    suspend fun listCharacter(): List<CreateCharacterResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.listCharacter(
                    idUser = loginRepository.getUserId()
                )
                response.body()?: listOf()
            } catch (ex: Exception) {
                Log.e("listCharacter", ex.message.toString())
                listOf();
            }
        }
    }

}