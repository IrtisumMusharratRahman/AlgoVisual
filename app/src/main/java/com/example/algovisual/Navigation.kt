package com.example.algovisual

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.algovisual.ui.bubbleSort.BubbleSortScreen
import com.example.algovisual.ui.insertionSort.InsertionSortScreen
import com.example.algovisual.ui.selectionSort.SelectionSortScreen

@Composable
fun Navigation(getNavController: (navController:NavController)-> Unit) {
    val navController = rememberNavController()
    getNavController(navController)

    NavHost(navController = navController, startDestination = NavScreens.BubbleSort.route ){

        composable(route = NavScreens.BubbleSort.route){
            BubbleSortScreen(navController = navController)
        }
        composable(route = NavScreens.SelectionSort.route){
            SelectionSortScreen(navController = navController)
        }
        composable(route = NavScreens.InsertionSort.route){
            InsertionSortScreen(navController = navController)
        }

    }
}