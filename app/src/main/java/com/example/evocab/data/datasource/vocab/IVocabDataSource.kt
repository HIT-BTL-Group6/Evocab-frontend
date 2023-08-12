package com.example.evocab.data.datasource.vocab

import com.example.evocab.model.*
import com.example.evocab.utils.constant.ApiConstant
import retrofit2.http.Path

interface IVocabDataSource {
    interface Remote {
        suspend fun getVocab(idWord: String): BaseReponseWord
        suspend fun getAllVocabInTopic(idTopic: String): ListWord
        suspend fun postWord(idUser: String, wordRemember: WordRemember): BaseReponseMissed
    }

    interface Local {

        suspend fun insertWord(word: Word): Long
        suspend fun getAll(): List<Word>

        suspend fun insertAll(vararg word: Word):List<Long>

        suspend fun updateNoteByID(id: String, note: String?):Int

        suspend fun deleteByID(id: String):Int
    }
}