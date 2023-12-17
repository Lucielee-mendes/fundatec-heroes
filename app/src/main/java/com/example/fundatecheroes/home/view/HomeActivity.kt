package com.example.fundatecheroes.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.fundatecheroes.R
import com.example.fundatecheroes.createCharacter.view.CharacterDetailsActivity
import com.example.fundatecheroes.createCharacter.view.CreateCharacterActivity
import com.example.fundatecheroes.databinding.ActivityHomeBinding
import com.example.fundatecheroes.home.domain.CharacterModel
import com.example.fundatecheroes.home.presentation.model.HomeViewModel
import com.example.fundatecheroes.home.presentation.model.HomeViewState
import com.example.fundatecheroes.showSnackBar

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private  val adapter:CharacterListAdapter by lazy {
        CharacterListAdapter(){
            Log.e("Home Activity", it.toString())
            telaCharacterDetails(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroes)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configNewHereCharacter()


        binding.rvList.adapter = adapter

        viewModel.state.observe(this){
            when(it) {
                is HomeViewState.Success ->
                    adapter.addList(
                        it.list
                    )
                is HomeViewState.CharacterRemove ->
                    showSnackBar(
                        binding.root,
                        R.string.sucessoRemover_personagem
                    )

                HomeViewState.Loading -> {

                }

                is HomeViewState.Error ->
                    it.errorMessage
            }
        }


        configSwipeToRemove()
    }
    private fun configSwipeToRemove() {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(v: RecyclerView, h: RecyclerView.ViewHolder, t: RecyclerView.ViewHolder) = false

            override fun onSwiped(h: RecyclerView.ViewHolder, dir: Int) {
                val character = adapter.recuperaPersonagem(h.adapterPosition)
                viewModel.deleteCharacter(character.id)
                adapter.removeItem(h.adapterPosition)
            }
        }).attachToRecyclerView(binding.rvList)
    }
    private fun configNewHereCharacter() {
        binding.adicionar.setOnClickListener {
            startActivity(Intent(this@HomeActivity, CreateCharacterActivity::class.java))
        }
    }

    private fun telaCharacterDetails(characterModel: CharacterModel){
        val intent = Intent(this@HomeActivity, CharacterDetailsActivity::class.java)
        intent.putExtra("character", characterModel)
        startActivity(intent)
    }

}