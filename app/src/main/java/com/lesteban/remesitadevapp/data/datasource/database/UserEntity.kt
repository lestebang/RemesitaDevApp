package com.lesteban.remesitadevapp.data.datasource.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lesteban.remesitadevapp.data.domain.UserData

@Entity
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val accessToken: String,
    val countryISO: String,
    val email: String,
    val level: String,
    val mainCard: String,
    val name: String,
    val phone: String,
    val pictureUrl: String,
    val uid: String
)


fun List<UserEntity>.asDomainModel(): List<UserData> {
    return map {
        UserData(
            id = it.id,
            accessToken = it.accessToken,
            countryISO = it.countryISO,
            email = it.email,
            level = it.level,
            mainCard = it.mainCard,
            name = it.name,
            phone = it.phone,
            pictureUrl = it.pictureUrl
        )
    }
}