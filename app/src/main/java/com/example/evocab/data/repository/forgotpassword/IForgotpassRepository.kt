package com.example.evocab.data.repository.forgotpassword

import com.example.evocab.base.DataResult
import com.example.evocab.model.BaseReponseForgotPass
import com.example.evocab.model.ForgotPassEnity

interface IForgotpassRepository {
    suspend fun sendCodeToEmail(email: ForgotPassEnity): DataResult<BaseReponseForgotPass>
}