package com.lesteban.remesitadevapp.data.model

data class Item(
    val alias: String,
    val balance: Double,
    val balanceFormatted: String,
    val balanceUSD: Double,
    val balanceUSDFormatted: String,
    val cashReference: String,
    val clabe: String,
    val exchangeRate: Double,
    val locked: Boolean,
    val main: Boolean,
    val number: String,
    val numberFormatted: String,
    val status: String
)