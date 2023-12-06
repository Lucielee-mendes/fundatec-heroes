package com.example.fundatecheroes.home.presentation.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fundatecheroes.createCharacter.data.repository.CreateCharacterRepository
import com.example.fundatecheroes.home.domain.CharacterModel
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: CreateCharacterRepository) : ViewModel() {

    private val _characterList = MutableLiveData<List<CharacterModel>>()
    val characterList: LiveData<List<CharacterModel>> = _characterList

    private var lastCacheTime: Long = 0

    // Buscar personagens na API
    fun fetchCharacters() {
        viewModelScope.launch {
            try {
               // val characters = repository.getCharacters()
                //_characterList.value = characters
                lastCacheTime = System.currentTimeMillis()
            } catch (e: Exception) {
                // Lidar com o erro, se necessário
            }
        }
    }

    // Remover personagem na API
    fun deleteCharacter(characterId: String) {
        viewModelScope.launch {
            try {
                //repository.deleteCharacter(characterId)
            } catch (e: Exception) {
                // Lidar com o erro, se necessário
            }
        }
    }
}
