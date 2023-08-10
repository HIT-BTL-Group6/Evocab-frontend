package com.example.evocab.data.repository.login

import com.example.evocab.base.DataResult
import com.example.evocab.model.BaseResponseLogin
import com.example.evocab.model.LoginEnity

interface ILoginRepository {
    suspend fun loginByPass(userLogin: LoginEnity): DataResult<BaseResponseLogin>
}