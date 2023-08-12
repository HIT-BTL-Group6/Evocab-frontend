package com.example.evocab.data.repository.topic

import com.example.evocab.base.DataResult
import com.example.evocab.data.datasource.Topic.ITopicDataSource
import com.example.evocab.model.BaseReponseTopic
import com.example.sourcebase.base.BaseReponsitory

class TopicRepository(private val remote: ITopicDataSource.Remote): BaseReponsitory(), ITopicRepository {
    override suspend fun getAllTopic(): DataResult<BaseReponseTopic> {
        return getResult { remote.getAllTopic() }
    }
}