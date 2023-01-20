package com.example.algovisual.ui.mergeSort

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algovisual.DataInitializer
import com.example.algovisual.algorithms.MergeSortAlgorithm
import com.example.algovisual.model.MergeSortUIData
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.UUID

class MergeSortViewModel(
    val mergeSortAlgorithm: MergeSortAlgorithm = MergeSortAlgorithm(),
    val dataInitializer: DataInitializer = DataInitializer()
):ViewModel() {

    private val initialList = listOf<Int>(40,70,30,10,20,80,50,90,60)

    var list = dataInitializer(initialList)
    var sortUIData = mutableStateListOf<MergeSortUIData>()
    private var job:Job?=null

    fun startSorting(){
        sortUIData.clear()
        viewModelScope.launch {
            mergeSortAlgorithm(list,0)
        }
        job?.cancel()
        job=viewModelScope.launch {
            mergeSortAlgorithm.sortInfoFlow.collect{mergeSortInfo->
                val existeddepthIndex = sortUIData.indexOfFirst {
                    it.depth==mergeSortInfo.depth && it.sortStatue==mergeSortInfo.sortState
                }

                if(existeddepthIndex==-1){
                    sortUIData.add(
                        MergeSortUIData(
                            id=UUID.randomUUID().toString(),
                            depth = mergeSortInfo.depth,
                            sortParts = listOf(mergeSortInfo.sortParts),
                            sortStatue = mergeSortInfo.sortState,
                            color = Color(
                                (0..255).random(),
                                (0..255).random(),
                                (0..255).random()
                            )
                        )
                    )
                }else{
                    val currentList = sortUIData[existeddepthIndex].sortParts.toMutableList()
                    currentList.add(mergeSortInfo.sortParts)
                    sortUIData[existeddepthIndex]=sortUIData[existeddepthIndex].copy(sortParts = currentList)
                }

                sortUIData.sortedWith(
                    compareBy(
                        {
                            it.sortStatue
                        },
                        {
                            it.depth
                        }
                    )
                )
            }
        }
    }



}