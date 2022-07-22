package com.abdelhalim.seenatask.presentation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.abdelhalim.seenatask.presentation.viewModels.ArticlesViewModel
import com.abdelhalim.seenatask.presentation.views.components.TopBar

@ExperimentalMaterial3Api
@Composable
fun ArticlesView(navController: NavHostController) {
    val model: ArticlesViewModel = hiltViewModel()
    Scaffold(topBar = { TopBar() }) {
        Column(
            modifier = Modifier
                .padding(it)

        ) {


            if (model.news.value == null) {
                CircularProgressIndicator()

            } else {
                LazyColumn(state = rememberLazyListState(), modifier = Modifier.fillMaxSize()) {
                    items(model.news.value?.results!!) { item ->
                        Text(text = item.title.toString())
                    }
                }

            }
        }
    }
}