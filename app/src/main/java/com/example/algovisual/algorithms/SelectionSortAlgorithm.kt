package com.example.algovisual.algorithms

import android.util.Log
import java.util.*

class SelectionSortAlgorithm {
    operator fun invoke(list: MutableList<Int>): List<Int>{

        var i=0
        val lastItemToCompare = list.size-1

        while(i<lastItemToCompare){
            var j=i+1
            while (j<list.size){
                if (list[i]>list[j]){
                    Collections.swap(list,i,j)
                }
                j++
            }
            i++
        }

        return list
    }
}