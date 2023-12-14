package com.example.fundatecheroes.createCharacter.presentation.model

sealed class CreateCharacterViewState {
    object Success : CreateCharacterViewState()
    object ShowHomeScreen : CreateCharacterViewState()
    object Error : CreateCharacterViewState()
    object Loading : CreateCharacterViewState()

    object ShowNameError: CreateCharacterViewState()
    object ShowDescriptionError: CreateCharacterViewState()
    object ShowImageError: CreateCharacterViewState()
    object ShowUniverseTypeError: CreateCharacterViewState()
    object ShowCharacterTypeError: CreateCharacterViewState()
    object ShowAgeError: CreateCharacterViewState()
    object ShowBirthDateError: CreateCharacterViewState()
    object CharactersLoaded : CreateCharacterViewState()




}