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


        //i=0;i<size;i++
        for (i in 0 until list.size){
            for (j in 0 until list.size-1-i){
                emit(list)
                delay(1500)
                if (list[j].value>list[j+1].value){
                    val temp = list[j]
                    list[j]=list[j+1]
                    list[j+1]=temp
                }
            }
        }
        emit(list)

    }
}
