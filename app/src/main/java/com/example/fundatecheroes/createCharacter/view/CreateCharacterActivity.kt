package com.example.fundatecheroes.createCharacter.view

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.fundatecheroes.R
import com.example.fundatecheroes.createCharacter.presentation.CreateCharacterViewModel
import com.example.fundatecheroes.createCharacter.presentation.model.CreateCharacterViewState
import com.example.fundatecheroes.databinding.ActivityCreateCharacterBinding
import com.example.fundatecheroes.home.view.HomeActivity

class CreateCharacterActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityCreateCharacterBinding
    private lateinit var viewModel: CreateCharacterViewModel

    val characterTypes = arrayOf("Heroi", "Vilão")
    val companies = arrayOf("Marvel", "DC")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CreateCharacterViewModel::class.java)


        val characterTypeSpinner = findViewById<Spinner>(R.id.tipo_personagem)
        val characterTypeAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            characterTypes
        )
        characterTypeSpinner.adapter = characterTypeAdapter

        val companySpinner = findViewById<Spinner>(R.id.tipo_empresa)
        val companyAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            companies
        )
        companySpinner.adapter = companyAdapter

        binding.floatingButton.setOnClickListener {
            // Obter os valores dos campos
            val name = binding.nameHero.text.toString()
            val type = characterTypeSpinner.selectedItem.toString()
            val company = companySpinner.selectedItem.toString()

            // Chamar a função do ViewModel para criar o personagem
            viewModel.createCharacter(name, type, company)
        }

        // Observar o estado do ViewModel para navegar de volta à HomeActivity quando necessário
        viewModel.state.observe(this, { state ->
            when (state) {
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
        })
    }
}