package com.abdelhalim.seenatask.presentation.models

sealed class Screens(val title: String, val route: String) {
    object ArticleDetailsScreen : Screens("Article Details", "article_details")
    object Articles : Screens("Articles", "articles")
}