package com.example.fundatecheroes.createCharacter.data.repository

import com.example.fundatecheroes.createCharacter.data.CreateCharacterRequest
import com.example.fundatecheroes.createCharacter.data.remote.CreateCharacterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateCharacterService {
    @POST("/api/createCharacter")
    suspend fun createCharacter(
        @Body createCharacterRequest: CreateCharacterRequest
    ): Response<CreateCharacterResponse>
}