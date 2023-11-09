package com.example.fundatecheroes.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityLoginBinding
import com.example.fundatecheroes.home.view.HomeActivity
import com.example.fundatecheroes.login.presentation.LoginViewModel
import com.example.fundatecheroes.login.presentation.model.LoginViewState
import com.example.fundatecheroes.profile.view.ProfileActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        configButtonLogin()
        configNewHereButton()

        viewModel.state.observe(this) {
            when (it) {
                is LoginViewState.Success -> TODO()
                is LoginViewState.Error -> TODO()
                LoginViewState.Loading -> TODO()
                LoginViewState.ShowEmailError ->
                    showEmailError()
                LoginViewState.ShowPasswordError ->
                    showPasswordError()
                LoginViewState.ShowEmailPasswordError -> TODO()
                LoginViewState.ShowHomeScreen -> TODO()
            }
        }

    }
    private fun configButtonLogin() {
        binding.loginButton.setOnClickListener {
            viewModel.validacaoPreenchimento(
                binding.emailEdit.text.toString(),
                binding.passwordEdit.text.toString()
            )
          startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
        }
    }

    private fun configNewHereButton() {
        binding.newHereTextView.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
        }
    }
    private fun showEmailError() {
        binding.emailEdit.error = getString(R.string.email_error)    }

    private fun showPasswordError() {
        binding.passwordEdit.error = getString(R.string.password_error)
    }
}