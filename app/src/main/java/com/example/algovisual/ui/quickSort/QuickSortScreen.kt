package com.example.algovisual.ui.quickSort

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.algovisual.ui.CommonUI

@Composable
fun QuickSortScreen(
    navController: NavController,
    quickSortSViewModel: QuickSortSViewModel = viewModel()
) {
    val sortItem = quickSortSViewModel.sortItems.collectAsState()
    val isNotSorting = quickSortSViewModel.isNotSorting.collectAsState()

    CommonUI(
        sortItems = sortItem,
        isNotSorting = isNotSorting,
        onButtonClicked = {quickSortSViewModel.startSorting()},
        shuffle = {quickSortSViewModel.shuffle()},
        restart = {quickSortSViewModel.restart()}
    )
}