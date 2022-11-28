package com.cocktails.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetRandomCocktailUseCase @Inject constructor(
    private val repository: CocktailsRepository
) {

    val cocktail: Flow<ApiResult<Cocktail>> = repository.getRandomCocktail()
}