package com.example.algovisual.algorithms

import android.util.Log
import com.example.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import java.util.*


class BubbleSortAlgorithm {
    suspend operator fun invoke(list: MutableList<SortItem>):Flow<MutableList<SortItem>> = flow {


        var lastItemToCompare = list.size-1
        while (lastItemToCompare>1){
            var i=0

            while (i<lastItemToCompare){

                list[i].isCurrentlyCompared=true
                emit(list)
                delay(500)
                list[i+1].isCurrentlyCompared=true
                emit(list)
                delay(1000)

                if (list[i].value>list[i+1].value){
                    Collections.swap(list, i, i+1)
                    emit(list)
                    delay(1000)
                }
                list[i].isCurrentlyCompared=false
                list[i+1].isCurrentlyCompared=false
                i++
            }
            list[lastItemToCompare].isSorted=true
            emit(list)
            delay(500)
            lastItemToCompare--

        }
        emit(list)
    }
}
