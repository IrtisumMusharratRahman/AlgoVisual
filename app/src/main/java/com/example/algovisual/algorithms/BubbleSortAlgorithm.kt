package com.example.algovisual.algorithms

import android.util.Log
import java.util.*


class BubbleSortAlgorithm {
    operator fun invoke(list: List<Int>): List<Int>{
        var lastItemToCompare = list.size-1
        while (lastItemToCompare>1){
            var i=0

            while (i<lastItemToCompare){
                if (list[i]>list[i+1]){
                    Collections.swap(list, i, i+1)
                }
                i++
            }
            lastItemToCompare--

        }

        return list
    }
}