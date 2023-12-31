package com.example.evocab.data.repository.register

import com.example.evocab.base.DataResult
import com.example.evocab.data.datasource.register.IRegisterDataSource
import com.example.evocab.model.BaseResponseRegister
import com.example.evocab.model.RegisterEnity
import com.example.sourcebase.base.BaseReponsitory

class RegisterRepository(private val remote: IRegisterDataSource.Remote): BaseReponsitory(), IRegisterRepository {
    override suspend fun registerByEmail(user: RegisterEnity): DataResult<BaseResponseRegister> {
        return getResult { remote.registerByEmail(user) }
    }
}