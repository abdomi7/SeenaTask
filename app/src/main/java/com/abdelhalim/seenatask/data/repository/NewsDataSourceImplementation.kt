package com.abdelhalim.seenatask.data.repository

import androidx.compose.runtime.MutableState
import com.abdelhalim.seenatask.domain.models.News
import com.abdelhalim.seenatask.domain.repository.NewsDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class NewsDataSourceImplementation @Inject constructor(private var retrofit: Retrofit) {

    fun getNewsList(data: MutableState<News?>, failed: MutableState<Boolean>) {


        val newsDataSource: NewsDataSource = retrofit.create(NewsDataSource::class.java)
        val call: Call<News?>? = newsDataSource.news
        call?.enqueue(object : Callback<News?> {

            override fun onResponse(
                call: Call<News?>,
                response: Response<News?>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                failed.value = true
            }
        })

    }
}