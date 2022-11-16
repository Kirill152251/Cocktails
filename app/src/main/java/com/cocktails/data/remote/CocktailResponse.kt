package com.cocktails.data.remote

import com.google.gson.annotations.SerializedName

data class CocktailResponse(
    @SerializedName("drinks")
    val cocktail: List<CocktailRemote>
)