package com.example.evocab.extension

fun <T> List<T>?.hasItem(): List<T> {
    if (this.isNullOrEmpty()) {
        return mutableListOf()
    }
    return map { it }
}