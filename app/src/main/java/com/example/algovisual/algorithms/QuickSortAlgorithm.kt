package com.example.algovisual.algorithms

import android.util.Log
import com.example.algovisual.model.MergeSortInfo
import com.example.algovisual.model.SortItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import java.util.Collections

class QuickSortAlgorithm {

    val sortInfoFlow = MutableSharedFlow<MutableList<SortItem>>()

    suspend operator fun invoke(list: MutableList<SortItem>, low:Int,high:Int){

        if (low<high){
            val cut = part(list,low,high)
            this(list, low, cut - 1)
            this(list, cut + 1, high)
        }

        sortInfoFlow.emit(list)
        delay(200)
//        Log.e("TAG", "invoke: ${list.toString()}")
    }


    private suspend fun part(list: MutableList<SortItem>, low: Int, high: Int):Int{
        val pivot = list[low].copy()

        list[low]=pivot.copy(isPivot = true)
        sortInfoFlow.emit(list)
        delay(1000)


        var cnt = 0
        for (i in low+1 .. high){
            if (list[i].value<=pivot.value){
                cnt++
            }
        }

        val pivotIndex = low+cnt
        val temp = list[pivotIndex]
        list[pivotIndex]=list[low]
        list[low]=temp

        sortInfoFlow.emit(list)
        delay(1200)

        var i = low
        var j = high

        var firstHalf = list[i]
        var secondHalf = list[j]
        list[i]=firstHalf.copy(isCurrentlyCompared = true)
        list[j]=secondHalf.copy(isCurrentlyCompared = true)
        sortInfoFlow.emit(list)
        delay(1000)


        while (i<pivotIndex&&j>pivotIndex){
            while (list[i].value<pivot.value){

                val newfirstHalfIndex = list.indexOfFirst {
                    it.id==firstHalf.id
                }
                list[newfirstHalfIndex]=firstHalf.copy(isCurrentlyCompared = false)
                sortInfoFlow.emit(list)
                delay(500)

                i++

                firstHalf = list[i].copy()
                list[i]=firstHalf.copy(isCurrentlyCompared = true)
                sortInfoFlow.emit(list)
                delay(1000)

            }
            while (list[j].value>pivot.value){
                val newsecondtHalfIndex = list.indexOfFirst {
                    it.id==secondHalf.id
                }
                list[newsecondtHalfIndex]=secondHalf.copy(isCurrentlyCompared = false)
                sortInfoFlow.emit(list)
                delay(500)

                j--

                secondHalf = list[j].copy()
                list[j]=secondHalf.copy(isCurrentlyCompared = true)
                sortInfoFlow.emit(list)
                delay(1000)
            }
            if (i<pivotIndex && j>pivotIndex){
                val temp = list[i]
                list[i]=list[j]
                list[j]=temp
                sortInfoFlow.emit(list)
                delay(1200)

                val newfirstHalfIndex = list.indexOfFirst {
                    it.id==firstHalf.id
                }
                list[newfirstHalfIndex]=firstHalf.copy(isCurrentlyCompared = false)
                val newsecondtHalfIndex = list.indexOfFirst {
                    it.id==secondHalf.id
                }
                list[newsecondtHalfIndex]=secondHalf.copy(isCurrentlyCompared = false)
                sortInfoFlow.emit(list)
                delay(500)

                i++
                j--

                firstHalf = list[i].copy()
                list[i]=firstHalf.copy(isCurrentlyCompared = true)
                secondHalf = list[j].copy()
                list[j]=secondHalf.copy(isCurrentlyCompared = true)
                sortInfoFlow.emit(list)
                delay(1000)
            }
        }
        val newfirstHalfIndex = list.indexOfFirst {
            it.id==firstHalf.id
        }
        list[newfirstHalfIndex]=firstHalf.copy(isCurrentlyCompared = false)
        val newsecondtHalfIndex = list.indexOfFirst {
            it.id==secondHalf.id
        }
        list[newsecondtHalfIndex]=secondHalf.copy(isCurrentlyCompared = false)
        val newPivotIndex = list.indexOfFirst {
            it.id==pivot.id
        }
        list[newPivotIndex]=pivot.copy(isPivot = false)
        sortInfoFlow.emit(list)
        delay(500)

        return pivotIndex

    }

}