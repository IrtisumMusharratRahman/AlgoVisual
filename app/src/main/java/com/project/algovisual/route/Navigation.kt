package com.project.algovisual.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.algovisual.algorithms.AlgoDetails
import com.project.algovisual.algorithms.SimpleSort.BubbleSortAlgorithm
import com.project.algovisual.algorithms.SimpleSort.InsertionSortAlgorithm
import com.project.algovisual.algorithms.SimpleSort.SelectionSortAlgorithm
import com.project.algovisual.ui.mergeSort.MergeSortScreen
import com.project.algovisual.ui.quickSort.QuickSortScreen
import com.project.algovisual.ui.simpleSortingAlgorithm.SimpleSortingAlgorithmScreen
import com.project.algovisual.ui.simpleSortingAlgorithm.SimpleSortingAlgorithmViewModel

@Composable
fun Navigation(getNavController: (navController:NavController)-> Unit) {
    val navController = rememberNavController()
    getNavController(navController)

    NavHost(navController = navController, startDestination = NavScreens.BubbleSort.route ){

        composable(route = NavScreens.BubbleSort.route){
            SimpleSortingAlgorithmScreen(
                navController = navController,
                sortViewModel = SimpleSortingAlgorithmViewModel(sortAlgorithm = BubbleSortAlgorithm(), details = AlgoDetails.BubbleSort)
            )
        }
        composable(route = NavScreens.SelectionSort.route){
            SimpleSortingAlgorithmScreen(
                navController = navController,
                sortViewModel = SimpleSortingAlgorithmViewModel(sortAlgorithm = SelectionSortAlgorithm(), details = AlgoDetails.SelectionSort)
            )
        }
        composable(route = NavScreens.InsertionSort.route){
            SimpleSortingAlgorithmScreen(
                navController = navController,
                sortViewModel = SimpleSortingAlgorithmViewModel(sortAlgorithm = InsertionSortAlgorithm(), details = AlgoDetails.InsertionSort)
            )
        }
        composable(route = NavScreens.MergeSort.route){
            MergeSortScreen(navController = navController)
        }
        composable(route = NavScreens.QuickSort.route){
            QuickSortScreen(navController = navController)
        }

    }
}