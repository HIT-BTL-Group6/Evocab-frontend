package com.atom.android.lebo.utils.extensions

import android.content.SharedPreferences
import com.example.evocab.model.User
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

fun SharedPreferences.saveIdTopic(id: String, nameTopic: String) {
    this.edit().putString(Constant.SHARED_ID_TOPIC, id).apply()
    this.edit().putString(Constant.SHARED_NAME_TOPIC, nameTopic).apply()
}
fun SharedPreferences.getIdTopic(): String? {
    return this.getString(Constant.SHARED_ID_TOPIC, Constant.SHARED_ID_TOPIC_DEFAULT_STRING)
}
fun SharedPreferences.getNameTopic(): String? {
    return this.getString(Constant.SHARED_NAME_TOPIC, Constant.SHARED_ID_TOPIC_DEFAULT_STRING)
}
fun SharedPreferences.destroyIdTopic(): Boolean {
    return this.edit().remove(Constant.SHARED_ID_TOPIC).commit()
}
fun SharedPreferences.saveStatusTopic(status: String, NameTopic: String) {
    this.edit().putString(Constant.SHARED_STATUS+NameTopic, status).apply()
}
fun SharedPreferences.getStatus(NameTopic: String): String? {
    return this.getString(Constant.SHARED_LOGIN_USERNAME+NameTopic, Constant.SHARED_LOGIN_DEFAULT_STRING1)
}

//idUser
fun SharedPreferences.saveIdUser(IdUser: String) {
    this.edit().putString(Constant.SHARED_USER_ID, IdUser).apply()
}
fun SharedPreferences.getIdUser(): String? {
    return this.getString(Constant.SHARED_USER_ID, Constant.SHARED_ID_TOPIC_DEFAULT_STRING)
}


