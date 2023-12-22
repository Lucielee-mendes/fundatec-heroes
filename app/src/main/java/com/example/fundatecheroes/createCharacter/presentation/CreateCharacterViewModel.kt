package com.example.fundatecheroes.createCharacter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fundatecheroes.createCharacter.domain.CreateCharacterUseCase
import com.example.fundatecheroes.createCharacter.presentation.model.CharacterType
import com.example.fundatecheroes.createCharacter.presentation.model.CreateCharacterViewState
import com.example.fundatecheroes.createCharacter.presentation.model.UniverseType
import kotlinx.coroutines.launch

class CreateCharacterViewModel() : ViewModel() {


    private val useCase by lazy {
        CreateCharacterUseCase()
    }


    private val _state: MutableLiveData<CreateCharacterViewState> = MutableLiveData()
    val state: LiveData<CreateCharacterViewState> = _state

    fun createCharacter(
        name: String,
        description: String,
        image: String,
        type: Int,
        company: Int,
        age: String,
        birthday: String
    ) {
        if (name.isBlank()) {
            _state.value = CreateCharacterViewState.ShowNameError
            return
        } else if (description.isBlank()) {
            _state.value = CreateCharacterViewState.ShowDescriptionError
            return
        } else if (image.isBlank()) {
            _state.value = CreateCharacterViewState.ShowImageError
            return
        } else if (type == 0) {
            _state.value = CreateCharacterViewState.ShowUniverseTypeError
            return
        } else if (company == 0) {
            _state.value = CreateCharacterViewState.ShowCharacterTypeError
            return
        } else if (age.toInt() == 0) {
            _state.value = CreateCharacterViewState.ShowAgeError
            return
        }/* else if (birthday.isAfter(LocalDate.now())){
            _state.value = CreateCharacterViewState.ShowBirthDateError
            return
        }*/
        else {

            viewModelScope.launch {
                _state.value = CreateCharacterViewState.Loading

                val isSuccess = useCase.createCharacter(
                    name,
                    description,
                    image,
                    characterType = CharacterType.getValueOf(type),
                    universeType = UniverseType.getValueOf(company),
                    age = age.toInt(),
                    birthday = null
                )

                _state.value = if (isSuccess) {
                    CreateCharacterViewState.ShowHomeScreen
                } else {
                    CreateCharacterViewState.Error
                }

               }
            }
        }
    }

