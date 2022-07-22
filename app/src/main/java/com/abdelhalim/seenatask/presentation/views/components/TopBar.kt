package com.abdelhalim.seenatask.presentation.views.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp

@Composable
fun TopBar() {
    SmallTopAppBar(
        title = { Text(text = "Seena Pay Android Task", fontSize = 18.sp) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            titleContentColor = Color.White,
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun BackTopBar(
    title: String,
    buttonIcon: ImageVector,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    SmallTopAppBar(

        modifier = modifier,
        title = {
            Text(text = title)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            titleContentColor = Color.White,
            containerColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            IconButton(onClick = {
                onClick()
            }) {
                Icon(
                    buttonIcon, "Back Button", tint = Color.White
                )
            }
        },
    )
}