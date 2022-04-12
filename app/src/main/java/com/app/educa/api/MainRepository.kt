package a2ibi.challenge.app.api

import a2ibi.challenge.app.api.MainRepository.ResponseListener
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

    suspend fun getAllExhibitors(listener: ResponseListener) {

        val retrofitClient = NetworkUtils
            .getRetrofitInstance(Constants.BASE_URL)
        val endpoint = retrofitClient.create(Endpoint::class.java)

        println("EXPO test")

        endpoint.getExhibitors().enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                var current = response.body()?.asJsonObject?.get("data")?.asJsonArray
                var data = mutableListOf<Exhibitor>()

                current!!.forEach {
                    var id = it.asJsonObject.get("id").toString().trim().replace("\"", "");
                    var name = it.asJsonObject.get("name").toString().trim().replace("\"", "");
                    var email = it.asJsonObject.get("email").toString().trim().replace("\"", "");
                    var description = it.asJsonObject.get("description").toString().trim().replace("\"", "");
                    //var category = it.asJsonObject.get("category").toString()
                    var contact = it.asJsonObject.get("contact").toString().trim().replace("\"", "");
                    var profile = it.asJsonObject.get("avatar").toString().trim().replace("\"", "");
                    var cover = it.asJsonObject.get("profile_background").toString().trim().replace("\"", "");
                    var video = it.asJsonObject.get("apresentation_video").toString().trim().replace("\"", "");
                    var website = it.asJsonObject.get("website").toString().trim().replace("\"", "");
                    //var likes: ArrayList<String>? = it.asJsonObject.get("likes").asJsonArray
                    var sector = it.asJsonObject.get("sector").toString().trim().replace("\"", "");
                    var long = it.asJsonObject.get("location").asJsonObject.get("lng").toString().trim().replace("\"", "");
                    var address = it.asJsonObject.get("location").asJsonObject.get("address").toString().trim().replace("\"", "");
                    var lat = it.asJsonObject.get("location").asJsonObject.get("lat").toString().trim()
                    var isActive: Boolean = it.asJsonObject.get("isActive").asBoolean

                    var location = Location()
                    println("Location: $long " )


                    var exhibitor = Exhibitor(id, name, email, description,
                        contact, profile, cover, video, website,
                        arrayListOf(), sector, location, isActive
                    )
                     data.add(exhibitor)
                }
                listener.onSuccess(data)
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                listener.onFailure("An error has occurred $t")
            }


        })
    }


}