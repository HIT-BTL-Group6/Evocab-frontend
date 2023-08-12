package com.example.evocab.data.repository.remembered

import com.example.evocab.base.DataResult
import com.example.evocab.data.datasource.remembered.IRememberedDataSource
import com.example.evocab.model.BaseReponseMissed
import com.example.sourcebase.base.BaseReponsitory

class RememberedRepository (private val remote: IRememberedDataSource.Remote): BaseReponsitory(),
    IRememberedRepository {
    override suspend fun getAllVocabLearned(idUser: String): DataResult<BaseReponseMissed> {
        return getResult { remote.getAllVocabLearned(idUser) }
    }
}