package com.example.fundatecheroes.login.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fundatecheroes.login.presentation.model.LoginViewState

class LoginViewModel:ViewModel() {

    private val viewState: MutableLiveData<LoginViewState> = MutableLiveData()
    val state: LiveData<LoginViewState> = viewState
    fun validateInputs(email: String?, password: String?){
        if(email.isNullOrBlank()){
            viewState.value = LoginViewState.ShowEmailError
        }
        if(password.isNullOrBlank()){
            viewState.value = LoginViewState.ShowPasswordError
        }
    }

}