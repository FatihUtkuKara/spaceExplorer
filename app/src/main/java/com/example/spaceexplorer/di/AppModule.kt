package com.example.spaceexplorer.di

import android.content.Context
import androidx.room.Room
import com.example.spaceexplorer.data.api.SpaceXApiService
import com.example.spaceexplorer.data.local.SpaceExplorerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v4/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSpaceXApiService(retrofit: Retrofit): SpaceXApiService {
        return retrofit.create(SpaceXApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): SpaceExplorerDatabase {
        return Room.databaseBuilder(
            context,
            SpaceExplorerDatabase::class.java,
            "space_explorer_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideLaunchDao(database: SpaceExplorerDatabase) = database.launchDao()

    @Provides
    @Singleton
    fun provideRocketDao(database: SpaceExplorerDatabase) = database.rocketDao()
} 