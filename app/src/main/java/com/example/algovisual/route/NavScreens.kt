package com.example.algovisual.route

sealed class NavScreens(val route:String){

    object MainScreen: NavScreens("main")
    object BubbleSort: NavScreens("bubbleSort")
    object SelectionSort: NavScreens("selectionSort")
    object InsertionSort: NavScreens("insertionSort")

}
