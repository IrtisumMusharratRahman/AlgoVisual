package com.example.algovisual.ui.bubbleSort

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algovisual.algorithms.BubbleSortAlgorithm
import com.example.algovisual.model.BubbleSortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BubbleSortViewModel(
    val bubbleSortAlgorithm: BubbleSortAlgorithm = BubbleSortAlgorithm()
):ViewModel() {


    val list = mutableListOf<BubbleSortItem>()

    init {
        list.add(BubbleSortItem(0,10,false,false, Color.Red))
        list.add(BubbleSortItem(1,80,false,false, Color.Red))
        list.add(BubbleSortItem(2,40,false,false, Color.Red))
        list.add(BubbleSortItem(3,30,false,false, Color.Red))
        list.add(BubbleSortItem(4,15,false,false, Color.Red))
    }

    private val _itemList = MutableStateFlow(list)
    val itemList = _itemList.asStateFlow()

    private val _abc = MutableStateFlow("Hi Its Starting")
    val abc = _abc.asStateFlow()

    fun startSorting(){
        viewModelScope.launch {
            Log.e("TAG", "startSorting: start")
            bubbleSortAlgorithm(itemList)
            Log.e("TAG", "startSorting: end")
        }
    }

    fun testing(){
        viewModelScope.launch {
//            delay(1000)
            Log.e("TAG", "startSorting: end")
            _abc.value="Hi Its Ending"
        }
    }





}