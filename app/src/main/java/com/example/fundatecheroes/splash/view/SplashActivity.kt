package com.example.fundatecheroes.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.fundatecheroes.R
import com.example.fundatecheroes.home.view.HomeActivity
import com.example.fundatecheroes.login.view.LoginActivity
import com.example.fundatecheroes.splash.presentation.SplashViewModel
import com.example.fundatecheroes.splash.presentation.model.SplashViewState

class SplashActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 3000
    private val viewModel: SplashViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel.state.observe(this) { state ->
            when (state) {
                SplashViewState.ShowLogin -> showLogin()
                SplashViewState.ShowHome -> showHome()
            }
        }
    }

    private fun showLogin() {

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimeOut)

    }

    private fun showHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }, splashTimeOut)
    }
}
