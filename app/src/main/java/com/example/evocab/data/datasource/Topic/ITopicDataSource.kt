package com.example.evocab.data.datasource.Topic

import com.example.evocab.model.BaseReponseTopic

interface ITopicDataSource {
    interface Remote{
        suspend fun getAllTopic(): BaseReponseTopic
    }
}