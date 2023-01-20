package com.example.algovisual.algorithms

import com.example.algovisual.model.MergeSortInfo
import com.example.algovisual.model.SortItem
import com.example.algovisual.model.SortStatue
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow

class MergeSortAlgorithm {

    val sortInfoFlow = MutableSharedFlow<MergeSortInfo>()

    suspend operator fun invoke(list: MutableList<SortItem>,depth:Int):MutableList<SortItem>{

        delay(500)
        sortInfoFlow.emit(MergeSortInfo(0,list,SortStatue.DIVIDED))

        val listSize = list.size
        if (listSize<=1){
            return list
        }

        var leftList = list.slice(0 until (listSize+1)/2)
        var rightList = list.slice((listSize+1)/2 until listSize)
        leftList=this(leftList.toMutableList(),depth+1)
        rightList=this(rightList.toMutableList(),depth+1)
        return merge(leftList.toMutableList(),rightList.toMutableList(),depth)
    }

    private suspend fun merge(
        leftList:MutableList<SortItem>,
        rightList:MutableList<SortItem>,
        depth: Int
    ):MutableList<SortItem>{

        val mergedList = mutableListOf<SortItem>()
        while (leftList.isNotEmpty() && rightList.isNotEmpty()){
            if (leftList.first().value <= rightList.first().value){
                mergedList.add(leftList.removeFirst())
            }else{
                mergedList.add(rightList.removeFirst())
            }
        }
        mergedList.addAll(leftList)
        mergedList.addAll(rightList)

        delay(500)
        sortInfoFlow.emit(MergeSortInfo(depth,mergedList,SortStatue.MERGED))

        return mergedList

    }

}