package com.example.evocab.data.datasource.home

import com.example.evocab.data.service.ApiService
import com.example.evocab.model.BaseReponseUser

class HomeRemoteDataSource(private val service: ApiService): IHomeDataSource.Remote {
    override suspend fun getInforUser(): BaseReponseUser {
        return service.getUserInfor()
    }

}