package com.lesteban.remesitadevapp.utils.networkconnection

sealed class ConnectionState {
    object Available : ConnectionState()
    object Unavailable : ConnectionState()
}