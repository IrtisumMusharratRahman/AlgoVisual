package com.example.algovisual.ui.quickSort

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algovisual.DataInitializer
import com.example.algovisual.algorithms.MergeSortAlgorithm
import com.example.algovisual.algorithms.QuickSortAlgorithm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class QuickSortSViewModel(
    val quickSortAlgorithm: QuickSortAlgorithm = QuickSortAlgorithm(),
    val dataInitializer: DataInitializer = DataInitializer()
):ViewModel() {

    private val initialList = listOf<Int>(40,70,30,10,20,80,50,90,60)

    private val list = dataInitializer(initialList)

    private val _itemList = MutableStateFlow(list)
    val itemList = _itemList.asStateFlow()

    val lst = list.toCollection(mutableListOf())
    private var _sortItems = MutableStateFlow(lst)
    val sortItems = _sortItems.asStateFlow()


    fun startSorting(){
        viewModelScope.launch {
            quickSortAlgorithm(_itemList.value,0,_itemList.value.size-1)
        }
        viewModelScope.launch {
            quickSortAlgorithm.sortInfoFlow.collect{
                _sortItems.value=it.toCollection(mutableListOf())
            }
        }
    }

}