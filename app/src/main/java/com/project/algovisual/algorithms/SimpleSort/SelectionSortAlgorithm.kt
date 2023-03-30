package com.project.algovisual.algorithms.SimpleSort

import com.project.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SelectionSortAlgorithm : SimpleSortAlgorithm {
    override suspend operator fun invoke(list: MutableList<SortItem>): Flow<MutableList<SortItem>> = flow {

        for (i in 0 until list.size-1){
            for (j in i+1 until list.size){

                val firstItem = list[i]
                val secondItem = list[j]
                list[i]=firstItem.copy(isCurrentlyCompared = true)
                list[j]=secondItem.copy(isCurrentlyCompared = true)
                emit(list)
                delay(1000)

                if(list[i].value>list[j].value){
                    val temp = list[i]
                    list[i]=list[j]
                    list[j]=temp
                    emit(list)
                    delay(1500)
                }
                val newFirstItemIndex = list.indexOfFirst {
                    it.id==firstItem.id
                }
                val newSecondItemIndex = list.indexOfFirst {
                    it.id==secondItem.id
                }
                list[newFirstItemIndex]=firstItem.copy(isCurrentlyCompared = false)
                list[newSecondItemIndex]=secondItem.copy(isCurrentlyCompared = false)
                emit(list)
                delay(500)

            }
        }
        emit(list)
    }
}