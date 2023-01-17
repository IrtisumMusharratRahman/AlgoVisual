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
        emit(list)
        delay(500)

        while(i<lastItemToCompare){
            var j=i+1
            while (j<list.size){
                if (list[i].value>list[j].value){
                    Collections.swap(list,i,j)
                    emit(list)
                    delay(5000)
                }
                j++
            }
            i++
        }

    }
}