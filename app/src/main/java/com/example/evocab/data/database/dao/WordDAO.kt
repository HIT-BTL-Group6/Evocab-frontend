package com.example.evocab.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.evocab.data.database.DataBaseLocal
import com.example.evocab.model.Word

@Dao
interface WordDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(word: Word): Long

    @Query("SELECT * FROM ${DataBaseLocal.TABLE_WORD}")
     fun getAll(): List<Word>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(vararg word: Word):List<Long>  //(wword12, wwor123,....)


    @Query("UPDATE ${DataBaseLocal.TABLE_WORD} SET note =:note WHERE id =:id")
     fun updateNoteByID(id: String, note: String?):Int



    @Query("DELETE FROM ${DataBaseLocal.TABLE_WORD} WHERE id=:id")
     fun deleteByID(id: String):Int
}