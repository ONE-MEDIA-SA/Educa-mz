package a2ibi.challenge.app.api

import a2ibi.challenge.app.api.MainRepository.ResponseListener
import com.app.educa.model.*

import com.app.educa.utils.Constants
import com.app.educa.utils.NetworkUtils
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Path

class MainRepository {

    interface ResponseListener {
        fun onSuccess(response: List<Any>)
        fun onFailure(message: String?)
    }

    val retrofitClient = NetworkUtils.getRetrofitInstance(Constants.BASE_URL)
    val endpoint = retrofitClient.create(Endpoint::class.java)

    fun getExhibitors(listener: ResponseListener) {
        endpoint.getExhibitors().enqueue(object : Callback<CombinedResult> {
            override fun onResponse(call: Call<CombinedResult>, response: Response<CombinedResult>) {
                listener.onSuccess(response.body()!!.data)
            }
            override fun onFailure(call: Call<CombinedResult>, t: Throwable) {
                listener.onFailure(t.toString())
            }
        })

    }

    fun getProducts( id: String, listener: ResponseListener) {
        endpoint.getProducts(id).enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
               listener.onFailure(t.toString())
            }

        })
    }

    fun getGallery(id : String, listener: ResponseListener) {
        endpoint.getGallery(id).enqueue(object : Callback<List<Gallery>> {
            override fun onResponse(call: Call<List<Gallery>>, response: Response<List<Gallery>>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<List<Gallery>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}