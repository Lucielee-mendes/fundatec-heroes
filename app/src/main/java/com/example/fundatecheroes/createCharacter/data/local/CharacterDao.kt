package com.example.fundatecheroes.createCharacter.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.Date

@Dao
interface CharacterDao {


    @Query("SELECT * FROM character_table")
    suspend fun getCharacters(): List<CharacterEntity>


    @Query("DELETE FROM character_table")
    suspend fun clearCharacterCache()

    @Query("SELECT MAX(timestamp) FROM character_table")
    suspend fun getLastCacheTimestamp(): Long?
}
