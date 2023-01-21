package com.example.algovisual.ui.selectionSort

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.algovisual.ui.CommonUI


@Composable
fun SelectionSortScreen(
    navController: NavController,
    selectionSortViewModel: SelectionSortViewModel = SelectionSortViewModel()
) {
    val sortItem = selectionSortViewModel.sortItems.collectAsState()
    val isNotSorting = selectionSortViewModel.isNotSorting.collectAsState()

    CommonUI(
        sortItems = sortItem,
        isNotSorting = isNotSorting,
        onButtonClicked = {selectionSortViewModel.startSorting()},
        shuffle = {selectionSortViewModel.shuffle()},
        restart = {selectionSortViewModel.restart()}
    )
}