package com.example.fundatecheroes.createCharacter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityCharacterDetailsBinding
import com.example.fundatecheroes.home.domain.CharacterModel

class CharacterDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btVoltar.setOnClickListener {
            finish()
        }

        val character = intent.extras?.getSerializable("character") as? CharacterModel
        if (character == null){
            finish()
            return
        }
        Glide.with(binding.root.context)
            .load(character.image)
            .into(binding.ivCharacter)
        binding.tvName.text = character.name
        binding.tvDescricao.text = character.description
        binding.tvIdade.text = character.age.toString()
        binding.tvNascimento.text =  getString(R.string.data_nascimento, character.birthday)
    }
}