package com.example.fundatecheroes.createCharacter.data.remote

import com.example.fundatecheroes.createCharacter.data.local.CharacterEntity
import java.time.LocalDateTime

data class CreateCharacterResponse(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val type: String,
    val company: String,
    val age: Int,
    val birthday: LocalDateTime?

)

fun CreateCharacterResponse.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        description = description,
        image = image,
        type = type,
        company = company,
        age = age,
        birthday = birthday
    )
}