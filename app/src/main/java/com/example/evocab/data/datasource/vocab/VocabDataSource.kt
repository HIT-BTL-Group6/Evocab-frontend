package com.example.evocab.data.datasource.vocab

import com.example.evocab.data.service.ApiService
import com.example.evocab.model.BaseReponseMissed
import com.example.evocab.model.BaseReponseWord
import com.example.evocab.model.ListWord
import com.example.evocab.model.WordRemember

class VocabDataSource(private val service: ApiService.Topic): IVocabDataSource.Remote {
    override suspend fun getVocab(idWord: String): BaseReponseWord {
        return service.get1Vocab(idWord)
    }

    override suspend fun getAllVocabInTopic(idTopic: String): ListWord {
        return service.getAllVocabInTopic(idTopic)
    }

    override suspend fun postWord(idUser: String, wordRemember: WordRemember): BaseReponseMissed {
        return service.postWord(idUser, wordRemember)
    }
}