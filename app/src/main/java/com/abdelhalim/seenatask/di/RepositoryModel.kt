package com.abdelhalim.seenatask.di

import com.abdelhalim.seenatask.data.repository.NewsDataSourceImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModel {
    @Provides
    fun provideRepository(retrofit: Retrofit): NewsDataSourceImplementation =
        NewsDataSourceImplementation(retrofit)

}