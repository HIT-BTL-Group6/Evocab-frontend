package com.example.evocab.data.repository.home

import com.example.evocab.base.DataResult
import com.example.evocab.data.datasource.home.IHomeDataSource
import com.example.evocab.model.BaseReponseUser
import com.example.sourcebase.base.BaseReponsitory

class HomeRepository(private val remote: IHomeDataSource.Remote):  BaseReponsitory(), IHomeRepository {
    override suspend fun getInforUser(): DataResult<BaseReponseUser> {
        return getResult { remote.getInforUser() }
    }
}