package com.example.evocab.data.datasource.forgotpassword

import com.example.evocab.model.BaseReponseForgotPass
import com.example.evocab.model.ForgotPassEnity

interface IForgotPassDataSource {
    interface Remote{
        suspend fun sendCodeToEmail(email: ForgotPassEnity): BaseReponseForgotPass

    }
}