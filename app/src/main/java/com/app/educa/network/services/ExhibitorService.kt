package com.app.educa.network.services

import com.app.educa.model.Exhibitor
import com.app.educa.model.ExhibitorResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExhibitorService {
    @GET("/exhibitors")
    suspend fun getExhibitors(): Response<ExhibitorResponse>

    @GET("/exhibitors/{exhibitor_id}")
    suspend fun getExhibitor(@Path("exhibitor_id") id: Int) : Response<Exhibitor>

}