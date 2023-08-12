package com.example.evocab.data.datasource.vocab

import com.example.evocab.data.database.DataBaseLocal
import com.example.evocab.model.Word

class VocabLocalDataSource(private val dataBaseLocal: DataBaseLocal):IVocabDataSource.Local {
    override suspend fun insertWord(word: Word): Long {
        return dataBaseLocal.wordDao.insert(word)
    }

    override suspend fun getAll(): List<Word> {
        return dataBaseLocal.wordDao.getAll()
    }

    override suspend fun insertAll(vararg word: Word): List<Long> {
        return dataBaseLocal.wordDao.insertAll(*word) /// operator spead // *list(12,12,3)  =
    }

    override suspend fun updateNoteByID(id: String, note: String?):Int {
        return dataBaseLocal.wordDao.updateNoteByID(id, note)
    }

    override suspend fun deleteByID(id: String): Int {
        return dataBaseLocal.wordDao.deleteByID(id)
    }
}