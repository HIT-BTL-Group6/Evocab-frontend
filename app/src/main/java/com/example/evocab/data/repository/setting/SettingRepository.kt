package com.example.evocab.data.repository.setting

import com.example.evocab.base.DataResult
import com.example.evocab.data.datasource.setting.ISettingDataSource
import com.example.evocab.model.BaseReponseSetting
import com.example.sourcebase.base.BaseReponsitory

class SettingRepository(private val settingRepo: ISettingDataSource.Remote): BaseReponsitory(), ISettingRepository {
    override suspend fun changeUsername(): DataResult<BaseReponseSetting> {
        return getResult { settingRepo.changeUsername() }
    }
}