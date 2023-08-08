package com.example.evocab.utils.constant

object ApiConstant {

    object URL{
        const val BASE = "https://toeic-test-demo.onrender.com"
        //const val BASE = "http://139.180.211.184:3000"
    }
    object TIMEOUT {
        const val CONNECT = 10L
        const val READ = 10L
        const val WRITE = 10L
    }

    object ENDPOINT {
        const val SEARCH = "search"
        const val SEARCH_USER = "$SEARCH/users"
        const val REGISTER ="/api/v1/auth/register"
        const val LOGIN = "/api/v1/auth/login"
        const val FORGOTPASSWORD = "/api/v1/auth/forgot-password"
    }

    const val AUTHORIZATION = "Authorization"
    const val BEARER = "Bearer"
}
