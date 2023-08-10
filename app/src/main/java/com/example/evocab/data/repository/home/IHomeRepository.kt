package com.example.evocab.data.repository.home

import com.example.evocab.base.DataResult
import com.example.evocab.model.BaseReponseUser

interface IHomeRepository {
    suspend fun getInforUser() : DataResult<BaseReponseUser>
}