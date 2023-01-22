package com.example.algovisual.ui.bubbleSort


import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.algovisual.ui.CommonSortUI
import com.example.algovisual.ui.reusedUI.BottomSheet
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BubbleSortScreen(
    navController: NavController,
    bubbleSortViewModel: BubbleSortViewModel = viewModel()
) {
    val sortItem = bubbleSortViewModel.sortItems.collectAsState()
    val isNotSorting = bubbleSortViewModel.isNotSorting.collectAsState()

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
            BottomSheet(algoDetails = bubbleSortViewModel.details)
        }
    ) {
        CommonSortUI(
            sortItems = sortItem,
            isNotSorting = isNotSorting,
            onButtonClicked = {bubbleSortViewModel.startSorting()},
            shuffle = {bubbleSortViewModel.shuffle()},
            restart = {bubbleSortViewModel.restart()},
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