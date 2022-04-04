package com.app.educa.data.remote

import com.app.educa.model.Result
import retrofit2.Retrofit
import javax.inject.Inject

class ExhibitorRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {

    suspend fun fetchExhibitors(): Result<>
}