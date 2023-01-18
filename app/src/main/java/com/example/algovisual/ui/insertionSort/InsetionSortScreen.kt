package com.example.algovisual.ui.insertionSort

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.algovisual.ui.SimpleSortUI

@Composable
fun InsertionSortScreen(
    navController: NavController,
    insertionSortViewModel: InsertionSortViewModel= InsertionSortViewModel()
) {
    val sortItem = insertionSortViewModel.sortItems.collectAsState()

    SimpleSortUI(sortItems = sortItem) {
        insertionSortViewModel.startSorting()
    }

}