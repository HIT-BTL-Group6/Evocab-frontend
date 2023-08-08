package com.example.evocab.data.repository.login

import com.example.evocab.base.DataResult
import com.example.evocab.data.datasource.login.ILoginDataSource
import com.example.evocab.data.datasource.register.IRegisterDataSource
import com.example.evocab.data.repository.register.IRegisterRepository
import com.example.evocab.model.BaseResponseLogin
import com.example.evocab.model.BaseResponseRegister
import com.example.evocab.model.UserRequestLogin
import com.example.evocab.model.UserRequestRegister
import com.example.sourcebase.base.BaseReponsitory

class LoginRepository(private val remote: ILoginDataSource.Remote): BaseReponsitory()
    , ILoginRepository {
    override suspend fun loginByPass(userLogin: UserRequestLogin): DataResult<BaseResponseLogin> {
        return getResult { remote.loginByPass(userLogin) }
    }
}