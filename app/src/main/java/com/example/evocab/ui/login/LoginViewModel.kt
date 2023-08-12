package com.example.evocab.ui.login

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atom.android.lebo.utils.extensions.*
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.login.ILoginRepository
import com.example.evocab.data.repository.topic.ITopicRepository
import com.example.evocab.model.DataTopicAPI
import com.example.evocab.model.LoginEnity

private const val TAG ="LoginViewModel"
class LoginViewModel(private val loginRepository: ILoginRepository,
                     private val sharedPreferences: SharedPreferences,
                     private val topicRepository: ITopicRepository
): BaseViewModel() {

    val getPass: String get() = sharedPreferences.getPass().toString()
    val getUsername: String get() = sharedPreferences.getUSerName().toString()

    private val _TopicResults = MutableLiveData<List<DataTopicAPI>>()
    val TopicResults: LiveData<List<DataTopicAPI>> get() = _TopicResults

    private val _loginState = MutableLiveData<String>()
    val loginState: LiveData<String>
        get() = _loginState

    fun loginByPass(user: LoginEnity, checkSave: Boolean){
        Log.e(TAG, "loginByPass1: ${user} ", )
        executeTask(
            request = {
                loginRepository.loginByPass(user)
            },
            onSuccess = { _response ->
                _response.data?.let { _data ->
                    _loginState.value = _data.access.token
                    _messageError.value = _response.message

                    sharedPreferences.saveTokenLogin(_data.access.token)
                    if(checkSave){
                        sharedPreferences.saveLogin(user.password, user.username)
                    }
                }?: kotlin.run {
                    _messageError.value = _response.message
                    _loginState.value = ""
                }
            },
            onError = {
                onErrorProcess(it)
            }
        )
    }
    fun setIdTopic(){
        if(!sharedPreferences.getIdTopic().isNullOrEmpty())
            return
        executeTask(
            request = {
                topicRepository.getAllTopic()
            },
            onSuccess = { _response ->
                _response.data?.let { _data ->
                    _data.firstOrNull()?.let { sharedPreferences.saveIdTopic(it.idTopic, it.nameTopic.toString()) } // ""
                    _TopicResults.value = _data
                    _messageError.value =""
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