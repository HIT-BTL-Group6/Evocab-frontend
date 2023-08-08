package com.example.evocab.ui.forgotpass

import com.example.evocab.base.BaseViewModel
import com.example.evocab.data.repository.forgotpassword.IForgotpassRepository
import com.example.evocab.model.UserRequestForgotPass

class ForgotPassViewModel(private val forgotpassRepository: IForgotpassRepository):BaseViewModel() {

    fun sendCodeToEmail(email: UserRequestForgotPass){
        executeTask(
            request = {
                forgotpassRepository.sendCodeToEmail(email)
            },
            onSuccess = {

            },
            onError = {

            }
        )
    }
}