package com.example.algovisual.algorithms

import android.util.Log
import com.example.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class InsertionSortAlgorithm {
    suspend operator fun invoke(list: MutableList<SortItem>): Flow<MutableList<SortItem>> = flow {

        emit(list)
        delay(5000)
        for (i in 1..list.count() - 1){

            val item = list[i]
            var j = i

            while (j>0 && item.value < list[j-1].value){
                list[j] = list[j-1]
                j -= 1
                emit(list)
                delay(5000)
            }
            list[j] = item
            emit(list)
            delay(5000)
        }

    }
}