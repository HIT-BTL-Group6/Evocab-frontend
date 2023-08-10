package com.example.evocab.data.repository.login

import com.example.evocab.base.DataResult
import com.example.evocab.data.datasource.login.ILoginDataSource
import com.example.evocab.model.BaseResponseLogin
import com.example.evocab.model.LoginEnity
import com.example.sourcebase.base.BaseReponsitory

class LoginRepository(private val remote: ILoginDataSource.Remote): BaseReponsitory()
    , ILoginRepository {
    override suspend fun loginByPass(userLogin: LoginEnity): DataResult<BaseResponseLogin> {
        return getResult { remote.loginByPass(userLogin) }
    }
}