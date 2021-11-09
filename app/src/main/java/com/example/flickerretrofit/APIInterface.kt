package com.example.flickerretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("/services/rest/?method=flickr.photos.search&api_key=7f66f9584154461535f96f5966e41e5c&per_page=7&format=json&nojsoncallback=1")
    fun getPhoto(@Query("text")search:String): Call<FlickerDetails?>?
}
