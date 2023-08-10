package com.example.evocab.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.home.IHomeRepository
import com.example.evocab.model.BaseReponseUser
import com.example.evocab.model.DataRegister
import com.example.evocab.model.User

class HomeViewModel(private val homeRepository: IHomeRepository): BaseViewModel() {

    val _getResults = MutableLiveData<User>()  //có thể thay đổi dữ liệu
    val getResults: LiveData<User> get() = _getResults



    fun getInforUser(){
        executeTask(
            request = {
                homeRepository.getInforUser()
            },
            onSuccess = { _response ->
                _response.data?.let { _data ->
                    _getResults.value = _data
                    _messageError.value = _response.message
                }?: kotlin.run {
                    _messageError.value = _response.message
                }
            },
            onError = {
                onErrorProcess(it)
            },
            showLoading = true
        )
    }
}