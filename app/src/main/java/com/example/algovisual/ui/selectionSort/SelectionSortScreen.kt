package com.example.algovisual.ui.selectionSort

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.algovisual.NavScreens

@Composable
fun SelectionSortScreen(
    navController: NavController,
    selectionSortViewModel: SelectionSortViewModel = SelectionSortViewModel()
) {
    val list = selectionSortViewModel.list.collectAsState()
    var l = mutableListOf<Int>(10,80,40,30,15)

    Text(text = selectionSortViewModel.selectionSortAlgorithm.invoke(l).toString())
}