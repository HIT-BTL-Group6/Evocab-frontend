package com.example.evocab.data.datasource.setting

import com.example.evocab.model.BaseReponseSetting

interface ISettingDataSource {
    interface Remote{
        suspend fun changeUsername(): BaseReponseSetting
    }
}