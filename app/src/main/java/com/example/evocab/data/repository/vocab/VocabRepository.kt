package com.example.evocab.data.repository.vocab

import com.example.evocab.base.DataResult
import com.example.evocab.data.datasource.vocab.IVocabDataSource
import com.example.evocab.model.*
import com.example.sourcebase.base.BaseReponsitory

class VocabRepository(
    private val remote: IVocabDataSource.Remote,
    private val local: IVocabDataSource.Local
) : BaseReponsitory(), IVocabRepository {
    override suspend fun get1Vocab(idWord: String): DataResult<BaseReponseWord> {
        return getResult { remote.getVocab(idWord) }
    }

    override suspend fun getAllVocabInTopic(idTopic: String): DataResult<ListWord> {
        return getResult { remote.getAllVocabInTopic(idTopic) }
    }

    override suspend fun insertWord(word: Word): DataResult<Long> {
        return getResult { local.insertWord(word) }
    }

    override suspend fun getAll(): DataResult<List<Word>> {
        return getResult { local.getAll() }
    }

    override suspend fun insertAll(vararg word: Word):DataResult<List<Long>> {
      return  getResult { local.insertAll(*word) }
    }

    override suspend fun updateNoteByID(id: String, note: String?):DataResult<Int> {
        return getResult { local.updateNoteByID(id, note) }
    }

    override suspend fun deleteByID(id: String): DataResult<Int> {
        return getResult { local.deleteByID(id) }
    }

    override suspend fun postWord(idUser: String, wordRemember: WordRemember): DataResult<BaseReponseMissed> {
        return getResult { remote.postWord(idUser, wordRemember) }
    }
}