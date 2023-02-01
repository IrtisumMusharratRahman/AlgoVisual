package com.example.algovisual.ui.mergeSort

import com.example.algovisual.model.SortItem
import com.example.algovisual.model.SortStatue


data class MergeSortUIData(
    val id:String,
    val depth:Int,
    val sortStatue: SortStatue,
    val sortParts:List<MutableList<SortItem>>,
)
