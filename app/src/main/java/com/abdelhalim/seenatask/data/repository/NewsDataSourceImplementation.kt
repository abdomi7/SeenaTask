package com.abdelhalim.seenatask.data.repository

import androidx.compose.runtime.MutableState
import com.abdelhalim.seenatask.domain.models.News
import com.abdelhalim.seenatask.domain.repository.NewsDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class NewsDataSourceImplementation @Inject constructor(private var retrofit: Retrofit) {

    fun getNewsList(data: MutableState<News?>, failed: MutableState<Boolean>) {

        val newsDataSource: NewsDataSource = retrofit.create(NewsDataSource::class.java)
        val call: Observable<News>? = newsDataSource.news
        call?.subscribeOn(Schedulers.io())?.observeOn(Schedulers.io())
            ?.subscribe(object : Observer<News> {
                override fun onNext(response: News) {
                    failed.value = false
                    data.value = response
                }

                override fun onError(e: Throwable) {
                    failed.value = true
                }

                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }
            })

    }
}