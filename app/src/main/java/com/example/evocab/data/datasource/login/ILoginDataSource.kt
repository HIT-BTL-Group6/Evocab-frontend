package com.example.evocab.data.datasource.login

import com.example.evocab.model.BaseResponseLogin
import com.example.evocab.model.UserRequestLogin

interface ILoginDataSource {
    interface Remote{
        suspend fun loginByPass(login: UserRequestLogin): BaseResponseLogin
    }
}