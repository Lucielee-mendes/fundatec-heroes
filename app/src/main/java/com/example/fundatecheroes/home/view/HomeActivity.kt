package com.example.fundatecheroes.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityCreateCharacterBinding
import com.example.fundatecheroes.databinding.ActivityHomeBinding
import com.example.fundatecheroes.gone
import com.example.fundatecheroes.home.domain.CharacterModel
import com.example.fundatecheroes.home.presentation.model.HomeViewState

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private  val adapter:CharacterListAdapter by lazy {
        CharacterListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroes)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvList.adapter = adapter
        adapter.addList(
            listOf(
                CharacterModel(
                    name = "Hulk",
                    image = "https://t.ctcdn.com.br/5bU4_4Zvdqn2gkI3z-VYo_JhEHQ=/1245x700/smart/i632776.jpeg",
                ),
                CharacterModel(
                    name = "Batman",
                    image = "https://image.api.playstation.com/vulcan/img/rnd/202010/2621/H9v5o8vP6RKkQtR77LIGrGDE.png",
                )
            )
        )

    }
}

