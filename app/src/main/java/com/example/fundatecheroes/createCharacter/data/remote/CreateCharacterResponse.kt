package com.example.fundatecheroes.createCharacter.data.remote


import com.example.fundatecheroes.createCharacter.data.local.CharacterEntity
import com.squareup.moshi.JsonClass
import java.time.LocalDate

@JsonClass(generateAdapter = true)
data class CreateCharacterResponse(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val characterType: String,
    val universeType: String,
    val age: Int,
    val birthday: String?

)


