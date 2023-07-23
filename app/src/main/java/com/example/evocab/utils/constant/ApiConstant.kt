package com.example.evocab.utils.constant

object ApiConstant {

    object URL{
        const val BASE = "https://api.github.com/"
    }
    object TIMEOUT {
        const val CONNECT = 10L
        const val READ = 10L
        const val WRITE = 10L
    }

    object ENDPOINT {
        const val SEARCH = "search"
        const val SEARCH_USER = "$SEARCH/users"
    }



    const val AUTHORIZATION = "Authorization"
    const val BEARER = "Bearer"
}
