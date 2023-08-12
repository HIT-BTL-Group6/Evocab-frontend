package com.example.evocab.ui.forgotpass

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.forgotpassword.IForgotpassRepository
import com.example.evocab.model.ForgotPassEnity

class ForgotPassViewModel(private val forgotpassRepository: IForgotpassRepository):BaseViewModel() {
    private val _otp = MutableLiveData<String>()  //có thể thay đổi dữ liệu
    val otp: LiveData<String> get() = _otp

    fun sendCodeToEmail(email: ForgotPassEnity){
        executeTask(
            request = {
                forgotpassRepository.sendCodeToEmail(email)
            },
            onSuccess = { _response ->
                _response.data?.let { _data ->
                    _messageError.value = _response.message
                    _otp.value = _data
                    Log.e("TAG", "sendCodeToEmail: ${_otp.value} ", )
                    Log.e("TAG", "sendCodeToEmail: pass ${messageError}", )
                }?: kotlin.run {
                    _messageError.value = _response.message
                    _otp.value = ""
                    Log.e("TAG", "sendCodeToEmail: fail ${messageError}", )
                }
            },
            onError = {
                onErrorProcess(it)
            }
        )
    }
}