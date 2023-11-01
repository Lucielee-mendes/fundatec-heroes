package com.example.fundatecheroes.createCharacter.view

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityCreateCharacterBinding

class CreateCharacterActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityCreateCharacterBinding
    val characterTypes = arrayOf("Heroi", "Vilão")
    val companies = arrayOf("Marvel", "DC")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
    }
}