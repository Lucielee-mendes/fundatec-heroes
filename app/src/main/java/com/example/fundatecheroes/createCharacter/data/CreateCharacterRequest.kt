package com.example.fundatecheroes.createCharacter.data

import com.squareup.moshi.JsonClass
import java.time.LocalDate
@JsonClass(generateAdapter = true)
data class CreateCharacterRequest(
    val name: String,
    val description: String,
    val image: String,
    val characterType: String,
    val universeType: String,
    val age: Int,
    val  birthday: String?

)