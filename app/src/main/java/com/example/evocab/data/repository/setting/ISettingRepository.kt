package com.example.evocab.data.repository.setting

import com.example.evocab.base.DataResult
import com.example.evocab.model.BaseReponseSetting

interface ISettingRepository {
    suspend fun changeUsername(): DataResult<BaseReponseSetting>
}