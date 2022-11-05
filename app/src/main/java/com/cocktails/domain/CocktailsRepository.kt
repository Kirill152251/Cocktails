package com.cocktails.domain

import kotlinx.coroutines.flow.Flow

interface CocktailsRepository {
    suspend fun getRandomCocktail(): Flow<ApiResult<Cocktail>>
    suspend fun getAllFavouriteCocktails(): Flow<List<Cocktail>>
    suspend fun addToFavourite(cocktail: Cocktail): Boolean
    suspend fun deleteFromFavourite(cocktail: Cocktail): Boolean
}