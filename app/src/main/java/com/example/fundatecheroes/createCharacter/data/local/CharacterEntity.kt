package com.example.fundatecheroes.createCharacter.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "character_table")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val type: String,
    val company: String,
    val age: Int,
    val birthday: LocalDateTime?
)