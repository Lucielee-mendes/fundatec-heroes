package com.example.fundatecheroes.createCharacter.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.Date

@Dao
interface CharacterDao {

    @Insert
    suspend fun insertCharacter(characterEntity: CharacterEntity)

    @Query("SELECT date FROM character_table")
    suspend fun getCharacterDate(): Date?

    @Query("DELETE FROM character_table")
    suspend fun clearCharacterCache()
}