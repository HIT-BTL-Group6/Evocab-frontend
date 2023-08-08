package com.example.evocab.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {

    protected val Loading: MutableLiveData<Boolean> = MutableLiveData(false)
    protected val error: MutableLiveData<String> = MutableLiveData("")
    val isLoading: LiveData<Boolean> get() = Loading
    val isError: LiveData<String> get() = error
    private fun showLoading(){
        Loading.value = true
    }
    private fun hideLoading(){
        Loading.value = false
    }
//    private val compositeDisposable = CompositeDisposable()
//
//    protected fun registerDisposable(disposable: Disposable) {
//        compositeDisposable.add(disposable)
//    }
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
                else -> {}
            }
        }
    }
}