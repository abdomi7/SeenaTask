package com.abdelhalim.seenatask.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.abdelhalim.seenatask.presentation.viewModels.ArticlesViewModel
import com.abdelhalim.seenatask.presentation.views.components.NewsListItem
import com.abdelhalim.seenatask.presentation.views.components.NoDataDesign
import com.abdelhalim.seenatask.presentation.views.components.TopBar

@ExperimentalMaterial3Api
@Composable
fun ArticlesView(navController: NavHostController) {
    val vm: ArticlesViewModel = hiltViewModel()
    Scaffold(topBar = { TopBar() }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            if (vm.failed.value && vm.news.value?.results == null) {
                NoDataDesign(
                    title = "No Data at The Moment Make Sure You Have Internet Connection",
                    image = painterResource(com.abdelhalim.seenatask.R.drawable.ic_empty),
                    onClick = { vm.getNewsData() }
                )
            } else {
                if (vm.news.value == null) {
                    CircularProgressIndicator(modifier = Modifier.padding(25.dp))

                } else {
                    LazyColumn(state = rememberLazyListState(), modifier = Modifier.fillMaxSize()) {
                        items(vm.news.value?.results!!) { item ->
                            NewsListItem(item = item, navController)

                        }
                    }
                }
            }
        }
    }
}