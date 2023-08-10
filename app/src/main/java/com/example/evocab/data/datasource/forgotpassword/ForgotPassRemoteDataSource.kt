package com.example.evocab.data.datasource.forgotpassword

import com.example.evocab.data.service.ApiService
import com.example.evocab.model.BaseReponseForgotPass
import com.example.evocab.model.ForgotPassEnity

class ForgotPassRemoteDataSource(private val service: ApiService.AuthenticationService): IForgotPassDataSource.Remote {
    override suspend fun sendCodeToEmail(email: ForgotPassEnity): BaseReponseForgotPass {
        return service.forgotpassword(email)
    }
}