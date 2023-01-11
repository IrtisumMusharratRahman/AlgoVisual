package com.example.algovisual.ui.bubbleSort

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.algovisual.NavScreens

@Composable
fun BubbleSortScreen(navController: NavController) {
    Text(text = "BubbleSortScreen", modifier = Modifier.clickable { navController.navigate(NavScreens.SelectionSort.route) })

}