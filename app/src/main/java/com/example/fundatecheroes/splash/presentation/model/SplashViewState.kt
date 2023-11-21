package com.example.fundatecheroes.splash.presentation.model

sealed class SplashViewState {
    object ShowLogin : SplashViewState()
    object ShowHome : SplashViewState()
}