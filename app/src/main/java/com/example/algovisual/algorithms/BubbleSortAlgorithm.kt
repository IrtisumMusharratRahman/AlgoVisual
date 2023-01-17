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


        Log.e("TAG", "invoke: start")
        var lastItemToCompare = list.size-1
        while (lastItemToCompare>1){
            var i=0
            emit(list)

            while (i<lastItemToCompare){
                delay(500)
                if (list[i].value>list[i+1].value){
                    Log.e("TAG", "swap: ")
                    Collections.swap(list, i, i+1)
                    emit(list)

                }
                delay(500)
                i++
            }
            lastItemToCompare--

        }

        Log.e("TAG", "invoke: end")

    }
}
