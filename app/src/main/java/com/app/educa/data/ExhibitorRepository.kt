package com.app.educa.data

import com.app.educa.model.Exhibitor
import com.app.educa.utils.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Constants.BASE_URL)
    .build()


interface ExhibitorService {
    @GET("exhibitors")
    suspend fun getExhibitors(): List<Exhibitor>
}

object ExhibitorApi {
    val retrofitService: ExhibitorService by lazy { retrofit.create(ExhibitorService::class.java) }
}
