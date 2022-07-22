package com.abdelhalim.seenatask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.abdelhalim.seenatask.presentation.models.ArticleDetailsArgument
import com.abdelhalim.seenatask.presentation.models.Screens
import com.abdelhalim.seenatask.presentation.theme.SeenaTaskTheme
import com.abdelhalim.seenatask.presentation.views.ArticleDetailsView
import com.abdelhalim.seenatask.presentation.views.ArticlesView
import com.devcomentry.lib.composable
import com.devcomentry.lib.from
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberNavController()
            SeenaTaskTheme {
                Navigation(navController = navController)
            }
        }
    }
}

@ExperimentalMaterial3Api

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController, startDestination = Screens.Articles.route) {

        composable(Screens.Articles) {
            ArticlesView(
                navController
            )
        }
        composable(Screens.ArticleDetailsScreen, ArticleDetailsArgument()) {

            it.arguments?.let { bundle ->
                val argument = ArticleDetailsArgument().from(bundle)
                ArticleDetailsView(
                    navController, argument
                )
            }

        }
    }
}





