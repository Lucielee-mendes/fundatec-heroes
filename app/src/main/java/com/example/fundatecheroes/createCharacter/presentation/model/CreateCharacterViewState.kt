package com.example.fundatecheroes.createCharacter.presentation.model

sealed class CreateCharacterViewState {
    object Success : CreateCharacterViewState()
    object ShowHomeScreen : CreateCharacterViewState()
    object Error : CreateCharacterViewState()
    object Loading : CreateCharacterViewState()

}