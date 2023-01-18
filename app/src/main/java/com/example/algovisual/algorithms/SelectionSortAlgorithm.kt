package com.example.algovisual.algorithms

import com.example.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class SelectionSortAlgorithm {
    suspend operator fun invoke(list: MutableList<SortItem>): Flow<MutableList<SortItem>> = flow {

        var i=0
        val lastItemToCompare = list.size-1

        while(i<lastItemToCompare){

            list[i].isCurrentlyCompared=true
            emit(list)
            delay(500)

            var j=i+1
            while (j<list.size){
                list[j].isCurrentlyCompared=true
                emit(list)
                delay(500)
                if (list[i].value>list[j].value){
                    Collections.swap(list,i,j)
                    emit(list)
                    delay(500)
                }
                list[j].isCurrentlyCompared=false
                j++
            }
            list[i].isCurrentlyCompared=false
            list[i].isSorted=true
            i++
        }
        emit(list)

    }
}