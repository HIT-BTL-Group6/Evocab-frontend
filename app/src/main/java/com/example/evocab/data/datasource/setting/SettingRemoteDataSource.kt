package com.example.evocab.data.datasource.setting

import com.example.evocab.data.service.ApiService
import com.example.evocab.model.BaseReponseSetting
import com.example.evocab.model.UserCanChange

class SettingRemoteDataSource(private val service: ApiService.User): ISettingDataSource.Remote {
    override suspend fun changeUsername(userCanChange: UserCanChange): BaseReponseSetting {
        return service.changUsername(userCanChange)
    }
}