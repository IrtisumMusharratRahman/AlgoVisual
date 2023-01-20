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

                val firstItem = list[j]
                val secondItem = list[j+1]
                list[j]=SortItem(firstItem.id,firstItem.value,true,firstItem.color)
                list[j+1]=SortItem(secondItem.id,secondItem.value,true,secondItem.color)
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
                list[newFirstItemIndex]=SortItem(firstItem.id,firstItem.value,false,firstItem.color)
                list[newSecondItemIndex]=SortItem(secondItem.id,secondItem.value,false,secondItem.color)
                emit(list)
                delay(500)

            }

        }
        emit(list)

    }
}
