package com.project.algovisual.model

import androidx.compose.ui.graphics.Color

data class SortItem(
    var id:Int,
    val value: Int,
    var isCurrentlyCompared:Boolean,
    val color: Color,
    var isPivot:Boolean=false,
    var alreadyVisited:Boolean=false
)
