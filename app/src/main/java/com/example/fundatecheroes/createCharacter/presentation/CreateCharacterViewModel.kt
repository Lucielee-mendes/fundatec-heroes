package com.example.fundatecheroes.createCharacter.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fundatecheroes.createCharacter.data.repository.CreateCharacterRepository
import com.example.fundatecheroes.createCharacter.presentation.model.CreateCharacterViewState
import kotlinx.coroutines.launch

class CreateCharacterViewModel(private val repository: CreateCharacterRepository) : ViewModel() {


    private val _state: MutableLiveData<CreateCharacterViewState> = MutableLiveData()
    val state: LiveData<CreateCharacterViewState> = _state

    @RequiresApi(Build.VERSION_CODES.O)
    fun createCharacter(
        name: String,
        description: String,
        image: String,
        type: String,
        company: String,
        age: Int
    ) {
        if (name.isNullOrBlank()) {
            _state.value = CreateCharacterViewState.ShowNameError
            return
        } else if (description.isNullOrBlank()) {
            _state.value = CreateCharacterViewState.ShowDescriptionError
            return
        } else if (image.isNullOrBlank()) {
            _state.value = CreateCharacterViewState.ShowImageError
            return
        } else if (type.isNullOrBlank()) {
            _state.value = CreateCharacterViewState.ShowUniverseTypeError
            return
        } else if (company.isNullOrBlank()) {
            _state.value = CreateCharacterViewState.ShowCharacterTypeError
            return
        } else if (age <= 0) {
            _state.value = CreateCharacterViewState.ShowAgeError
            return
       /* } else if (birthday.isAfter(LocalDate.now())){
            _state.value = CreateCharacterViewState.ShowBirthDateError
            return*/
        }
        else {

            viewModelScope.launch {
                _state.value = CreateCharacterViewState.Loading

                val lastCacheTimestamp = repository.getLastCacheTimestamp()

                if (lastCacheTimestamp == null || System.currentTimeMillis() - lastCacheTimestamp > 10 * 60 * 1000) {
                    val isSuccess = repository.createCharacter(
                        name,
                        description,
                        image,
                        type,
                        company,
                        age
                    )

                    _state.value = if (isSuccess) {
                        CreateCharacterViewState.ShowHomeScreen
                    } else {
                        CreateCharacterViewState.Error
                    }

                } else {
                    // Carrega dados do cache
                    val charactersFromCache = repository.getCharactersFromCache()
                    _state.value = CreateCharacterViewState.CharactersLoaded
                }
            }
        }
    }
}
