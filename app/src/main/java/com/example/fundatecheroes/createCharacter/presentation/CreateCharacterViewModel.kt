package com.example.fundatecheroes.createCharacter.presentation

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

    fun createCharacter(name: String, type: String, company: String) {
        viewModelScope.launch {
            _state.value = CreateCharacterViewState.Loading

            val isSuccess = repository.createCharacter(name, type, company)

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
