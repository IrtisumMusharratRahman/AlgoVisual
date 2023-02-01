package com.example.algovisual.algorithms

enum class AlgoDetails(val bestCase:String,val worstCase:String,val avarageCase:String,val spaceComplexity:String,val stability:String,) {

    BubbleSort(bestCase = "O(n)", worstCase = "O(n2)", avarageCase = "O(n2)", spaceComplexity = "O(1)", stability = "Yes"),
    SelectionSort(bestCase = "O(n2)", worstCase = "O(n2)", avarageCase = "O(n2)", spaceComplexity = "O(1)", stability = "No"),
    InsertionSort(bestCase = "O(n)", worstCase = "O(n2)", avarageCase = "O(n2)", spaceComplexity = "O(1)", stability = "Yes"),
    MergeSort(bestCase = "O(n*log n)", worstCase = "O(n*log n)", avarageCase = "O(n*log n)", spaceComplexity = "O(n)", stability = "Yes"),
    QuickSort(bestCase = "O(n*log n)", worstCase = "O(n2)", avarageCase = "O(n*log n)", spaceComplexity = "O(log n)", stability = "No")

}