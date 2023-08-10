package com.example.evocab.extension

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
fun Context.showToast(resource: Int) {
    Toast.makeText(this, resource, Toast.LENGTH_SHORT).show()
}