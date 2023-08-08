package com.example.evocab.ui.login

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atom.android.lebo.utils.extensions.saveTokenLogin
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.login.ILoginRepository
import com.example.evocab.model.BaseResponseLogin
import com.example.evocab.model.Data
import com.example.evocab.model.UserRequestLogin
import com.example.evocab.utils.constant.Constant
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException

private const val TAG ="LoginViewModel"
class LoginViewModel(private val loginRepository: ILoginRepository,
                     private val sharedPreferences: SharedPreferences
): BaseViewModel() {
    private val _token = MutableLiveData<String>()  //có thể thay đổi dữ liệu
    val token: LiveData<String> get() = _token

    private val _messsageError = MutableLiveData<String>()
    val messsageError: LiveData<String>
        get() = _messsageError

    private val _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean>
        get() = _loginState

    fun loginByPass(user: UserRequestLogin){
        Log.e(TAG, "loginByPass1: ${user} ", )
        executeTask(
            request = {
                loginRepository.loginByPass(user)
            },
            onSuccess = { _data ->
                _data.data?.let {
                    _token.value = it
                    _messsageError.value =""
                    sharedPreferences.saveTokenLogin(it)
                }?: kotlin.run {
                    Log.e(TAG, "loginByPass 2: ${_data.message}", )
                    if(_data.message == Constant.Error.LOGIN_ERROR){
                        _messsageError.value = _data.message
                    }
                }

            },
            onError = { throwable ->
                if (throwable is HttpException) {
                    val responseBody = throwable.response()?.errorBody()?.string()
                    try {
                        val jsonObject = JSONObject(responseBody)
                        val errorMessage = jsonObject.optString("message")
                        if (errorMessage == Constant.Error.LOGIN_ERROR) {
                            Log.e(TAG, "loginByPass3: ${errorMessage}", )
                            _messsageError.value = errorMessage
                        }
                    } catch (e: JSONException) {
                        Log.e(TAG, "loginByPass4: e: JSONException", )
                        e.printStackTrace()
                    }
                }
            }
        )
    }
    fun saveData(isLogin: Boolean){

    }
}