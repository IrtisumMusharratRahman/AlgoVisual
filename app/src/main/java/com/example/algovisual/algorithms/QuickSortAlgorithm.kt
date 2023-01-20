package com.example.algovisual.algorithms

import android.util.Log
import com.example.algovisual.model.MergeSortInfo
import com.example.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow

class QuickSortAlgorithm {

    val sortInfoFlow = MutableSharedFlow<MutableList<SortItem>>()

    suspend operator fun invoke(list: MutableList<SortItem>, low:Int,high:Int){

        if (low<high){
            val cut = partition(list,low,high)
            this(list, low, cut - 1)
            this(list, cut + 1, high)
        }

        sortInfoFlow.emit(list)
        delay(200)
//        Log.e("TAG", "invoke: ${list.toString()}")
    }


    private suspend fun partition(list: MutableList<SortItem>, low: Int, high: Int): Int {

        val pivotIndex = high
        val pivot = list[pivotIndex]
        Log.e("TAG", "partition: ${pivot.value}")
        var i = low-1

        list[pivotIndex]=SortItem(pivot.id,pivot.value,true,pivot.color)

        sortInfoFlow.emit(list)
        delay(1000)

        for (j in low until high){
            if (list[j].value<=pivot.value){
                i++
                val temp = list[i]
                list[i]=list[j]
                list[j]=temp
            }
            sortInfoFlow.emit(list)
            delay(1100)
        }
        val temp = list[i+1]
        list[i+1]=list[high]
        list[high]=temp

        val newPivotIndex = list.indexOfFirst {
            it.id==pivot.id
        }
        list[newPivotIndex]=SortItem(pivot.id,pivot.value,false,pivot.color)

        return i+1
    }
}