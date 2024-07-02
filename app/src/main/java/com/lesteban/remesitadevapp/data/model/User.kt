package com.lesteban.remesitadevapp.data.model

data class User(
    val countryISO: String,
    val email: String,
    val level: String,
    val mainCard: String,
    val name: String,
    val phone: String,
    val pictureUrl: String,
    val uid: String
)