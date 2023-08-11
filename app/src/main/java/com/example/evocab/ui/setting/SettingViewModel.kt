package com.example.evocab.ui.setting

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.search.ISearchRepository
import com.example.evocab.data.repository.setting.ISettingRepository
import com.example.evocab.model.Root
// het met roi
private const val TAG = "SettingViewModel"
class SettingViewModel : BaseViewModel(){}
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