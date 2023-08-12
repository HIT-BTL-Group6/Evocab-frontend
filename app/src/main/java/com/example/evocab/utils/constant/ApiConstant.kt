package com.example.evocab.utils.constant

object ApiConstant {

    object URL{
        //const val BASE = "https://toeic-test-demo.onrender.com"
        const val BASE = "http://139.180.211.184:3000"
    }
    object TIMEOUT {
        const val CONNECT = 10L
        const val READ = 10L
        const val WRITE = 10L
    }

    object ENDPOINT {
        const val SEARCH = "search"
        const val SEARCH_USER = "$SEARCH/users"
        const val API_V1_AUTH ="/api/v1/auth"
        object AUTHEN{
            const val REGISTER ="$API_V1_AUTH/register"
            const val LOGIN = "$API_V1_AUTH/login"
            const val FORGOTPASSWORD = "$API_V1_AUTH/forgot-password"
        }
        object USER{
            const val GET_USER ="$API_V1_AUTH/me"

            //chưa sửa
            const val PATCH_USER ="$API_V1_AUTH/me"
        }

        object TOPIC{
            const val GET_TOPIC = "/api/v1/topics"
            const val GET_VOCAB = "/api/v1/words/"
            const val GET_VOCAB_REMEMBER = "/api/v1/user-words/remeber-word"
            const val POST_WORD = "/api/v1/user-words/remeber-word"
        }



    }
    object FILED{
        const val IDWORD = "idWord"
        const val IDTOPIC ="idTopic"
        const val IDUSER ="idUser"
    }

    const val AUTHORIZATION = "Authorization"
    const val BEARER = "Bearer"
}
