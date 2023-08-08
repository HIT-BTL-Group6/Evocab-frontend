package com.example.evocab.utils.constant

object Constant {
    private const val PROJECT_NAME = "com.example.evocab."
    object Error{
        const val USERNAME_ALREADY = "User is already exists"
        const val EMAIL_ALREADY = "User is already exists"
        const val LOGIN_ERROR = "Email or password is incorrect"
    }
    //const val SHARED_PREF_ROOT = PROJECT_NAME + "SHARED_PREF"
    const val SHARED_PREF_DEFAULT_STRING = ""
    const val SHARED_PREF_TOKEN_LOGIN = PROJECT_NAME + "TOKEN_LOGIN"
//    const val SHARED_PREF_TOKEN_MESSAGE = PROJECT_NAME + "TOKEN_MESSAGE"
//    const val SHARED_PREF_EMAIL = PROJECT_NAME + "EMAIL"
}