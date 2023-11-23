package com.example.fundatecheroes.login.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fundatecheroes.login.domain.LoginUseCase
import com.example.fundatecheroes.login.domain.isValidEmail
import com.example.fundatecheroes.login.presentation.model.LoginViewState
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {

    private val useCase by lazy {
        LoginUseCase()
    }


    private val viewState: MutableLiveData<LoginViewState> = MutableLiveData()
    val state: LiveData<LoginViewState> = viewState
    fun validacaoPreenchimento(
        email:String,
        password:String
    ) {
        viewState.value = LoginViewState.Loading
        if (email.isNullOrBlank() || !email.isValidEmail()) {
            viewState.value = LoginViewState.ShowEmailError
            return
        }
        if (password.isNullOrBlank() || password.length < 2) {
            viewState.value = LoginViewState.ShowPasswordError
            return
        }

        fetchLogin(email = email, password = password)
    }

    private fun fetchLogin(email: String, password: String) {
        viewModelScope.launch {
            val isSuccessLogin = useCase.login(email = email, password = password)
            viewState.value = if (isSuccessLogin) {
                LoginViewState.ShowHomeScreen
            } else {
                LoginViewState.ShowErrorMessage
            }
        }

}
}