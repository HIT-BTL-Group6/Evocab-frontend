package com.example.evocab.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.register.IRegisterRepository
import com.example.evocab.data.repository.topic.ITopicRepository
import com.example.evocab.model.DataRegister
import com.example.evocab.model.DataTopicAPI
import com.example.evocab.model.RegisterEnity

private const val TAG = "SignUpViewModel"
class SignupViewModel(private val registerRepo: IRegisterRepository) : BaseViewModel(){

    private val _registerResults = MutableLiveData<DataRegister>()  //có thể thay đổi dữ liệu
    val registerResults: LiveData<DataRegister> get() = _registerResults  //không thể thay đổi dữ liệu

    fun registerByEmail(user: RegisterEnity) {
        executeTask(
            request = {
                registerRepo.registerByEmail(user)
            },
            onSuccess = { _response ->
                _response.data?.let { _data ->
                    _registerResults.value = _data
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