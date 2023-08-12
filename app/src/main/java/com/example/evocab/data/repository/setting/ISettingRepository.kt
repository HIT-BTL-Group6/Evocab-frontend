package com.example.evocab.data.repository.setting

import com.example.evocab.base.DataResult
import com.example.evocab.model.BaseReponseSetting
import com.example.evocab.model.UserCanChange

interface ISettingRepository {
    suspend fun changeUsername(userCanChange: UserCanChange): DataResult<BaseReponseSetting>
}