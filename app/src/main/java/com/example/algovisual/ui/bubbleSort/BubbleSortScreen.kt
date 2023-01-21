package com.example.algovisual.ui.bubbleSort


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.algovisual.ui.CommonUI


@Composable
fun BubbleSortScreen(
    navController: NavController,
    bubbleSortViewModel: BubbleSortViewModel = viewModel()
) {
    val sortItem = bubbleSortViewModel.sortItems.collectAsState()
    val isNotSorting = bubbleSortViewModel.isNotSorting.collectAsState()

    CommonUI(
        sortItems = sortItem,
        isNotSorting = isNotSorting,
        onButtonClicked = {bubbleSortViewModel.startSorting()},
        shuffle = {bubbleSortViewModel.shuffle()},
        restart = {bubbleSortViewModel.restart()}
    )
}