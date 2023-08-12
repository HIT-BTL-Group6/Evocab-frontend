package com.example.evocab.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evocab.model.DataRegister
import com.example.evocab.model.User
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException

open class BaseViewModel: ViewModel() {

    protected val Loading: MutableLiveData<Boolean> = MutableLiveData(false)

    val _messageError = MutableLiveData<String>()  //set
    val messageError: LiveData<String>  //get
        get() = _messageError

    val isLoading: LiveData<Boolean> get() = Loading
    private fun showLoading(){
        Loading.value = true
    }
    private fun hideLoading(){
        Loading.value = false
    }
    private val userLiveData: MutableLiveData<User> = MutableLiveData()

    fun setUser(user: User) {
        userLiveData.value = user
    }

    fun getUser(): LiveData<User> {
        return userLiveData
    }
    protected fun <T> executeTask(
        request: suspend CoroutineScope.() -> DataResult<T>,
        onSuccess: (T) -> Unit,
        onError: (Exception) -> Unit = { e -> onErrorProcess(e)},
        showLoading: Boolean = true
    ) {

        if (showLoading) showLoading()
        viewModelScope.launch {
            when (val response = request(this)) {
                is DataResult.Success -> {
                    onSuccess(response.data)
                    hideLoading()
                }
                is DataResult.Error -> {
                    onError(response.exception)
                    hideLoading()
                }
                else -> {}
            }
        }
    }
    protected fun onErrorProcess(throwable: Exception){
        if (throwable is HttpException) {
            val responseBody = throwable.response()?.errorBody()?.string()
            try {
                _messageError.value = JSONObject(responseBody).optString("message")
                Log.e("TAG", "onErrorProcess: ${messageError.value}", )
            } catch (e: JSONException) {
                Log.e("TAG", "onErrorProcess: 2 ${e}", )
                e.printStackTrace()
            }
        }
    }
}