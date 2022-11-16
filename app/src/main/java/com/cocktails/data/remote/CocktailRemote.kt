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
        val ingredients = mutableListOf<String>()
        when {
            ingredient1 != null -> ingredients.add(ingredient1)
            ingredient2 != null -> ingredients.add(ingredient2)
            ingredient3 != null -> ingredients.add(ingredient3)
            ingredient4 != null -> ingredients.add(ingredient4)
            ingredient5 != null -> ingredients.add(ingredient5)
            ingredient6 != null -> ingredients.add(ingredient6)
            ingredient7 != null -> ingredients.add(ingredient7)
            ingredient8 != null -> ingredients.add(ingredient8)
            ingredient9 != null -> ingredients.add(ingredient9)
            ingredient10 != null -> ingredients.add(ingredient10)
            ingredient11 != null -> ingredients.add(ingredient11)
            ingredient12 != null -> ingredients.add(ingredient12)
            ingredient13 != null -> ingredients.add(ingredient13)
            ingredient14 != null -> ingredients.add(ingredient14)
            ingredient15 != null -> ingredients.add(ingredient15)
        }
        return Cocktail(
            alcoholic,
            category,
            name,
            imageUrl,
            glass,
            instructions,
            ingredients
        )
    }
}