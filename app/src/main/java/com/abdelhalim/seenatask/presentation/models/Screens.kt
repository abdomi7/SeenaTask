package com.abdelhalim.seenatask.presentation.models

import com.devcomentry.lib.ComposeScreen

sealed class Screens(title: String, route: String) : ComposeScreen(route) {
    object ArticleDetailsScreen : Screens("Article Details", "article_details")
    object Articles : Screens("Articles", "articles")
}