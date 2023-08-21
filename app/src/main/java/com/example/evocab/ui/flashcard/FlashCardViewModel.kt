package com.example.evocab.ui.flashcard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.vocab.IVocabRepository
import com.example.evocab.model.BaseReponseMissed
import com.example.evocab.model.Word
import com.example.evocab.model.WordRemember
import com.example.evocab.utils.constant.ApiConstant
import retrofit2.http.Path

class FlashCardViewModel(private val flashCardRepo: IVocabRepository): BaseViewModel() {
    private val _word = MutableLiveData<Word>()
    val word: LiveData<Word> get() = _word

    val _chooseMissedOrRemember = MutableLiveData<String>()
    val chooseMissedOrRemember: LiveData<String> get() = _chooseMissedOrRemember

    private val _listVocab = MutableLiveData<List<Word>>()
    val listVocab: LiveData<List<Word>> get() = _listVocab

    fun get1Vocab(idWord: String){
        executeTask(
            request = {
                flashCardRepo.get1Vocab(idWord)
            },
            onSuccess = { _response ->
                _response.data?.let { _data ->
                    _messageError.value = _response.message
                    _word.value = _data
                    Log.e("TAG", "get1Vocab: ${_word.value} ", )
                    Log.e("TAG", "get1Vocab: pass ${messageError}", )
                }?: kotlin.run {
                    _messageError.value = _response.message
                    _word.value = _response.data!!
                    Log.e("TAG", "get1Vocab: fail ${messageError}", )
                }
            },
            onError = {
                onErrorProcess(it)
            },
            showLoading = true
        )
    }

    fun chooseMissedOrRemember(idUser: String, wordRequest: WordRemember){
        executeTask(
            request = {
                flashCardRepo.chooseMissedOrRemember(idUser, wordRequest)
            },
            onSuccess = { _response ->
                _response.data?.words?.let { _data ->
                    _chooseMissedOrRemember.value = _response.message
                    Log.e("TAG", "get1Vocab: ${_chooseMissedOrRemember.value} ", )
                }?: kotlin.run {
                    _chooseMissedOrRemember.value = _response.message
                    Log.e("TAG", "get1Vocab: fail ${messageError}", )
                }
            },
            onError = {
                onErrorProcess(it)
            }
        )
    }

    fun postWord(idUser: String, wordRemember: WordRemember){
        executeTask(
            request = {
                flashCardRepo.postWord(idUser, wordRemember)
            },
            onSuccess = {_response ->
                _response.data?.let { _data ->
                    //_messageError.value = _response.message
                    //_listVocab.value = _data
                    Log.e("TAG", "getAllVocabInTopic: ${_listVocab.value} ", )
                    Log.e("TAG", "getAllVocabInTopic: pass ${messageError.value}", )
                }?: kotlin.run {
                    //_messageError.value = _response.message
                    //_listVocab.value = _response.data!!
                    Log.e("TAG", "getAllVocabInTopic: fail ${messageError}", )
                }
            },
            onError = {
                onErrorProcess(it)
            }
        )
    }



    fun getAllVocabInTopic(idTopic: String){
        executeTask(
            request = {
                flashCardRepo.getAllVocabInTopic(idTopic)
            },
            onSuccess = {_response ->
                _response.data?.let { _data ->
                    _messageError.value = _response.message
                    _listVocab.value = _data
                    Log.e("TAG", "getAllVocabInTopic: ${_listVocab.value} ", )
                    Log.e("TAG", "getAllVocabInTopic: pass ${messageError.value}", )
                }?: kotlin.run {
                    _messageError.value = _response.message
                    _listVocab.value = _response.data!!
                    Log.e("TAG", "getAllVocabInTopic: fail ${messageError}", )
                }
            },
            onError = {
                onErrorProcess(it)
            }
        )
    }

}