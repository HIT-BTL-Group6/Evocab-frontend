package com.example.evocab.ui.missed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.remembered.IRememberedRepository
import com.example.evocab.model.DataAPIMissed
import com.example.evocab.model.DataTopicAPI

class MissedViewModel(private val missedRepo: IRememberedRepository):BaseViewModel() {

    private val _MissedResults = MutableLiveData<List<DataAPIMissed>>()
    val MissedResults: LiveData<List<DataAPIMissed>> get() = _MissedResults

    fun getAllVocabLearned(idUser: String){
        executeTask(
            request = {
                missedRepo.getAllVocabLearned(idUser)
            },
            onSuccess = {_response ->
                Log.e("TopicViewModel", "getAllTopic: data ${_response}", )
                _response.data?.let { _data ->
                    _MissedResults.value = _data
                    Log.e("TopicViewModel", "getAllTopic: data1 ${_response}", )
                    Log.e("TopicViewModel", "getAllTopic: data3 ${_data}", )
                    _messageError.value =""
                }?: kotlin.run {
//                    _messageError.value = _response.
//                    Log.e("TopicViewModel", "getAllTopic: data2 ${_response}", )
                }
            },
            onError = {
                onErrorProcess(it)
            },
            showLoading = true
        )
    }
}