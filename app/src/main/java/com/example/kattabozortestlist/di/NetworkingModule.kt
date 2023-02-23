package com.example.kattabozortestlist.di

import com.example.data.source.KattaBozorApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val URL = "https://www.kattabozor.uz";

@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {

   @Provides
   @Singleton
   fun providesGson(): Gson = GsonBuilder().setLenient().create()

   @Provides
   @Singleton
   fun provideRetrofit(gson: Gson): Retrofit =
      Retrofit.Builder()
         .baseUrl(URL)
         .addConverterFactory(GsonConverterFactory.create(gson))
         .build()

   @Provides
   @Singleton
   fun provideKattaBozorApi(retrofit: Retrofit): KattaBozorApi =
     retrofit.create(KattaBozorApi::class.java)

}