package com.example.evocab.ui.topic

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.topic.ITopicRepository
import com.example.evocab.model.DataRegister
import com.example.evocab.model.DataTopicAPI

class TopicViewModel(private val topicRepo: ITopicRepository):BaseViewModel() {
    private val _TopicResults = MutableLiveData<List<DataTopicAPI>>()
    val TopicResults: LiveData<List<DataTopicAPI>> get() = _TopicResults

    fun getAllTopic(){
        executeTask(
            request = {
                topicRepo.getAllTopic()
            },
            onSuccess = { _response ->
                Log.e("TopicViewModel", "getAllTopic: data ${_response}", )
                _response.data?.let { _data ->
                    _TopicResults.value = _data
                    Log.e("TopicViewModel", "getAllTopic: data1 ${_response}", )
                    Log.e("TopicViewModel", "getAllTopic: data3 ${_data}", )
                    _messageError.value =""
                }?: kotlin.run {
                    _messageError.value = _response.message
                    Log.e("TopicViewModel", "getAllTopic: data2 ${_response}", )
                }
            },
            onError = {
                onErrorProcess(it)
            },
            showLoading = true
        )
    }

}