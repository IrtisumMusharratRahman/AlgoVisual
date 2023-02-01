package com.example.algovisual.ui.quickSort

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algovisual.AlgoDetails
import com.example.algovisual.DataInitializer
import com.example.algovisual.algorithms.AdvancedSort.QuickSortAlgorithm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuickSortSViewModel(
    val quickSortAlgorithm: QuickSortAlgorithm = QuickSortAlgorithm(),
    val dataInitializer: DataInitializer = DataInitializer()
):ViewModel() {

    private var initialList = listOf<Int>(50,10,70,90,20,30,60,80,40)
    private val list = dataInitializer(initialList)
    private val _itemList = MutableStateFlow(list.toCollection(mutableListOf()))
    val details = AlgoDetails.QuickSort

    private val _isNotSorting = MutableStateFlow(true)
    val isNotSorting = _isNotSorting.asStateFlow()

    private var _sortItems = MutableStateFlow(list.toCollection(mutableListOf()))
    val sortItems = _sortItems.asStateFlow()


    fun startSorting(){
        _isNotSorting.value=false
        viewModelScope.launch {
            quickSortAlgorithm(_itemList.value,0,_itemList.value.size-1)
            _isNotSorting.value=true
        }

        viewModelScope.launch {
            quickSortAlgorithm.sortInfoFlow.collect{
                _sortItems.value=it.toCollection(mutableListOf())
            }

        }
    }

    fun shuffle(){
        val shuffled = list.shuffled()
        _sortItems.value = shuffled.toMutableList()
        _itemList.value = shuffled.toMutableList()
    }

    fun restart(){
        _sortItems.value = list.toCollection(mutableListOf())
        _itemList.value = list.toCollection(mutableListOf())
    }

}