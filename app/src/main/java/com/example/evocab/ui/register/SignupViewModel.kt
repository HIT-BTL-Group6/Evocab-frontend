package com.example.evocab.ui.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.evocab.base.BaseViewModel
import com.example.evocab.base.DataResult
import com.example.evocab.data.repository.register.IRegisterRepository
import com.example.evocab.model.User
import com.example.evocab.model.UserRequestRegister
import com.example.evocab.utils.constant.Constant

private const val TAG = "SignUpViewModel"
class SignupViewModel(private val registerRepo: IRegisterRepository) : BaseViewModel(){

    private val _registerResults = MutableLiveData<User>()  //có thể thay đổi dữ liệu
    val registerResults: LiveData<User> get() = _registerResults  //không thể thay đổi dữ liệu

    private val _messsageError = MutableLiveData<String>()
    val messsageError: LiveData<String>
        get() = _messsageError

    fun registerByEmail(user: UserRequestRegister) {
        executeTask(
            request = {
                registerRepo.registerByEmail(user)
            },
            onSuccess = {_data ->

                _data.user?.let {
                    _registerResults.value = it
                }?: kotlin.run {
                    Log.e(TAG, "registerByEmail: ${_data.message}", )
                    if(_data.message == Constant.Error.EMAIL_ALREADY || _data.message == Constant.Error.USERNAME_ALREADY){
                        _messsageError.value = _data.message.toString()
                    }
                }
                Log.e(TAG, "registerByEmail on success: ${_data.toString()}", )

               // Log.e(TAG, "searchByName: ${it.toString()}" )
            },
            onError = { repo ->




            },
            showLoading = true
        )
    }
}