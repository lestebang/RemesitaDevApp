package com.lesteban.remesitadevapp.data.domain

data class UserData(
    val id: Int,
    val accessToken: String,
    val countryISO: String,
    val email: String,
    val level: String,
    val mainCard: String,
    val name: String,
    val phone: String,
    val pictureUrl: String,
)