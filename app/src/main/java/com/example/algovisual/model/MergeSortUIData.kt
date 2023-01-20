package com.example.algovisual.model

import androidx.compose.ui.graphics.Color

data class MergeSortUIData(
    val id:String,
    val depth:Int,
    val sortStatue: SortStatue,
    val sortParts:List<MutableList<SortItem>>,
    val color: Color
)
