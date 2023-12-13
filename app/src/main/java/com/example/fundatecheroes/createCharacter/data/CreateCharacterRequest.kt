package com.example.fundatecheroes.createCharacter.data

import java.time.LocalDate

data class CreateCharacterRequest(
    val name: String,
    val description: String,
    val image: String,
    val type: String,
    val company: String,
    val age: Int,
    val  birthday: LocalDate?

)