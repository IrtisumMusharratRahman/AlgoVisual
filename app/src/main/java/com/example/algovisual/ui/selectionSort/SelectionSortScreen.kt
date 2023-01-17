package com.example.algovisual.ui.selectionSort

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.algovisual.NavScreens


@Composable
fun SelectionSortScreen(
    navController: NavController,
    selectionSortViewModel: SelectionSortViewModel = SelectionSortViewModel()
) {
    val str = selectionSortViewModel.abc.collectAsState()
    val sortItem = selectionSortViewModel.sortItems.collectAsState()


    Column() {

        LazyColumn(){
            items(
                items=sortItem.value,
            ){
                Text(text = "${it.value}")
            }
        }
        Button(onClick = { selectionSortViewModel.startSorting() }) {
            Text(text = "Sort")
        }

        Text(text = str.value)
        Button(onClick = { selectionSortViewModel.testing() }) {
            Text(text = "Testing")
        }
    }

}