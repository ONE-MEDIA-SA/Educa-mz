package a2ibi.challenge.app.api

import a2ibi.challenge.app.api.MainRepository.ResponseListener
import com.app.educa.model.CombinedResult
import com.app.educa.model.Exhibitor
import com.app.educa.model.Location

import com.app.educa.utils.Constants
import com.app.educa.utils.NetworkUtils
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    interface ResponseListener {
        fun onSuccess(response: List<Exhibitor>)
        fun onFailure(message: String?)
    }

    fun getExhibitors(listener: ResponseListener) {
        val retrofitClient = NetworkUtils.getRetrofitInstance(Constants.BASE_URL)
        val endpoint = retrofitClient.create(Endpoint::class.java)
        endpoint.getExhib().enqueue(object : Callback<CombinedResult> {
            override fun onResponse(
                call: Call<CombinedResult>,
                response: Response<CombinedResult>
            ) {
                listener.onSuccess(response.body()!!.data)
            }

            override fun onFailure(call: Call<CombinedResult>, t: Throwable) {
                listener.onFailure(t.toString())
            }

        })

    }


}