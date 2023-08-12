package com.example.evocab.data.repository.remembered

import com.example.evocab.base.DataResult
import com.example.evocab.model.BaseReponseMissed

interface IRememberedRepository {
    suspend fun getAllVocabLearned(idUser: String): DataResult<BaseReponseMissed>
}