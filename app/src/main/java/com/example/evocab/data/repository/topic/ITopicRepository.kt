package com.example.evocab.data.repository.topic

import com.example.evocab.base.DataResult
import com.example.evocab.model.BaseReponseTopic

interface ITopicRepository {
    suspend fun getAllTopic(): DataResult<BaseReponseTopic>
}