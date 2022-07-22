package com.abdelhalim.seenatask.presentation.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.abdelhalim.seenatask.presentation.viewModels.ArticlesViewModel

@Composable
fun ArticlesView(navController: NavHostController) {
    val model: ArticlesViewModel = hiltViewModel()
    Text(text = "Hiiiii")
}