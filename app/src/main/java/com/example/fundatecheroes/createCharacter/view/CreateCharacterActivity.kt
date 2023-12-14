package com.example.fundatecheroes.createCharacter.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.fundatecheroes.R
import com.example.fundatecheroes.createCharacter.presentation.CreateCharacterViewModel
import com.example.fundatecheroes.createCharacter.presentation.model.CreateCharacterViewState
import com.example.fundatecheroes.databinding.ActivityCreateCharacterBinding

import com.example.fundatecheroes.home.view.HomeActivity

private const val DELAY_TELA = 3000L

class CreateCharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCharacterBinding
    private val viewModel: CreateCharacterViewModel by viewModels()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configButtonCriarPersonagem()
        itensSpinnerCharacterType()
        itensSpinnerCompany()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun configButtonCriarPersonagem() {
        binding.floatingButton.setOnClickListener {
            viewModel.createCharacter(
                binding.nameHero.text.toString(),
                binding.description.text.toString(),
                binding.imgHero.text.toString(),
                binding.spinnerCharacterType.selectedItem.toString(),
                binding.spinnerCompany.selectedItem.toString(),
                binding.editTextIdade.text.toString().toIntOrNull() ?: 0
            )
        }

        viewModel.state.observe(this){
            when (it) {
                is CreateCharacterViewState.ShowHomeScreen -> {
                    // Navegar de volta para a HomeActivity
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish() // Isso encerrará a CreateCharacterActivity após a navegação
                }
                CreateCharacterViewState.Error -> {
                    // Exibir mensagem de erro, se necessário
                    Toast.makeText(this, "Erro ao criar o personagem", Toast.LENGTH_SHORT).show()
                }
                // Adicionar mais casos conforme necessário
                else -> {}
            }
        }

    }

    private fun itensSpinnerCharacterType() {
        val spinner = findViewById<Spinner>(R.id.spinner_character_type)
        val arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.characterTypes)
        )
        spinner.adapter = arrayAdapter
    }

    private fun itensSpinnerCompany() {
        val spinner = findViewById<Spinner>(R.id.spinner_company)
        val arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.companies)
        )
        spinner.adapter = arrayAdapter
    }
}
