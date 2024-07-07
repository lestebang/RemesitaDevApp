package com.lesteban.remesitadevapp.data.datasource.remote

import com.lesteban.remesitadevapp.data.model.AuthModel
import com.lesteban.remesitadevapp.data.model.Balance
import com.lesteban.remesitadevapp.data.model.ItemsCard
import com.lesteban.remesitadevapp.data.model.transactions.ItemsTransaction
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

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

    @GET("/rest/v1/card/{number}/transactions/{pg}/{pgSize}")
    suspend fun transactions(
        @Header("Authorization") token: String,
        @Path("number") number: String,
        @Path("pg") pg: Int,
        @Path("pgSize") pgSize: Int
    ): ItemsTransaction


}