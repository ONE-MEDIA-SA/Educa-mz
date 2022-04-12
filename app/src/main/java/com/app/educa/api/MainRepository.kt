package a2ibi.challenge.app.api

import a2ibi.challenge.app.api.MainRepository.ResponseListener
import com.app.educa.model.Exhibitor

import com.app.educa.utils.Constants
import com.app.educa.utils.NetworkUtils
import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository {

    interface ResponseListener {
        fun onSuccess(response: List<Exhibitor>)
        fun onFailure(message: String?)
    }

    suspend fun getAllExhibitors(listener: ResponseListener) {

        val retrofitClient = NetworkUtils
            .getRetrofitInstance(Constants.BASE_URL)
        val endpoint = retrofitClient.create(Endpoint::class.java)

        endpoint.getExhibitors().enqueue(object : Callback<JsonArray> {
            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {

                var data = mutableListOf<Exhibitor>()
                var position = 0;
                for (item in response.body()!!) {
                    var name = item.asJsonObject.get("name").asJsonObject.get("common").toString().replace("\"", "");

                    var exhibitor = Exhibitor()
                    data.add(country)
                    position++


                }

                listener.onSuccess(data)
            }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                listener.onFailure("An error has occurred")
            }


        })
    }


}