package com.example.sourcebase.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    private val Loading: MutableLiveData<Boolean> = MutableLiveData(false)
    private val error: MutableLiveData<String> = MutableLiveData("")
    val isLoading: LiveData<Boolean> get() = Loading
    val isError: LiveData<String> get() = error
    private fun showLoading(){
        Loading.value = true
    }
    private fun hideLoading(){
        Loading.value = false
    }
    protected fun <T> executeTask(
        request: suspend CoroutineScope.() -> DataResult<T>,
        onSuccess: (T) -> Unit,
        onError: (Exception) -> Unit = {},
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
            }
        }
    }
}