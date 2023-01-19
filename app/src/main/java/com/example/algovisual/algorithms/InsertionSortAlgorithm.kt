package com.example.algovisual.algorithms

import android.util.Log
import com.example.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class InsertionSortAlgorithm {
    suspend operator fun invoke(list: MutableList<SortItem>): Flow<MutableList<SortItem>> = flow {

        for (i in 1..list.count() - 1){

            val item = list[i]
            var j = i

            while (j>0 && item.value < list[j-1].value){

                emit(list)
                delay(1500)

                list[j] = list[j-1]
                list[j-1]=item


                j -= 1
            }
            list[j] = item
            emit(list)
            delay(1500)
        }
        emit(list)

    }
}