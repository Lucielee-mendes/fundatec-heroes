package com.example.fundatecheroes.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fundatecheroes.R
import com.example.fundatecheroes.gone
import com.example.fundatecheroes.home.presentation.model.HomeViewState

class HomeActivity : AppCompatActivity() {
    private val button by lazy {
        findViewById<Button>(R.id.button)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        observerState(HomeViewState.HideButton)



    }
    private fun observerState(state: HomeViewState){
        when(state){
            is HomeViewState.Success -> {
                state.message
            }
            is HomeViewState.Error -> {
                state.errorMessage
            }
            HomeViewState.Loading -> {

            }
            HomeViewState.HideButton ->{
                button.gone()
            }
        }

    }
}

