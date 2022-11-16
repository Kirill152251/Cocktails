package com.cocktails.data.remote

import retrofit2.http.GET

interface CocktailService {
    @GET("1/random.php")
    suspend fun getRandomCocktail(): CocktailResponse
}