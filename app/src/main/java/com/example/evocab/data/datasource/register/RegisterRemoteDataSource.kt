package com.example.evocab.data.datasource.register

import com.example.evocab.data.service.ApiService
import com.example.evocab.model.BaseResponseRegister
import com.example.evocab.model.RegisterEnity

class RegisterRemoteDataSource(private val service: ApiService.AuthenticationService): IRegisterDataSource.Remote {
    override suspend fun registerByEmail(register: RegisterEnity): BaseResponseRegister {
        return service.register(register)
    }
}