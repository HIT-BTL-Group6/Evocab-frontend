package com.example.evocab.ui.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.evocab.base.BaseViewModel
import com.example.evocab.base.DataResult
import com.example.evocab.data.repository.register.IRegisterRepository
import com.example.evocab.model.Data
import com.example.evocab.model.UserRequestRegister
import com.example.evocab.utils.constant.Constant
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException

private const val TAG = "SignUpViewModel"
class SignupViewModel(private val registerRepo: IRegisterRepository) : BaseViewModel(){

    private val _registerResults = MutableLiveData<Data>()  //có thể thay đổi dữ liệu
    val registerResults: LiveData<Data> get() = _registerResults  //không thể thay đổi dữ liệu

    private val _messsageError = MutableLiveData<String>()
    val messsageError: LiveData<String>
        get() = _messsageError

    fun registerByEmail(user: UserRequestRegister) {
        executeTask(
            request = {
                registerRepo.registerByEmail(user)
            },
            onSuccess = {_data ->
                Log.e(TAG, "registerByEmail: Đã đi vào onSuccess", )
                _data.data?.let {
                    _registerResults.value = it
                }?: kotlin.run {
                    Log.e(TAG, "registerByEmail: ${_data.message}", )
                    if(_data.message == Constant.Error.EMAIL_ALREADY){
                        _messsageError.value = _data.message.toString()
                    }
                }
                Log.e(TAG, "registerByEmail on success: $_data", )

            },
            onError = { throwable ->
                Log.e(TAG, "registerByEmail: Đã đi vào onErrod", )
                if (throwable is HttpException) {
                    val responseBody = throwable.response()?.errorBody()?.string()
                    try {
                        val jsonObject = JSONObject(responseBody)
                        val errorMessage = jsonObject.optString("message")
                        if (errorMessage == "User is already exists") {
                            Log.e(TAG, "registerByEmail: User is already exists", )
                            _messsageError.value = errorMessage
                        }
                    } catch (e: JSONException) {
                        Log.e(TAG, "registerByEmail: e: JSONException", )
                        e.printStackTrace()
                    }
                }
            },
            showLoading = true
        )
    }
}