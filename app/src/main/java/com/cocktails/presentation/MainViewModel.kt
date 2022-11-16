package com.cocktails.presentation

import androidx.lifecycle.ViewModel
import com.cocktails.domain.ApiResult
import com.cocktails.domain.Cocktail
import com.cocktails.domain.GetRandomCocktailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomCocktailUseCase: GetRandomCocktailUseCase
) : ViewModel() {

    suspend fun cocktail(): Flow<ApiResult<Cocktail>> = withContext(Dispatchers.IO) {
        getRandomCocktailUseCase.execute()
    }
}