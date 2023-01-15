package com.example.algovisual.ui.insertionSort

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.algovisual.algorithms.InsertionSortAlgorithm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class InsertionSortViewModel(
    val insertionSortAlgorithm: InsertionSortAlgorithm = InsertionSortAlgorithm()
) : ViewModel() {
    private val _list = MutableStateFlow<List<Int>>(listOf<Int>(10,80,40,30,15))
    val list = _list.asStateFlow()
}