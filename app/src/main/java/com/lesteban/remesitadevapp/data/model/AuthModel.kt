package com.lesteban.remesitadevapp.data.model

import com.lesteban.remesitadevapp.data.datasource.database.UserEntity
import kotlin.random.Random

data class AuthModel(
    val accessToken: String,
    val user: User
)

fun List<AuthModel>.asDatabaseModel(): List<UserEntity> {
    return map {
        UserEntity(
            id = 1,
            accessToken = it.accessToken,
            countryISO = it.user.countryISO,
            email = it.user.email,
            level = it.user.level,
            mainCard = it.user.mainCard,
            name = it.user.name,
            phone = it.user.phone,
            pictureUrl = it.user.pictureUrl,
            uid = it.user.uid
        )
    }
}