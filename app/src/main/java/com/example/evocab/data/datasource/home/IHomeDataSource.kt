package com.example.evocab.data.datasource.home

import com.example.evocab.model.BaseReponseUser

interface IHomeDataSource {
    interface Remote{
        suspend fun getInforUser(): BaseReponseUser
    }
}