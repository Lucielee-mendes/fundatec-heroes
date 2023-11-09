package com.example.fundatecheroes.profile.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityProfileBinding
import com.example.fundatecheroes.profile.presentation.ProfileViewModel
import com.example.fundatecheroes.profile.presentation.model.ProfileViewState
import com.google.android.material.snackbar.Snackbar


class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroes)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state.observe(this) {
            when (it) {
                ProfileViewState.Success ->{
                    showSnackMessage("Sucesso ao criar o usuário")
                    finish()
                }
                ProfileViewState.Error ->
                    showSnackMessage("Ocorreu um erro ao criar o usuário")
                ProfileViewState.Loading -> TODO()
                ProfileViewState.ShowNameError ->
                    showNameError()
                ProfileViewState.ShowEmailError ->
                    showEmailError()
                ProfileViewState.ShowPasswordError ->
                    showPasswordError()
            }
        }

        configBtCreateUser()
    }

    private fun configBtCreateUser() {
        binding.buttonCreate.setOnClickListener {
            viewModel.validateInputs(
                name = binding.editTextName.text.toString(),
                email = binding.editTextEmail.text.toString(),
                password = binding.editTextPassword.text.toString(),
            )
        }
    }

    private fun showNameError() {
        binding.editTextName.error = getString(R.string.nome_error)
    }

    private fun showEmailError() {
        binding.editTextEmail.error = getString(R.string.email_error)
    }

    private fun showPasswordError() {
        binding.editTextPassword.error = getString(R.string.password_error)
    }

    private fun showSnackMessage(message: String) {
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }
}