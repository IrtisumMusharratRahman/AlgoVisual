package com.example.algovisual.ui.insertionSort

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.algovisual.NavScreens

@Composable
fun InsertionSortScreen(navController: NavController) {
    Text(text = "InsertionSortScreen", modifier = Modifier.clickable { navController.navigate(
        NavScreens.BubbleSort.route) })
}