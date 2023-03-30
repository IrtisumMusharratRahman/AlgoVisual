package com.project.algovisual.ui.mergeSort

import com.project.algovisual.model.SortItem
import com.project.algovisual.model.SortStatue


data class MergeSortUIData(
    val id:String,
    val depth:Int,
    val sortStatue: SortStatue,
    val sortParts:List<MutableList<SortItem>>,
)
