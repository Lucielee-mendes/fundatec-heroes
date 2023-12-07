package com.example.fundatecheroes.createCharacter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fundatecheroes.createCharacter.data.repository.CreateCharacterRepository
import com.example.fundatecheroes.createCharacter.presentation.model.CreateCharacterViewState
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class CreateCharacterViewModel(private val repository: CreateCharacterRepository) : ViewModel() {

    private val _state: MutableLiveData<CreateCharacterViewState> = MutableLiveData()
    val state: LiveData<CreateCharacterViewState> = _state

    fun createCharacter(
        name: String,
        description: String,
        image: String,
        type: String,
        company: String,
        age: Int,
        birthday: LocalDateTime
    ) {
        viewModelScope.launch {
            _state.value = CreateCharacterViewState.Loading

            val isSuccess = repository.createCharacter(name, description, image, type, company, age, birthday)

            _state.value = if (isSuccess) {
                // Limpar a tabela de cache após o sucesso
                repository.clearCharacterCache()

                CreateCharacterViewState.ShowHomeScreen
            } else {
                CreateCharacterViewState.Error
            }
        }
    }
}
