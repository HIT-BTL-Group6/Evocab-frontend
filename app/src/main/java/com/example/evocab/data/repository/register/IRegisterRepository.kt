package com.example.evocab.data.repository.register

import com.example.evocab.base.DataResult
import com.example.evocab.model.BaseResponseRegister
import com.example.evocab.model.RegisterEnity

interface IRegisterRepository {
    suspend fun registerByEmail(user: RegisterEnity): DataResult<BaseResponseRegister>
}