package com.cocktails.domain

class DeleteFromFavouriteUseCase(private val repository: CocktailsRepository) {
    suspend fun execute(cocktail: Cocktail): Boolean {
        return repository.deleteFromFavourite(cocktail)
    }
}