package com.example.evocab.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atom.android.lebo.utils.extensions.saveIdUser
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.home.HomeRepository
import com.example.evocab.data.repository.home.IHomeRepository
import com.example.evocab.model.User
import com.example.evocab.ui.home.TAG

class ProfileViewModel(private val profileRepo: IHomeRepository):BaseViewModel() {

    val _getResults = MutableLiveData<User>()  //có thể thay đổi dữ liệu
    val getResults: LiveData<User> get() = _getResults



    fun getInforUser(){
        executeTask(
            request = {
                profileRepo.getInforUser()
            },
            onSuccess = { _response ->
                _response.data?.let { _data ->
                    _getResults.value = _data
                    Log.e(TAG, "getInforUser: user khi get ${_data}", )
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