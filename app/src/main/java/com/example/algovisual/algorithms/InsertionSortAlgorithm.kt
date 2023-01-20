package com.example.algovisual.algorithms

import android.util.Log
import com.example.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class InsertionSortAlgorithm {
    suspend operator fun invoke(list: MutableList<SortItem>): Flow<MutableList<SortItem>> = flow {

        val initial = list[0].copy()
        list[0]=SortItem(initial.id,initial.value,true,initial.color)
        emit(list)
        delay(1000)
        list[0]=SortItem(initial.id,initial.value,false,initial.color)
        emit(list)
        delay(500)

        for (i in 1..list.count() - 1){

            val item = list[i]
            var j = i

            val firstItem = list[i].copy()
            list[i]=SortItem(firstItem.id,firstItem.value,true,firstItem.color)
            emit(list)
            delay(1000)


            var secondItem = list[j-1].copy()
            list[j-1]=SortItem(secondItem.id,secondItem.value,true,secondItem.color)
            emit(list)
            delay(1000)

            while (j>0 && item.value < list[j-1].value){


                list[j] = list[j-1]
                list[j-1]=item
                val newFirstItemIndex = list.indexOfFirst {
                    it.id==firstItem.id
                }
                list[newFirstItemIndex]=SortItem(firstItem.id,firstItem.value,true,firstItem.color)
                emit(list)
                delay(1200)

                val newSecondItemIndex = list.indexOfFirst {
                    it.id==secondItem.id
                }
                list[newSecondItemIndex]=SortItem(secondItem.id,secondItem.value,false,secondItem.color)
                emit(list)
                delay(500)

                j -= 1
                if(j-1>=0){
                    secondItem = list[j-1].copy()
                    list[j-1]=SortItem(secondItem.id,secondItem.value,true,secondItem.color)
                    emit(list)
                    delay(1000)

                }
            }
//            list[j] = item
            val newSecondItemIndex = list.indexOfFirst {
                it.id==secondItem.id
            }
            list[newSecondItemIndex]=SortItem(secondItem.id,secondItem.value,false,secondItem.color)
            val newFirstItemIndex = list.indexOfFirst {
                it.id==firstItem.id
            }
            list[newFirstItemIndex]=SortItem(firstItem.id,firstItem.value,false,firstItem.color)
            emit(list)
            delay(500)

        }
        emit(list)

    }
}