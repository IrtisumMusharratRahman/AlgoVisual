package com.example.algovisual

import androidx.compose.ui.graphics.Color
import com.example.algovisual.model.SortItem
import com.example.algovisual.ui.theme.*

class DataInitializer {
    operator fun invoke(initData:List<Int>):MutableList<SortItem>{
        val processedData = mutableListOf<SortItem>()
        val data = initData.sorted().toCollection(mutableListOf())
        for (i in 0 until initData.size){


            var colorIndex = -1
            for (j in 0 until data.size){
                if (data[j]==initData[i]){
                    colorIndex=j
                }
            }

            val id = i
            val value = initData[i]
            val isCurrentlyCompared = false
            val color =
                when(colorIndex){
                    0 -> index0
                    1 -> index1
                    2 -> index2
                    3 -> index3
                    4 -> index4
                    5 -> index5
                    6 -> index6
                    7 -> index7
                    8 -> index8
                    9 -> index9
                    else -> colorException
                }


            processedData.add(SortItem(id = id, value = value, isCurrentlyCompared = isCurrentlyCompared, color = color))
        }
        return processedData
    }
}