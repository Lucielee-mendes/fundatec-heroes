package com.example.fundatecheroes.home.view

import androidx.recyclerview.widget.RecyclerView
import com.example.fundatecheroes.databinding.CharacterListItemBinding
import com.example.fundatecheroes.home.domain.CharacterModel

class CharacterViewHolder (
    private val binding: CharacterListItemBinding
): RecyclerView.ViewHolder(binding.root){
  fun bind(chatacter:CharacterModel){
      binding.tvName.text = chatacter.name
  }
}