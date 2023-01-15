package com.example.algovisual.algorithms

import android.util.Log
import com.example.algovisual.model.BubbleSortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import java.util.*


class BubbleSortAlgorithm {
    suspend operator fun invoke(list: StateFlow<MutableList<BubbleSortItem>>){


        Log.e("TAG", "invoke: start")
        var lastItemToCompare = list.value.size-1
        while (lastItemToCompare>1){
            var i=0

            while (i<lastItemToCompare){
                delay(500)
                if (list.value[i].value>list.value[i+1].value){
                    Log.e("TAG", "swap: ")
                    list.value[i].index=i+1
                    list.value[i+1].index=i
                    Collections.swap(list.value, i, i+1)

                }
                delay(500)
                i++
            }
            lastItemToCompare--

        }

        Log.e("TAG", "invoke: end")

    }
}
