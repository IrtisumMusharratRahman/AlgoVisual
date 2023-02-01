package com.example.algovisual.algorithms.SimpleSort

import com.example.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class InsertionSortAlgorithm : SimpleSortAlgorithm {
    override suspend operator fun invoke(list: MutableList<SortItem>): Flow<MutableList<SortItem>> = flow {

        val initial = list[0].copy()
        list[0]=initial.copy(isCurrentlyCompared = true)
        emit(list)
        delay(1000)
        list[0]=initial.copy(isCurrentlyCompared = false)
        emit(list)
        delay(500)

        for (i in 1..list.count() - 1){

            val item = list[i]
            var j = i

            val firstItem = list[i].copy()
            list[i]=firstItem.copy(isCurrentlyCompared = true)
            emit(list)
            delay(1000)


            var secondItem = list[j-1].copy()
            list[j-1]=secondItem.copy(isCurrentlyCompared = true)
            emit(list)
            delay(1000)

            while (j>0 && item.value < list[j-1].value){


                list[j] = list[j-1]
                list[j-1]=item
                val newFirstItemIndex = list.indexOfFirst {
                    it.id==firstItem.id
                }
                list[newFirstItemIndex]=firstItem.copy(isCurrentlyCompared = true)
                emit(list)
                delay(1200)

                val newSecondItemIndex = list.indexOfFirst {
                    it.id==secondItem.id
                }
                list[newSecondItemIndex]=secondItem.copy(isCurrentlyCompared = false)
                emit(list)
                delay(500)

                j -= 1
                if(j-1>=0){
                    secondItem = list[j-1].copy()
                    list[j-1]=secondItem.copy(isCurrentlyCompared = true)
                    emit(list)
                    delay(1000)

                }
            }
            val newSecondItemIndex = list.indexOfFirst {
                it.id==secondItem.id
            }
            list[newSecondItemIndex]=secondItem.copy(isCurrentlyCompared = false)
            val newFirstItemIndex = list.indexOfFirst {
                it.id==firstItem.id
            }
            list[newFirstItemIndex]=firstItem.copy(isCurrentlyCompared = false)
            emit(list)
            delay(500)

        }
        emit(list)

    }
}