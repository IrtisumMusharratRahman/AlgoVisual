package com.example.algovisual

import androidx.compose.ui.graphics.Color
import com.example.algovisual.model.SortItem

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
            val color = Color(
                when(colorIndex){
                    0 -> 0xFFE8F8F5
                    1 -> 0xFFD1F2EB
                    2 -> 0xFFA3E4D7
                    3 -> 0xFF76D7C4
                    4 -> 0xFF48C9B0
                    5 -> 0xFF1ABC9C
                    6 -> 0xFF17A589
                    7 -> 0xFF148F77
                    8 -> 0xFF117864
                    9 -> 0xFF0E6251
                    else -> 0xFFFFFFFF
                }
            )

            processedData.add(SortItem(id = id, value = value, isCurrentlyCompared = isCurrentlyCompared, color = color))
        }
        return processedData
    }
}