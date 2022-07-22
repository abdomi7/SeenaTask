package com.abdelhalim.seenatask.presentation.views.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
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