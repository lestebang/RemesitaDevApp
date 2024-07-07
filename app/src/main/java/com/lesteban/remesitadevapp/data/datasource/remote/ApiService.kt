package com.lesteban.remesitadevapp.data.datasource.remote

import com.lesteban.remesitadevapp.data.model.AuthModel
import com.lesteban.remesitadevapp.data.model.Balance
import com.lesteban.remesitadevapp.data.model.ItemsCard
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
        @Header("Authorization") token: String
    ): Balance

    @GET("cards")
    suspend fun cards(
        @Header("Authorization") token: String
    ): ItemsCard


}