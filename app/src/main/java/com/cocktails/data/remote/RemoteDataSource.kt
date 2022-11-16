package com.cocktails.data.remote

import com.cocktails.domain.ApiResult
import com.cocktails.domain.Cocktail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


interface RemoteDataSource {

    suspend fun fetchCocktail(): Flow<ApiResult<Cocktail>>

    @Singleton
    class Base @Inject constructor(
        private val service: CocktailService
    ) : RemoteDataSource {
        override suspend fun fetchCocktail(): Flow<ApiResult<Cocktail>> = flow {
            emit(ApiResult.Loading)
            try {
                val data = service.getRandomCocktail().cocktail.first().toDomainCocktail()
                emit(ApiResult.Success(data))
            } catch (e: Exception) {
                emit(ApiResult.Error(e))
            }
        }
    }
}