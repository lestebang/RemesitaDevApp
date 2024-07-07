package com.lesteban.remesitadevapp.data.model.transactions

data class ItemsTransaction(
    val allowNext: Boolean,
    val items: List<Item>,
    val pages: Int,
    val pg: Int,
    val pgSize: Int,
    val total: Int
)