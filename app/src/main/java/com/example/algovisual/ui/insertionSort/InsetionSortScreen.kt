package com.example.algovisual.ui.insertionSort

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.algovisual.ui.CommonUI

@Composable
fun InsertionSortScreen(
    navController: NavController,
    insertionSortViewModel: InsertionSortViewModel= InsertionSortViewModel()
) {
    val sortItem = insertionSortViewModel.sortItems.collectAsState()
    val isNotSorting = insertionSortViewModel.isNotSorting.collectAsState()

    CommonUI(
        sortItems = sortItem,
        isNotSorting = isNotSorting,
        onButtonClicked = {insertionSortViewModel.startSorting()},
        shuffle = {insertionSortViewModel.shuffle()},
        restart = {insertionSortViewModel.restart()}
    )
}