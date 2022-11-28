package com.cocktails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cocktails.domain.ApiResult
import com.cocktails.domain.Cocktail
import com.cocktails.domain.GetRandomCocktailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomCocktailUseCase: GetRandomCocktailUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<MainScreenState>(MainScreenState.Loading)
    val state = _state.asStateFlow()

    private val _intent = MutableSharedFlow<MainScreenIntent>()
    private val intent = _intent.asSharedFlow()

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intent.collect {
                when (it) {
                    MainScreenIntent.GetRandomCocktail -> cocktail()
                    MainScreenIntent.PullToRefresh -> cocktail()
                    MainScreenIntent.OnRetry -> cocktail()
                }
            }
        }
    }

    fun setIntent(intent: MainScreenIntent) {
        val newIntent = intent
        viewModelScope.launch { _intent.emit(newIntent) }
    }

    private suspend fun cocktail() {
        getRandomCocktailUseCase.cocktail.collect { apiResult ->
            when (apiResult) {
                is ApiResult.Error -> {
                    _state.value = MainScreenState.Error
                }
                ApiResult.Loading -> _state.value = MainScreenState.Loading
                is ApiResult.Success -> {
                    _state.value = MainScreenState.RndCocktail(apiResult.result)
                }
            }
        }
    }
}

sealed class MainScreenState {
    object Loading : MainScreenState()
    object Error : MainScreenState()
    data class RndCocktail(val cocktail: Cocktail) : MainScreenState()
}

sealed class MainScreenIntent {
    object GetRandomCocktail : MainScreenIntent()
    object PullToRefresh : MainScreenIntent()
    object OnRetry: MainScreenIntent()
}
