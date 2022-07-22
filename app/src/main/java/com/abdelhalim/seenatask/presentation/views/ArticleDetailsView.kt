package com.abdelhalim.seenatask.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.abdelhalim.seenatask.presentation.models.ArticleDetailsArgument
import com.abdelhalim.seenatask.presentation.views.components.BackTopBar
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalMaterial3Api
@Composable
fun ArticleDetailsView(navController: NavHostController, argument: ArticleDetailsArgument) {
    Scaffold(modifier = Modifier,
        topBar = {
            BackTopBar(
                title = "Article Details",
                buttonIcon = Icons.Default.ArrowBack,
                modifier = Modifier,
                onClick = { navController.popBackStack() }
            )
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                imageModel = argument.imageUrl
                    ?: "https://static01.nyt.com/newsgraphics/images/icons/defaultPromoCrop.png",
                modifier = Modifier
                    .padding(12.dp)
                    .size(200.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                circularReveal = CircularReveal(400)

            )

            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ) {
                Text(text = "Title   ", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = argument.title.toString(), color = Color.Gray)
            }
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ) {
                Text(text = "Published By   ", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = argument.byline.toString(), color = Color.Gray)
            }
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ) {
                Text(text = "Summary   ", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = argument.abstract.toString(), color = Color.Gray)
            }
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ) {
                Text(text = "Date   ", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = argument.publishedDate.toString().substring(0, 10), color = Color.Gray)
            }
        }
    }
}