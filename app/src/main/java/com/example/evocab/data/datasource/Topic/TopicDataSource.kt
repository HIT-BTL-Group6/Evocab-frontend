package com.example.evocab.data.datasource.Topic

import com.example.evocab.data.service.ApiService
import com.example.evocab.model.BaseReponseTopic

class TopicDataSource(private val service: ApiService.Topic): ITopicDataSource.Remote {
    override suspend fun getAllTopic(): BaseReponseTopic {
        return service.getAllTopic()
    }
}