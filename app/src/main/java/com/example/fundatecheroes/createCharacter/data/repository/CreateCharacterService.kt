package com.example.fundatecheroes.createCharacter.data.repository

import com.example.fundatecheroes.createCharacter.data.CreateCharacterRequest
import com.example.fundatecheroes.createCharacter.data.remote.CreateCharacterResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CreateCharacterService {
    @POST("/api/character/{idUser}")
    suspend fun createCharacter(
        @Path("idUser") idUser: Int,
        @Body createCharacterRequest: CreateCharacterRequest
    ): Response<ResponseBody>

    @GET("/api/character/{idUser}")
    suspend fun listCharacter(
        @Path("idUser") idUser: Int,
    ): Response<List<CreateCharacterResponse>>

    @DELETE("/api/character/{idCharacter}")
    suspend fun removeCharacter(
        @Path("idCharacter") idCharacter: Int,
    ): Response<ResponseBody>
}