package com.abdelhalim.seenatask.presentation.views.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.abdelhalim.seenatask.domain.models.Results
import com.abdelhalim.seenatask.presentation.models.ArticleDetailsArgument
import com.abdelhalim.seenatask.presentation.models.Screens
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NewsListItem(item: Results?, navController: NavHostController) {

    Box(modifier = Modifier.clickable {
        navController.navigate(
            Screens.ArticleDetailsScreen.setParam(
                ArticleDetailsArgument(
                    item?.title,
                    item?.abstract,
                    item?.byline,
                    item?.itemType,
                    item?.publishedDate,
                    item?.multimedia?.first()?.url
                        ?: "https://static01.nyt.com/newsgraphics/images/icons/defaultPromoCrop.png"
                )
            )
        )
    }) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .height(120.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            GlideImage(
                imageModel = item?.multimedia?.first()?.url
                    ?: "https://static01.nyt.com/newsgraphics/images/icons/defaultPromoCrop.png",
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                circularReveal = CircularReveal(400)

            )

            Column(
                modifier = Modifier.height(100.dp),
                verticalArrangement = Arrangement.Top
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Text(
                        text = item?.title.toString(),
                        modifier = Modifier.padding(start = 8.dp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = item?.byline ?: "New York Times",
                        modifier = Modifier.padding(start = 8.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 12.sp

                    )
                }
                Text(
                    text = item?.publishedDate.toString().substring(0, 10),
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Thin,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.End,
                    fontSize = 10.sp

                )

            }
        }
        Divider(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = .2f),
            modifier = Modifier
        )
    }


}