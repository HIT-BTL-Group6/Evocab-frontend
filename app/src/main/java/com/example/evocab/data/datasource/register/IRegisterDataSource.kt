package com.example.evocab.data.datasource.register

import com.example.evocab.model.BaseResponseRegister
import com.example.evocab.model.RegisterEnity

interface IRegisterDataSource {
    interface Remote{
        suspend fun registerByEmail(register: RegisterEnity): BaseResponseRegister
    }
}