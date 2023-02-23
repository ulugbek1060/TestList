package com.example.kattabozortestlist.di

import com.example.data.Repository
import com.example.data.RepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ModuleBinderModule {

   @Binds
   abstract fun bindsRepository(
      repository: RepositoryImp
   ): Repository

}