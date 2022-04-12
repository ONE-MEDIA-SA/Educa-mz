package a2ibi.challenge.app.api

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface Endpoint {
    @GET("/exhibitors")
    fun getExhibitors(): Call<JsonObject>

    @GET("/exhibitors/{id}/products")
    fun getProducts(): Call<JsonArray>


}