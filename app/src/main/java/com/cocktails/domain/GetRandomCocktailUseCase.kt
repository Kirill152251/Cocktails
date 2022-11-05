package com.cocktails.domain

import kotlinx.coroutines.flow.Flow

class GetRandomCocktailUseCase(private val repository: CocktailsRepository) {
    suspend fun execute(): Flow<ApiResult<Cocktail>> {
        return repository.getRandomCocktail()
    }
}