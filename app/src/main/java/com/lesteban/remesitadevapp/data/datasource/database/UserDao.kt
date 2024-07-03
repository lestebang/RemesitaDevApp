package com.lesteban.remesitadevapp.data.datasource.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("select * from UserEntity")
    fun getUsers(): Flow<List<UserEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(users: List<UserEntity>)

    @Query("select * from UserEntity WHERE name LIKE :user")
    fun getDetails(user: String): Flow<UserEntity?>
}