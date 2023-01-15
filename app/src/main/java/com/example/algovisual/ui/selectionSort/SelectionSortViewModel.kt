package com.example.algovisual.ui.selectionSort

import androidx.lifecycle.ViewModel
import com.example.algovisual.algorithms.SelectionSortAlgorithm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectionSortViewModel(
    val selectionSortAlgorithm: SelectionSortAlgorithm = SelectionSortAlgorithm()
): ViewModel() {
    private val _list = MutableStateFlow<List<Int>>(listOf<Int>(10,80,40,30,15))
    val list = _list.asStateFlow()
}