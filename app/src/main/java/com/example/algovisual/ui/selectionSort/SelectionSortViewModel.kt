package com.example.algovisual.ui.selectionSort

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algovisual.algorithms.SelectionSortAlgorithm
import com.example.algovisual.model.SortItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SelectionSortViewModel(
    val selectionSortAlgorithm: SelectionSortAlgorithm = SelectionSortAlgorithm()
): ViewModel() {
    private val list = mutableListOf<SortItem>()

    init {
        list.add(SortItem(0,10,false,false, Color.Red))
        list.add(SortItem(1,80,false,false, Color.Red))
        list.add(SortItem(2,40,false,false, Color.Red))
        list.add(SortItem(3,30,false,false, Color.Red))
        list.add(SortItem(4,15,false,false, Color.Red))
    }

    private val _itemList = MutableStateFlow(list)
    val itemList = _itemList.asStateFlow()

    val lst = mutableListOf<SortItem>()
    private var _sortItems = MutableStateFlow(lst)
    val sortItems = _sortItems.asStateFlow()


    private val _abc = MutableStateFlow("Hi Its Starting")
    val abc = _abc.asStateFlow()

    fun startSorting(){
        viewModelScope.launch {
            selectionSortAlgorithm(_itemList.value).collect{
                _sortItems.value=it.toCollection(mutableListOf())
            }
        }
    }

    fun testing(){
        viewModelScope.launch {
//            delay(1000)
            Log.e("TAG", "startSorting: ${sortItems.value.toString()}")
            _abc.value="Hi Its Ending"

        }
    }
}