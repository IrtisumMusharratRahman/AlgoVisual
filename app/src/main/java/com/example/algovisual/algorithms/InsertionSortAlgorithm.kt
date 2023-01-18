package com.example.algovisual.algorithms

import android.util.Log
import com.example.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class InsertionSortAlgorithm {
    suspend operator fun invoke(list: MutableList<SortItem>): Flow<MutableList<SortItem>> = flow {

//        list[0].isSorted=true

        for (i in 1..list.count() - 1){

            val item = list[i]
            var j = i

            while (j>0 && item.value < list[j-1].value){

                list[j].isCurrentlyCompared=true
                list[j-1].isCurrentlyCompared=true
                emit(list)
                delay(500)

                list[j] = list[j-1]
                list[j-1]=item

                emit(list)
                delay(500)
                list[j].isCurrentlyCompared=false
                list[j-1].isCurrentlyCompared=false

                j -= 1
            }
            list[j] = item
//            list[i].isSorted=true
            emit(list)
            delay(500)
        }
        emit(list)

    }
}