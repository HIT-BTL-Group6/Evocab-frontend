package com.example.evocab.ui.setting

import android.content.SharedPreferences
import com.atom.android.lebo.utils.extensions.destroyPassword
import com.atom.android.lebo.utils.extensions.destroyTokenLogin
import com.atom.android.lebo.utils.extensions.destroyUsername
import com.example.evocab.base.BaseViewModel

// het met roi
private const val TAG = "SettingViewModel"
class SettingViewModel(private val sharedPreferences: SharedPreferences) : BaseViewModel(){
    fun logOut(){
        sharedPreferences.destroyUsername()
        sharedPreferences.destroyPassword()
        sharedPreferences.destroyTokenLogin()
    }
}
//class SettingViewModel(private val searchRepo: ISettingRepository) : BaseViewModel() {
//
//    private val _searchResults = MutableLiveData<Root>()
//    val searchResults: LiveData<Root> get() = _searchResults
//
//
//
//    fun searchByName(searchKey: String) {
//        executeTask(
//            request = {
//                searchRepo.changeUsername()
//            },
//            onSuccess = {
//                //_searchResults.value = it
//                Log.e(TAG, "searchByName: ${it.toString()}", )
//            },
//            onError = {
//                Log.e(TAG, "searchByName: ${it.toString()}", )
//            },
//            showLoading = true
//        )
//    }
//}