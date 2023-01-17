package com.example.algovisual.ui.bubbleSort

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.algovisual.NavScreens
import com.example.algovisual.algorithms.BubbleSortAlgorithm

@Composable
fun BubbleSortScreen(
    navController: NavController,
    bubbleSortViewModel: BubbleSortViewModel = viewModel()
) {
    val list = bubbleSortViewModel.itemList.collectAsState()
    val str = bubbleSortViewModel.abc.collectAsState()
    val sortItem = bubbleSortViewModel.sortItems.collectAsState()

    Log.e("TAG", "UI1: ${sortItem.value.toString()}")
    
    
    Column() {
        Log.e("TAG", "UI2: ${sortItem.value.toString()}")


        LazyColumn(){
            Log.e("TAG", "UI3: ${sortItem.value.toString()}")
            items(
                items=sortItem.value,
            ){
                Text(text = "${it.value}")
            }
        }
        Button(onClick = { bubbleSortViewModel.startSorting() }) {
            Text(text = "Sort")
        }

        Text(text = str.value)
        Button(onClick = { bubbleSortViewModel.testing() }) {
            Text(text = "Testing")
        }
    }

    

}