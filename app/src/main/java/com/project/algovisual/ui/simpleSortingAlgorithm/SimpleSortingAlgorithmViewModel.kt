package com.project.algovisual.ui.simpleSortingAlgorithm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.algovisual.algorithms.AlgoDetails
import com.project.algovisual.DataInitializer
import com.project.algovisual.algorithms.SimpleSort.SimpleSortAlgorithm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SimpleSortingAlgorithmViewModel(
    val sortAlgorithm: SimpleSortAlgorithm,
    val details: AlgoDetails,
    val dataInitializer: DataInitializer = DataInitializer()
): ViewModel() {

    private val initialList = listOf<Int>(50,10,70,90,20,30,60,80,40)
    private val list = dataInitializer(initialList)
    private val _itemList = MutableStateFlow(list.toCollection(mutableListOf()))


    private val _isNotSorting = MutableStateFlow(true)
    val isNotSorting = _isNotSorting.asStateFlow()

    private var _sortItems = MutableStateFlow(list.toCollection(mutableListOf()))
    val sortItems = _sortItems.asStateFlow()


    fun startSorting(){
        _isNotSorting.value=false
        viewModelScope.launch {
            sortAlgorithm(_itemList.value).collect{
                _sortItems.value=it.toCollection(mutableListOf())
            }
            _isNotSorting.value=true
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