package a2ibi.challenge.app.api

import a2ibi.challenge.app.api.MainRepository.ResponseListener
import com.app.educa.model.Exhibitor
import com.app.educa.model.Location

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
                for ((position, item) in response.body()!!.withIndex()) {
                    var current = item.asJsonObject.get("data")
                    var id = current.asJsonObject.get("id").toString()
                    var name = current.asJsonObject.get("name").toString()
                    var email = current.asJsonObject.get("email").toString()
                    var description = current.asJsonObject.get("description").toString()
                    var category = current.asJsonObject.get("category").toString()
                    var contact = current.asJsonObject.get("contact").toString()
                    var profile = current.asJsonObject.get("profile").toString()
                    var cover = current.asJsonObject.get("cover").toString()
                    var video = current.asJsonObject.get("video").toString()
                    var website = current.asJsonObject.get("website").toString()
                    //var likes: ArrayList<String>? = current.asJsonObject.get("likes").asJsonArray
                    var sector = current.asJsonObject.get("sector").toString()
                    var long = current.asJsonObject.get("location").asJsonObject.get("long").toString()
                    var address = current.asJsonObject.get("location").asJsonObject.get("address").toString()
                    var lat = current.asJsonObject.get("location").asJsonObject.get("lat").toString()
                    var isActive: Boolean = current.asJsonObject.get("isActive").asBoolean

                    var location = Location(long.toLong(), lat.toLong(), address)
                    var exhibitor = Exhibitor(id, name, email, description, category,
                        contact, profile, cover, video, website,
                        arrayListOf(), sector, location, isActive
                    )
                     data.add(exhibitor)
                }

                listener.onSuccess(data)
            }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                listener.onFailure("An error has occurred")
            }


        })
    }


}