package com.example.algovisual.algorithms

import com.example.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class SelectionSortAlgorithm {
    suspend operator fun invoke(list: MutableList<SortItem>): Flow<MutableList<SortItem>> = flow {

        for (i in 0 until list.size-1){
            for (j in i+1 until list.size){
                emit(list)
                delay(600)
                if(list[i].value>list[j].value){
                    val temp = list[i]
                    list[i]=list[j]
                    list[j]=temp
                    emit(list)
                    delay(1500)
                }
            }
        }
        emit(list)
    }
}