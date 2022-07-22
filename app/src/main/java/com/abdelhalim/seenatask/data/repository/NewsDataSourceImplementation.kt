package com.abdelhalim.seenatask.data.repository

import android.content.ContentValues
import android.util.Log
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
                for (i in data.value?.results?.indices!!) {
                    Log.d(ContentValues.TAG, "onResponse: ${data.value!!.results[i].title}")
                }
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                Log.d(ContentValues.TAG, "onFailure: ${t.localizedMessage}")
                failed.value = true
            }
        })

    }
}