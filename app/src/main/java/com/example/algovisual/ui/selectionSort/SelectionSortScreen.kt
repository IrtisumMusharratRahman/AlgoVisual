package com.example.algovisual.ui.selectionSort

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.algovisual.NavScreens

@Composable
fun SelectionSortScreen(navController: NavController) {
    Text(text = "SelectionSortScreen", modifier = Modifier.clickable { navController.navigate(
        NavScreens.InsertionSort.route) })
}