package com.example.evocab.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.evocab.data.database.dao.WordDAO
import com.example.evocab.model.Vocabulary
import com.example.evocab.model.Word

@Database(
    entities = [Word::class],
    version = DataBaseLocal.VERSION
)
abstract class DataBaseLocal : RoomDatabase() {

    abstract val wordDao: WordDAO


    companion object {
        const val NAME = "Evocab"
        const val VERSION = 1
        const val TABLE_WORD = "word"
    }
}