package com.abdelhalim.seenatask.di

import com.abdelhalim.seenatask.data.repository.NewsDataSourceImplementation
import com.abdelhalim.seenatask.domain.useCases.GetNewsData
import com.abdelhalim.seenatask.domain.useCases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModel {
    @Provides
    fun provideUseCase(newsDataSourceImplementation: NewsDataSourceImplementation): UseCases {
        return UseCases(GetNewsData(newsDataSourceImplementation))
    }
}