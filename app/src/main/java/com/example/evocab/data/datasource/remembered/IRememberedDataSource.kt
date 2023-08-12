package com.example.evocab.data.datasource.remembered

import com.example.evocab.model.BaseReponseMissed

interface IRememberedDataSource {
    interface Remote{
        suspend fun getAllVocabLearned(idUser: String): BaseReponseMissed
    }
}