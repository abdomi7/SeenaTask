package com.abdelhalim.seenatask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdelhalim.seenatask.presentation.models.Screens
import com.abdelhalim.seenatask.presentation.theme.SeenaTaskTheme
import com.abdelhalim.seenatask.presentation.views.ArticleDetailsView
import com.abdelhalim.seenatask.presentation.views.ArticlesView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalComposeUiApi

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            val navController: NavHostController = rememberNavController()

            SeenaTaskTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(navController = navController)

                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController, startDestination = Screens.Articles.route) {

        composable(Screens.Articles.route) {
            ArticlesView(
                navController
            )
        }
        composable(Screens.ArticleDetailsScreen.route) {
            ArticleDetailsView(
                navController
            )
        }
    }
}




