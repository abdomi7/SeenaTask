package com.abdelhalim.seenatask.presentation.viewModels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.abdelhalim.seenatask.domain.models.News
import com.abdelhalim.seenatask.domain.useCases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    private var _news: MutableState<News?> = mutableStateOf(null)
    var news: State<News?> = _news
    private var _failed: MutableState<Boolean> = mutableStateOf(false)
    var failed: State<Boolean> = _failed
    private val _isRefreshing = mutableStateOf(false)
    val isRefreshing: State<Boolean>
        get() = _isRefreshing

    init {
        getNewsData()
    }

    fun getNewsData() {
        useCases.getNewsData.invoke(_news, _failed)
        _isRefreshing.value = true
        Observable.create<Any> { emitter ->
            Log.d("DelayExample", "Create")

            emitter.onComplete()
        }
            .subscribeOn(Schedulers.io())
            .delay(2, TimeUnit.SECONDS)
            .observeOn(Schedulers.io()).doOnComplete {
                _isRefreshing.value = false
                Log.d("DelayExample", "Done")
            }.subscribe()
    }
}