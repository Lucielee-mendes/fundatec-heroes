package com.example.fundatecheroes.home.domain

import java.io.Serializable

data class CharacterModel (
    val id: Int,
    val name: String,
    val image: String,
    val description:String,
    val birthday: String,
    val age: Int,
) : Serializable
