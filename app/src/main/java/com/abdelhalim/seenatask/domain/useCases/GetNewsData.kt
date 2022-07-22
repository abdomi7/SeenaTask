package com.abdelhalim.seenatask.domain.useCases

import androidx.compose.runtime.MutableState
import com.abdelhalim.seenatask.data.repository.NewsDataSourceImplementation
import com.abdelhalim.seenatask.domain.models.News
import javax.inject.Inject

class GetNewsData constructor(
    private val repository: NewsDataSourceImplementation
) {

    operator fun invoke(data: MutableState<News?>, failed: MutableState<Boolean>) =
        repository.getNewsList(data, failed)
}