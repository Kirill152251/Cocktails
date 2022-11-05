package com.cocktails.domain

import kotlinx.coroutines.flow.Flow

class GetAllCocktailsUseCase(private val repository: CocktailsRepository) {
    suspend fun execute(): Flow<List<Cocktail>> {
        return repository.getAllFavouriteCocktails()
    }
}