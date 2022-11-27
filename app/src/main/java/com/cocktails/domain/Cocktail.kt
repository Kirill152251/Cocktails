package com.cocktails.domain

data class Cocktail(
    val alcoholic: String,
    val category: String,
    val name: String,
    val imageUrl: String,
    val glass: String,
    val instructions: String,
    val ingredients: String
)
