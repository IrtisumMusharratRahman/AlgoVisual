package com.example.algovisual.algorithms.SimpleSort

import com.example.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class BubbleSortAlgorithm : SimpleSortAlgorithm {
    override suspend operator fun invoke(list: MutableList<SortItem>):Flow<MutableList<SortItem>> = flow {

        for (i in 0 until list.size){
            for (j in 0 until list.size-1-i){

                val firstItem = list[j]
                val secondItem = list[j+1]
                list[j]=firstItem.copy(isCurrentlyCompared = true)
                list[j+1]=secondItem.copy(isCurrentlyCompared = true)
                emit(list)
                delay(1000)

                if (list[j].value>list[j+1].value){
                    val temp = list[j]
                    list[j]=list[j+1]
                    list[j+1]=temp
                    emit(list)
                    delay(1200)
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
