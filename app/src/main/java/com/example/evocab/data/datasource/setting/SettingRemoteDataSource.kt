package com.example.evocab.data.datasource.setting

import com.example.evocab.data.service.ApiService
import com.example.evocab.model.BaseReponseSetting

class SettingRemoteDataSource(private val service: ApiService.User): ISettingDataSource.Remote {
    override suspend fun changeUsername(): BaseReponseSetting {
        return service.changUsername()
    }
}