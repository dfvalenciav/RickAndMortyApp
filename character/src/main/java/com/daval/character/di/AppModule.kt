package com.daval.character.di

import com.daval.character.data.remote.RickAndMartiAPI
import com.daval.character.data.repository.CharacterRepositoryImpl
import com.daval.character.domain.repository.CharacterRepository
import com.daval.core.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickAndMartiApi() : RickAndMartiAPI {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: RickAndMartiAPI): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }
}