package com.lesteban.remesitadevapp.data.datasource.remote

import com.lesteban.remesitadevapp.data.model.AuthModel
import com.lesteban.remesitadevapp.data.model.Balance
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("auth")
    suspend fun auth(
        @Body body: Map<String,String>
    ):AuthModel

    @GET("balance")
    suspend fun balance(
        @Header("Authorization") token: String = "Bearer 2|ec131b10fb15295445e8075dfa8883b5"
    ): Balance


}