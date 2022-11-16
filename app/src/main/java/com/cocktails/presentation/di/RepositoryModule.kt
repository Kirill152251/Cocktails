package com.cocktails.presentation.di

import com.cocktails.data.BaseCocktailsRepository
import com.cocktails.data.remote.RemoteDataSource
import com.cocktails.domain.CocktailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindCocktailsRepository(implementation: BaseCocktailsRepository): CocktailsRepository

    @Binds
    fun bindRemoteDataSource(implementation: RemoteDataSource.Base): RemoteDataSource
}