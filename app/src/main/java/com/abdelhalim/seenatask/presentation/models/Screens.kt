package com.abdelhalim.seenatask.presentation.models

import com.devcomentry.lib.ComposeScreen

sealed class Screens(route: String) : ComposeScreen(route) {
    object ArticleDetailsScreen : Screens("article_details")
    object Articles : Screens("articles")
}