package com.example.fundatecheroes.home.domain

import com.example.fundatecheroes.createCharacter.data.remote.CreateCharacterResponse

fun List<CreateCharacterResponse>.toModel(): List<CharacterModel> {
    return map {character ->
        CharacterModel(
            id = character.id,
            name = character.name,
            image = character.image
        )
    }
}