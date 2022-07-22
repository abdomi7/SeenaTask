package com.abdelhalim.seenatask.presentation.models

import com.abdelhalim.seenatask.domain.models.News
import com.devcomentry.lib.Argument

data class ArticleDetailsArgument(val news: News? = null) : Argument
