package com.example.algovisual.model

data class MergeSortInfo(
    val depth: Int,
    val sortParts:MutableList<SortItem>,
    val sortState:SortStatue
)

enum class SortStatue(val value:Int){
    DIVIDED(0),
    MERGED(1)
}
