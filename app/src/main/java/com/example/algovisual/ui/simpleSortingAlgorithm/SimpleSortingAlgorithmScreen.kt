package com.example.algovisual.ui.simpleSortingAlgorithm

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.algovisual.ui.CommonSortUI
import com.example.algovisual.ui.reusedUI.BottomSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SimpleSortingAlgorithmScreen(
    navController: NavController,
    sortViewModel: SimpleSortingAlgorithmViewModel
) {
    val sortItem = sortViewModel.sortItems.collectAsState()
    val isNotSorting = sortViewModel.isNotSorting.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(
            initialValue = BottomSheetValue.Collapsed,
        )
    )

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContent = {
            BottomSheet(algoDetails = sortViewModel.details)
        }
    ) {
        CommonSortUI(
            sortItems = sortItem,
            isNotSorting = isNotSorting,
            onButtonClicked = {sortViewModel.startSorting()},
            shuffle = {sortViewModel.shuffle()},
            restart = {sortViewModel.restart()},
            bottomSheet = {
                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed){
                    coroutineScope.launch {
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    }
                }
                if (bottomSheetScaffoldState.bottomSheetState.isExpanded){
                    coroutineScope.launch {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }
            }
        )
    }

}