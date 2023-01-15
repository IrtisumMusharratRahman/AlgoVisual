package com.example.algovisual.ui.bubbleSort

import androidx.lifecycle.ViewModel
import com.example.algovisual.algorithms.BubbleSortAlgorithm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class BubbleSortViewModel(
    val bubbleSortAlgorithm: BubbleSortAlgorithm = BubbleSortAlgorithm()
):ViewModel() {

    private val _list = MutableStateFlow<List<Int>>(listOf<Int>(10,80,40,30,15))
    val list = _list.asStateFlow()



}