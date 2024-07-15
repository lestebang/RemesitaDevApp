package com.lesteban.remesitadevapp.di

import com.lesteban.remesitadevapp.data.datasource.UserDataSource
import com.lesteban.remesitadevapp.data.repository.DefaultUserRespository
import com.lesteban.remesitadevapp.data.repository.UserRepository
import com.lesteban.remesitadevapp.ui.screens.activity.UserViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {

    @Provides
    fun provideUserViewModel(repo: DefaultUserRespository): UserViewModel {
        return UserViewModel(repo)
    }


}