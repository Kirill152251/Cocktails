package com.cocktails.domain

class AddToFavouriteUseCase(private val repository: CocktailsRepository) {
    suspend fun execute(cocktail: Cocktail): Boolean {
        return repository.addToFavourite(cocktail)
    }
}