package com.example.algovisual.ui.insertionSort

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.algovisual.NavScreens

@Composable
fun InsertionSortScreen(
    navController: NavController,
    insertionSortViewModel: InsertionSortViewModel= InsertionSortViewModel()
) {
    val list = insertionSortViewModel.list.collectAsState()
    var l = mutableListOf<Int>(10,80,40,30,15)


    Text(text = insertionSortViewModel.insertionSortAlgorithm.invoke(l).toString())
}