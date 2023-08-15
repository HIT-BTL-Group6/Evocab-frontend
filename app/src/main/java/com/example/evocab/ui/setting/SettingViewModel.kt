package com.example.evocab.ui.setting

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atom.android.lebo.utils.extensions.destroyPassword
import com.atom.android.lebo.utils.extensions.destroyTokenLogin
import com.atom.android.lebo.utils.extensions.destroyUsername
import com.atom.android.lebo.utils.extensions.saveIdUser
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.home.IHomeRepository
import com.example.evocab.data.repository.setting.ISettingRepository
import com.example.evocab.model.User
import com.example.evocab.model.UserCanChange

// het met roi
private const val TAG = "SettingViewModel"
class SettingViewModel(private val ChangeUserRepo: ISettingRepository,
                       private val sharedPreferences: SharedPreferences,
                       private val homeRepository: IHomeRepository
) : BaseViewModel() {
val _getResults = MutableLiveData<User>()  //có thể thay đổi dữ liệu
    val getResults: LiveData<User> get() = _getResults
    val _getChangeResults = MutableLiveData<Boolean>()  //có thể thay đổi dữ liệu
    val getChangeResults: LiveData<Boolean> get() = _getChangeResults

    val _getLoi = MutableLiveData<String>()  //có thể thay đổi dữ liệu
    val getLoi: LiveData<String> get() = _getLoi

    fun changeUserFor(idUser: String, user: UserCanChange){
        executeTask(
            request = {
                ChangeUserRepo.changeUsername(idUser, user)
            },
            onSuccess = { baseRepo ->
                _getChangeResults.value = true
                _messageError.value = baseRepo.message
                Log.e(TAG, "changeUserFor: ${messageError.value}", )
            },
            onError = {
                onErrorProcess(it)
                _messageError.value = it.toString()
                Log.e(TAG, "changeUserFor: exception ${messageError.value}", )
            },
            showLoading = true
        )
    }
    fun getUserForSetting(){
        executeTask(
            request = {
                homeRepository.getInforUser()
            },
            onSuccess = { _response ->
                _response.data?.let { _data ->
                    _getResults.value = _data
                    Log.e(com.example.evocab.ui.home.TAG, "getInforUser: user khi get ${_data}", )
                    _messageError.value = _response.message
                    try {
                        sharedPreferences.saveIdUser(_data.id.toString())
                    }catch (e: Exception){

                    }

                    //sharedPreferences.saveIdTopic(_data.topicId.toString(), _data.n)
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
    fun logOut() {
        sharedPreferences.destroyUsername()
        sharedPreferences.destroyPassword()
        sharedPreferences.destroyTokenLogin()
    }

}

