package com.example.fundatecheroes.home.view

import androidx.recyclerview.widget.RecyclerView
import com.example.fundatecheroes.databinding.CharacterListItemBinding
import com.example.fundatecheroes.home.domain.CharacterModel
import com.bumptech.glide.Glide
import com.example.fundatecheroes.gone

class CharacterViewHolder (
    private val binding: CharacterListItemBinding
): RecyclerView.ViewHolder(binding.root){
  fun bind(character:CharacterModel){
      Glide.with(binding.root.context)
          .load(character.image)
          .into(binding.ivCharacter)
      binding.tvName.text = character.name

      binding.tvName.setOnClickListener{
          binding.ivCharacter.gone()
      }
  }
}