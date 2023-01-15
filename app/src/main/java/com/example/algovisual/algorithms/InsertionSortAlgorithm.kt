package com.example.algovisual.algorithms

import android.util.Log
import java.util.*

class InsertionSortAlgorithm {
    operator fun invoke(list: MutableList<Int>): List<Int>{

        for (i in 1..list.count() - 1){

            val item = list[i]
            var j = i
            while (j>0 && item < list[j - 1]){
                list[j] = list[j - 1]
                j -= 1
            }
            list[j] = item
        }

        return list
    }
}