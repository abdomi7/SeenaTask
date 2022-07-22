package com.abdelhalim.seenatask.presentation.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.abdelhalim.seenatask.domain.models.News
import com.abdelhalim.seenatask.domain.useCases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    private var _news: MutableState<News?> = mutableStateOf(null)
    var news: State<News?> = _news
    private var _failed: MutableState<Boolean> = mutableStateOf(false)
    var failed: State<Boolean> = _failed

    init {
        getNewsData()
    }

    fun getNewsData() {
        useCases.getNewsData.invoke(_news, _failed)
    }
}