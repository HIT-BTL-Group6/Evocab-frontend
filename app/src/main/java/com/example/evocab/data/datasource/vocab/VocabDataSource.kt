package com.example.evocab.data.datasource.vocab

import com.example.evocab.data.service.ApiService
import com.example.evocab.model.*

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

    override suspend fun chooseMissedOrRemember(
        idUser: String,
        wordRequest: WordRemember
    ): PutWord {
        return service.chooseMissedOrRemember(idUser, wordRequest)
    }

}