package com.example.fundatecheroes.login.domain

    fun String.isValidEmail():Boolean {
        return contains("@") && contains("com")
    }

