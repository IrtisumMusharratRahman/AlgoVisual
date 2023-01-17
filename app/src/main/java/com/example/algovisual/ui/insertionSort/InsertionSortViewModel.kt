package com.example.algovisual.ui.insertionSort

import android.util.Log
import android.view.View
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algovisual.DataInitializer
import com.example.algovisual.algorithms.InsertionSortAlgorithm
import com.example.algovisual.model.SortItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InsertionSortViewModel(
    val insertionSortAlgorithm: InsertionSortAlgorithm = InsertionSortAlgorithm(),
    val dataInitializer: DataInitializer = DataInitializer()
) : ViewModel() {
    private val initialList = listOf<Int>(40,70,30,10,20,80,50,90,60)

    private val list = dataInitializer(initialList)

    private val _itemList = MutableStateFlow(list)
    val itemList = _itemList.asStateFlow()

    val lst = list.toCollection(mutableListOf())
    private var _sortItems = MutableStateFlow(lst)
    val sortItems = _sortItems.asStateFlow()


    fun startSorting(){
        viewModelScope.launch {
            insertionSortAlgorithm(_itemList.value).collect{
                _sortItems.value=it.toCollection(mutableListOf())
            }
        }
    }

}