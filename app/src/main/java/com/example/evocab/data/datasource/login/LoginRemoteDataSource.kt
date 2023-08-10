package com.example.evocab.data.datasource.login

import com.example.evocab.data.service.ApiService
import com.example.evocab.model.BaseResponseLogin
import com.example.evocab.model.LoginEnity

class LoginRemoteDataSource(private val service: ApiService.AuthenticationService): ILoginDataSource.Remote{
    override suspend fun loginByPass(userLogin: LoginEnity): BaseResponseLogin {
        return service.login(userLogin)
    }
}