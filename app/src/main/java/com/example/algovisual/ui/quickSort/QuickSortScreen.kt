package com.example.algovisual.ui.quickSort

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.algovisual.ui.SimpleSortUI
import com.example.algovisual.ui.bubbleSort.BubbleSortViewModel

@Composable
fun QuickSortScreen(
    navController: NavController,
    quickSortSViewModel: QuickSortSViewModel = viewModel()
) {
    val sortItem = quickSortSViewModel.sortItems.collectAsState()
    val isNotSorting = quickSortSViewModel.isNotSorting.collectAsState()

    SimpleSortUI(
        sortItems = sortItem,
        isNotSorting = isNotSorting,
        onButtonClicked = {quickSortSViewModel.startSorting()},
        shuffle = {quickSortSViewModel.shuffle()}
    )
}