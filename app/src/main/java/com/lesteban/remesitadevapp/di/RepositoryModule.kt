package com.lesteban.remesitadevapp.di

import com.lesteban.remesitadevapp.data.datasource.remote.ApiService
import com.lesteban.remesitadevapp.data.repository.RemesitaRespository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule  {

    /**
     * Provides RemoteDataRepository for access api service method
     */
    @Singleton
    @Provides
    fun provideRemesitaRepository(
        apiService: ApiService,
    ): RemesitaRespository {
        return RemesitaRespository(
            apiService
        )
    }
}