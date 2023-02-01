package com.example.algovisual.algorithms.SimpleSort

import com.example.algovisual.model.SortItem
import kotlinx.coroutines.flow.Flow

interface SimpleSortAlgorithm {
    suspend operator fun invoke(list: MutableList<SortItem>): Flow<MutableList<SortItem>>
}