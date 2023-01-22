package com.example.algovisual.model


data class MergeSortUIData(
    val id:String,
    val depth:Int,
    val sortStatue: SortStatue,
    val sortParts:List<MutableList<SortItem>>,
)
