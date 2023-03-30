package com.project.algovisual.ui.mergeSort

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.algovisual.algorithms.AlgoDetails
import com.project.algovisual.DataInitializer
import com.project.algovisual.algorithms.AdvancedSort.MergeSortAlgorithm
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class MergeSortViewModel(
    val mergeSortAlgorithm: MergeSortAlgorithm = MergeSortAlgorithm(),
    val dataInitializer: DataInitializer = DataInitializer()
):ViewModel() {

    private val initialList = listOf<Int>(10,50,70,90,20,30,60,80,40)
    var initializedLit = dataInitializer(initialList)
    init {
        initializedLit.removeAt(0)
    }
    var list = initializedLit.toCollection(mutableListOf())
    var sortUIData = mutableStateListOf<MergeSortUIData>()
    private var job:Job?=null
    private var status = true

    val details = AlgoDetails.MergeSort

    private val _itemList = MutableStateFlow(list.toCollection(mutableListOf()))

    fun startSorting(){

        if (status){

            sortUIData.clear()
            _itemList.value=list.toCollection(mutableListOf())

            viewModelScope.launch {
                mergeSortAlgorithm(_itemList.value, 0)
            }.runCatching {
                if (this.isActive){
                    status=false
                }
                this.invokeOnCompletion { status=true}
            }
        }


        dataCollection()
    }


    fun dataCollection(){
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