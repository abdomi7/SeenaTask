package com.abdelhalim.seenatask.domain.repository

import com.abdelhalim.seenatask.domain.models.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsDataSource {

    @get:GET("home.json?api-key=ewz1QpegT5pfxZ7ogcRFEpHXFHKNZYB9")
    val news: Call<News?>?

    companion object {
        const val BASE_URL = "https://api.nytimes.com/svc/topstories/v2/"
    }
}