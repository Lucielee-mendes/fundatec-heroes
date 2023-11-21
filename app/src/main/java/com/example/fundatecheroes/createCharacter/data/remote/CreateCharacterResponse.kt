package com.example.fundatecheroes.createCharacter.data.remote

import com.example.fundatecheroes.createCharacter.data.local.CharacterEntity
import java.util.Date

data class CreateCharacterResponse(
    val id: Int,
    val name: String,
    val type: String,
    val company: String,

)

fun CreateCharacterResponse.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        type = type,
        company = company,
        date = Date()
    )
}