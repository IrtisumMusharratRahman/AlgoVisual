package com.example.algovisual.ui.insertionSort

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
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
    val str = insertionSortViewModel.abc.collectAsState()
    val sortItem = insertionSortViewModel.sortItems.collectAsState()


    Column() {

        LazyColumn(){
            items(
                items=sortItem.value,
            ){
                Text(text = "${it.value}")
            }
        }
        Button(onClick = { insertionSortViewModel.startSorting() }) {
            Text(text = "Sort")
        }

        Text(text = str.value)
        Button(onClick = { insertionSortViewModel.testing() }) {
            Text(text = "Testing")
        }
    }
}