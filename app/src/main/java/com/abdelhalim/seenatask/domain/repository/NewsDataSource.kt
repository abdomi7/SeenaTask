package com.abdelhalim.seenatask.domain.repository

import com.abdelhalim.seenatask.domain.models.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsDataSource {
    /**
     * The return type is important here
     * The class structure that you've defined in Call<T>
     * should exactly match with your json response
     * If you are not using another api, and using the same as mine
     * then no need to worry, but if you have your own API, make sure
     * you change the return type appropriately
    </T> */
    @get:GET("home.json?api-key=ewz1QpegT5pfxZ7ogcRFEpHXFHKNZYB9")
    val news: Call<News?>?

    companion object {
        const val BASE_URL = "https://api.nytimes.com/svc/topstories/v2/"
    }
}