package com.cocktails.data

import com.cocktails.data.remote.RemoteDataSource
import com.cocktails.domain.ApiResult
import com.cocktails.domain.Cocktail
import com.cocktails.domain.CocktailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseCocktailsRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): CocktailsRepository {

    override fun getRandomCocktail(): Flow<ApiResult<Cocktail>> {
        return remoteDataSource.fetchCocktail()
    }

    override suspend fun getAllFavouriteCocktails(): Flow<List<Cocktail>> {
        return emptyFlow()
    }

    override suspend fun addToFavourite(cocktail: Cocktail): Boolean {
        return true
    }

    override suspend fun deleteFromFavourite(cocktail: Cocktail): Boolean {
        return true
    }
}