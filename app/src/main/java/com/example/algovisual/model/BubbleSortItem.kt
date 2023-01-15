package com.example.algovisual.model

import androidx.compose.ui.graphics.Color

data class BubbleSortItem(
    var index:Int,
    val value: Int,
    var isCurrentlyCompared:Boolean,
    var isSorted:Boolean,
    val color: Color
)
