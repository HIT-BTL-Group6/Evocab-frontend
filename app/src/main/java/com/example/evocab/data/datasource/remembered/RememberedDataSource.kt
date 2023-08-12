package com.example.evocab.data.datasource.remembered

import com.example.evocab.data.datasource.register.IRegisterDataSource
import com.example.evocab.data.service.ApiService
import com.example.evocab.model.BaseReponseMissed
import com.example.evocab.model.RegisterEnity

class RememberedDataSource (private val service: ApiService.Topic): IRememberedDataSource.Remote {
    override suspend fun getAllVocabLearned(idUser: String): BaseReponseMissed {
        return service.getAllVocabLearned(idUser)
    }
}