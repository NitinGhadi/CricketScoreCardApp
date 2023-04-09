package com.example.testapplication.network

import com.example.testapplication.api.MatchDetailsApi
import com.example.testapplication.utils.Constant.baseURl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesMatchDetailsApi(retrofit: Retrofit): MatchDetailsApi {
        return retrofit.create(MatchDetailsApi::class.java)
    }

}