package com.example.fundatecheroes.createCharacter.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.Date

@Dao
interface CharacterDao {

    @Insert
    suspend fun insertCharacter(characterEntity: CharacterEntity)

    @Query("SELECT * FROM character_table")
    suspend fun getCharacters(): List<CharacterEntity>

    @Query("DELETE FROM character_table WHERE id = :characterId")
    suspend fun deleteCharacterById(characterId: String)

    @Query("DELETE FROM character_table")
    suspend fun clearCharacterCache()

    @Query("SELECT MAX(timestamp) FROM character_table")
    suspend fun getLastCacheTimestamp(): Long?
}
