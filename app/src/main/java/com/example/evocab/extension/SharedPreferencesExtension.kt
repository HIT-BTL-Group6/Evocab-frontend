package com.atom.android.lebo.utils.extensions

import android.content.SharedPreferences
import com.example.evocab.utils.constant.Constant

fun SharedPreferences.getTokenLogin(): String? {
    return this.getString(Constant.SHARED_PREF_TOKEN_LOGIN, Constant.SHARED_PREF_DEFAULT_STRING)
}
fun SharedPreferences.getPass(): String? {
    return this.getString(Constant.SHARED_LOGIN_PASSWORD, Constant.SHARED_LOGIN_DEFAULT_STRING)
}
fun SharedPreferences.getUSerName(): String? {
    return this.getString(Constant.SHARED_LOGIN_USERNAME, Constant.SHARED_LOGIN_DEFAULT_STRING)
}

fun SharedPreferences.saveTokenLogin(token: String) {
    this.edit().putString(Constant.SHARED_PREF_TOKEN_LOGIN, token).apply()
}
fun SharedPreferences.saveLogin(pass: String,user: String) {
    this.edit().putString(Constant.SHARED_LOGIN_PASSWORD, pass).apply()
    this.edit().putString(Constant.SHARED_LOGIN_USERNAME, user).apply()
}
fun SharedPreferences.destroyPassword(): Boolean {
    return this.edit().remove(Constant.SHARED_LOGIN_PASSWORD).commit()
}
fun SharedPreferences.destroyUsername(): Boolean {
    return this.edit().remove(Constant.SHARED_LOGIN_USERNAME).commit()
}

fun SharedPreferences.destroyTokenLogin(): Boolean {
    return this.edit().remove(Constant.SHARED_PREF_TOKEN_LOGIN).commit()
}
