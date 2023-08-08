package com.example.evocab.data.datasource.forgotpassword

import com.example.evocab.model.BaseReponseForgotPass
import com.example.evocab.model.UserRequestForgotPass

interface IForgotPassDataSource {
    interface Remote{
        suspend fun sendCodeToEmail(email: UserRequestForgotPass): BaseReponseForgotPass

    }
}