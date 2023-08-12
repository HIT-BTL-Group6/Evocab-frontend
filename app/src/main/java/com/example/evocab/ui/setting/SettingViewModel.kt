package com.example.evocab.ui.setting

import android.content.SharedPreferences
import com.atom.android.lebo.utils.extensions.destroyPassword
import com.atom.android.lebo.utils.extensions.destroyTokenLogin
import com.atom.android.lebo.utils.extensions.destroyUsername
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.setting.ISettingRepository
import com.example.evocab.model.UserCanChange

// het met roi
private const val TAG = "SettingViewModel"
class SettingViewModel(private val ChangeUserRepo: ISettingRepository,
                       private val sharedPreferences: SharedPreferences) : BaseViewModel() {
//    private val _searchResults = MutableLiveData<Root>()
//    val searchResults: LiveData<Root> get() = _searchResults

    fun changeUserFor(user: UserCanChange){
        executeTask(
            request = {
                ChangeUserRepo.changeUsername(user)
            },
            onSuccess = {

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

