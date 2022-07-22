package com.abdelhalim.seenatask.presentation.models

import com.devcomentry.lib.Argument

data class ArticleDetailsArgument(
    var title: String? = null,
    var abstract: String? = null,
    var byline: String? = null,
    var itemType: String? = null,
    var publishedDate: String? = null,
    var imageUrl: String? = null
) : Argument
