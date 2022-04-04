package com.app.educa.data.remote

import com.app.educa.model.ExhibitorResponse
import com.app.educa.model.Result
import com.app.educa.network.services.ExhibitorService
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class ExhibitorRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {

    suspend fun fetchExhibitors(): Result<ExhibitorResponse> {
        val exhibitorService = retrofit.create(ExhibitorService::class.java)
        return getResponse(
        )
    }

    private suspend fun <T> getResponse(request: suspend () -> Response<T>, defaultErrorMessage: String): Result<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return  Result.success(result.body())
            } else {
                val errorResponse = ErrorU
            }
        }
    }
}