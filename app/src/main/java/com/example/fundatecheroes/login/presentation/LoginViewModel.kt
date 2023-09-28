package com.example.fundatecheroes.login.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {

    fun validateInputs(email:String?, password:String?){
        Log.e("teste", email.toString())
        Log.e("teste", password.toString())
    }

}