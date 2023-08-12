package com.example.evocab.data.repository.vocab

import com.example.evocab.base.DataResult
import com.example.evocab.model.*

interface IVocabRepository {
    suspend fun get1Vocab(idWord: String): DataResult<BaseReponseWord>
    suspend fun getAllVocabInTopic(idTopic: String): DataResult<ListWord>
    suspend fun insertWord(word: Word): DataResult<Long>
    suspend fun getAll(): DataResult<List<Word>>
    suspend fun insertAll(vararg word: Word) :DataResult<List<Long>>

    suspend fun updateNoteByID(id: String, note: String?) : DataResult<Int>

    suspend fun deleteByID(id: String):DataResult<Int>
    suspend fun postWord(idUser: String, wordRemember: WordRemember): DataResult<BaseReponseMissed>
}