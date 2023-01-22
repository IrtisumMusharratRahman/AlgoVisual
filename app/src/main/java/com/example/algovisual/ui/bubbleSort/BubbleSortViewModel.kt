package com.example.algovisual.ui.bubbleSort

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algovisual.AlgoDetails
import com.example.algovisual.DataInitializer
import com.example.algovisual.algorithms.BubbleSortAlgorithm
import com.example.algovisual.model.SortItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BubbleSortViewModel(
    val bubbleSortAlgorithm: BubbleSortAlgorithm = BubbleSortAlgorithm(),
    val dataInitializer: DataInitializer = DataInitializer(),
):ViewModel() {

    private val initialList = listOf<Int>(50,10,70,90,20,30,60,80,40)
    private val list = dataInitializer(initialList)
    private val _itemList = MutableStateFlow(list.toCollection(mutableListOf()))
    val details = AlgoDetails.BubbleSort

    private val _isNotSorting = MutableStateFlow(true)
    val isNotSorting = _isNotSorting.asStateFlow()

    private var _sortItems = MutableStateFlow(list.toCollection(mutableListOf()))
    val sortItems = _sortItems.asStateFlow()


    fun startSorting(){
        _isNotSorting.value=false
        viewModelScope.launch {
            bubbleSortAlgorithm(_itemList.value).collect{
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