package com.abdelhalim.seenatask.presentation.models

sealed class Screens(val title: String, val route: String) {
    object ArticleDetailsScreen : Screens("Home", "home")
    object Articles : Screens("Articles", "articles")

}