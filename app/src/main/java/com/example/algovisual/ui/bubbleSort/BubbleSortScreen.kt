package com.example.algovisual.ui.bubbleSort

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
    
    
    
    
    Column() {

        Text(text = list.value[0].value.toString()+" "+list.value[0].index.toString())
        Text(text = list.value[1].value.toString()+" "+list.value[1].index.toString())
        Text(text = list.value[2].value.toString()+" "+list.value[2].index.toString())
        Text(text = list.value[3].value.toString()+" "+list.value[3].index.toString())
        Text(text = list.value[4].value.toString()+" "+list.value[4].index.toString())

//        for (item in list.value) {
//            Text(text = item.value.toString() + " " + item.index.toString())
//        }
        Button(onClick = { bubbleSortViewModel.startSorting() }) {
            Text(text = "Sort")
        }

        Text(text = str.value)
        Button(onClick = { bubbleSortViewModel.testing() }) {
            Text(text = "Testing")
        }
    }

    

}