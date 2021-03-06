package a2ibi.challenge.app.api

import com.app.educa.model.*
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface Endpoint {

    @GET("/exhibitors/{id}/products")
    fun getProducts(@Path("id") id: String): Call<List<Product>>

    @GET("/exhibitors/{id}/gallery")
    fun getGallery(@Path("id") id: String): Call<List<Gallery>>

    @GET("/exhibitors")
    fun getExhibitors(): Call<CombinedResult>

    @GET("/webnars")
    fun getWebinars(): Call<CombinedWebinar>

    @GET("/users/{id}")
    fun getUser(@Path("id") id: String): Call<User>

    @POST("/users/{id}")
    fun updateUser(@Path("id") id: String, @Body user: User): Call<User>

}