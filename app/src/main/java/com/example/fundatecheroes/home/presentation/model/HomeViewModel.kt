package com.example.fundatecheroes.home.presentation.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fundatecheroes.createCharacter.domain.CreateCharacterUseCase
import com.example.fundatecheroes.home.domain.toModel
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {

    private val useCase by lazy {
        CreateCharacterUseCase()
    }

    private val viewState: MutableLiveData<HomeViewState> = MutableLiveData()
    val state: LiveData<HomeViewState> = viewState



    // Buscar personagens na API
    fun fetchCharacters() {
        viewModelScope.launch {
            val listCharacter = useCase.listCharacter()
            if (listCharacter.isNotEmpty()) {
                viewState.value = HomeViewState.Success(listCharacter.toModel())
            } else {
                viewState.value = HomeViewState.Error("Lista de personagens Vazia")
            }
        }
    }

    // Remover personagem na API
    fun deleteCharacter(characterId: Int) {
        viewModelScope.launch {
            val characterDelete = useCase.removeCharacter(characterId)
            if (characterDelete) {
                viewState.value = HomeViewState.CharacterRemover;
            } else {
                viewState.value = HomeViewState.Error("Não existe personagem com o id informado.")
            }
        }
    }

    init {
        fetchCharacters()
    }


}
