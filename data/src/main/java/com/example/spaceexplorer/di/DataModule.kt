package com.example.spaceexplorer.di

import com.example.spaceexplorer.data.repository.SpaceXRepository
import com.example.spaceexplorer.data.usecase.GetLaunchesUseCase
import com.example.spaceexplorer.data.usecase.RefreshLaunchesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideGetLaunchesUseCase(repository: SpaceXRepository): GetLaunchesUseCase {
        return GetLaunchesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideRefreshLaunchesUseCase(repository: SpaceXRepository): RefreshLaunchesUseCase {
        return RefreshLaunchesUseCase(repository)
    }
} 