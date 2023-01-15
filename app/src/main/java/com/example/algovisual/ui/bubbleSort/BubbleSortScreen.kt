package com.example.algovisual.ui.bubbleSort

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.algovisual.NavScreens
import com.example.algovisual.algorithms.BubbleSortAlgorithm

@Composable
fun BubbleSortScreen(
    navController: NavController,
    bubbleSortViewModel: BubbleSortViewModel = BubbleSortViewModel()
) {
    val list = bubbleSortViewModel.list.collectAsState()

    Text(text = bubbleSortViewModel.bubbleSortAlgorithm.invoke(list.value).toString())

}