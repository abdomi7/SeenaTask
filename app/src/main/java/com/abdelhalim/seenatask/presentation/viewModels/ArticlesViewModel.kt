package com.abdelhalim.seenatask.presentation.viewModels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.abdelhalim.seenatask.domain.models.News
import com.abdelhalim.seenatask.domain.repository.NewsDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(retrofit: Retrofit) : ViewModel() {

    init {

        val newsDataSource: NewsDataSource = retrofit.create(NewsDataSource::class.java)
        val call: Call<News?>? = newsDataSource.news
        call?.enqueue(object : Callback<News?> {

            override fun onResponse(
                call: Call<News?>,
                response: Response<News?>
            ) {
                val data: News = response.body()!!

                for (i in data.results.indices) {
                    Log.d(TAG, "onResponse: ${data.results[i].title}")
                }
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.localizedMessage}")
            }
        })
    }

}