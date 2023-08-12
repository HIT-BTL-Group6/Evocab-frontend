package com.example.evocab.extension

import android.media.MediaPlayer
import android.util.Log
import com.example.evocab.utils.constant.ApiConstant

fun MediaPlayer.loadSound(soundUrl: String){
    val uri= "${ApiConstant.URL.BASE}/${soundUrl}"
    try {
        this.reset()
        this.setDataSource(uri)
        this.prepareAsync()
        Log.e("TAG", "loadSound: thành công", )
    } catch (e: Exception) {
        Log.e("TAG", "loadSound: lỗi", )
        e.printStackTrace()
    }
}
