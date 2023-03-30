package com.project.algovisual.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.project.algovisual.ui.theme.background

@Composable
fun AppBar(
    iconClicked:() -> Unit,
    appBarTitle: @Composable ()->Unit
) {
    TopAppBar(
        title = {
                appBarTitle()
        },
        elevation = 4.dp,
        backgroundColor = background,
        navigationIcon = {
            IconButton(
                onClick = {
                    iconClicked()
                }
            ) {
                Icon(Icons.Default.Menu, null)
            }
        })
}