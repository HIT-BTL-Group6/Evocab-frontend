package com.example.evocab.ui.home

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atom.android.lebo.utils.extensions.saveIdTopic
import com.atom.android.lebo.utils.extensions.saveIdUser
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.home.IHomeRepository
import com.example.evocab.model.User

class HomeViewModel(private val homeRepository: IHomeRepository,
                    private val sharedPreferences: SharedPreferences
): BaseViewModel() {

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
                    Log.e(TAG, "getInforUser: user khi get ${_data}", )
                    _messageError.value = _response.message
                    try {
                        sharedPreferences.saveIdUser(_data.id.toString())
                    }catch (e: Exception){

                    }

                    //sharedPreferences.saveIdTopic(_data.topicId.toString(), _data.n)
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