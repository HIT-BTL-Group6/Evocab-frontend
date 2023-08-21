package com.example.evocab.data.datasource.setting

import com.example.evocab.model.BaseReponseSetting
import com.example.evocab.model.UserCanChange

interface ISettingDataSource {
    interface Remote{
        suspend fun changeUsername(idUser: String, userCanChange: UserCanChange): BaseReponseSetting
    }
}