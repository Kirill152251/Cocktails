package com.cocktails.data.remote

import com.cocktails.domain.Cocktail
import com.google.gson.annotations.SerializedName

data class CocktailRemote(
    @SerializedName("strAlcoholic")
    val alcoholic: String,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strDrink")
    val name: String,
    @SerializedName("strDrinkThumb")
    val imageUrl: String,
    @SerializedName("strGlass")
    val glass: String,
    @SerializedName("strInstructions")
    val instructions: String,
    @SerializedName("strIngredient1")
    val ingredient1: String? = null,
    @SerializedName("strIngredient2")
    val ingredient2: String? = null,
    @SerializedName("strIngredient3")
    val ingredient3: String? = null,
    @SerializedName("strIngredient4")
    val ingredient4: String? = null,
    @SerializedName("strIngredient5")
    val ingredient5: String? = null,
    @SerializedName("strIngredient6")
    val ingredient6: String? = null,
    @SerializedName("strIngredient7")
    val ingredient7: String? = null,
    @SerializedName("strIngredient8")
    val ingredient8: String? = null,
    @SerializedName("strIngredient9")
    val ingredient9: String? = null,
    @SerializedName("strIngredient10")
    val ingredient10: String? = null,
    @SerializedName("strIngredient11")
    val ingredient11: String? = null,
    @SerializedName("strIngredient12")
    val ingredient12: String? = null,
    @SerializedName("strIngredient13")
    val ingredient13: String? = null,
    @SerializedName("strIngredient14")
    val ingredient14: String? = null,
    @SerializedName("strIngredient15")
    val ingredient15: String? = null
) {
    fun toDomainCocktail(): Cocktail {
        val ingredientsList = mutableListOf<String>()

        if (ingredient1 != null) ingredientsList.add(ingredient1.lowercase())
        if (ingredient2 != null) ingredientsList.add(ingredient2.lowercase())
        if (ingredient3 != null) ingredientsList.add(ingredient3.lowercase())
        if (ingredient4 != null) ingredientsList.add(ingredient4.lowercase())
        if (ingredient5 != null) ingredientsList.add(ingredient5.lowercase())
        if (ingredient6 != null) ingredientsList.add(ingredient6.lowercase())
        if (ingredient7 != null) ingredientsList.add(ingredient7.lowercase())
        if (ingredient8 != null) ingredientsList.add(ingredient8.lowercase())
        if (ingredient9 != null) ingredientsList.add(ingredient9.lowercase())
        if (ingredient10 != null) ingredientsList.add(ingredient10.lowercase())
        if (ingredient11 != null) ingredientsList.add(ingredient11.lowercase())
        if (ingredient12 != null) ingredientsList.add(ingredient12.lowercase())
        if (ingredient13 != null) ingredientsList.add(ingredient13.lowercase())
        if (ingredient14 != null) ingredientsList.add(ingredient14.lowercase())
        if (ingredient15 != null) ingredientsList.add(ingredient15.lowercase())

        val ingredientsString = ingredientsList.joinToString(separator = ", ")
        return Cocktail(
            alcoholic,
            category,
            name,
            imageUrl,
            glass,
            instructions,
            ingredientsString
        )
    }
}