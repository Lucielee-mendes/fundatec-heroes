package com.example.fundatecheroes.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fundatecheroes.login.domain.LoginUseCase
import com.example.fundatecheroes.profile.presentation.model.ProfileViewState
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val viewState: MutableLiveData<ProfileViewState> = MutableLiveData()
    val state: LiveData<ProfileViewState> = viewState

    private val useCase by lazy {
        LoginUseCase()
    }

    fun validateInputs(name: String?, email: String?, password: String?) {
        if (name.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowNameError
        } else if (email.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowEmailError
        } else if (password.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowPasswordError
        } else {
            createrUser(name = name, email = email, password = password)
        }
    }

    private fun createrUser(
        name: String,
        email: String,
        password: String,
    ) {
        viewModelScope.launch {
            val isSuccess = useCase.createUser(
                name = name,
                email = email,
                password = password,
            )
            if (isSuccess) {
                viewState.value = ProfileViewState.Success
            } else {
                viewState.value = ProfileViewState.Error
            }
        }
    }
}