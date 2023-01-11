package com.example.algovisual

sealed class NavScreens(val route:String){

    object BubbleSort:NavScreens("bubbleSort")
    object SelectionSort:NavScreens("selectionSort")
    object InsertionSort:NavScreens("insertionSort")

}
