package com.cocktails.data

data class CocktailDataModel(
    val alcoholic: String,
    val category: String,
    val name: String,
    val imageUrl: String,
    val glass: String,
    val instructions: String,
    val ingredients: List<String>
)
