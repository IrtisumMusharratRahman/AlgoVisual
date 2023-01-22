package com.example.algovisual.ui.insertionSort

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
fun InsertionSortScreen(
    navController: NavController,
    insertionSortViewModel: InsertionSortViewModel= InsertionSortViewModel()
) {
    val sortItem = insertionSortViewModel.sortItems.collectAsState()
    val isNotSorting = insertionSortViewModel.isNotSorting.collectAsState()

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
            BottomSheet(algoDetails = insertionSortViewModel.details)
        }
    ) {
        CommonSortUI(
            sortItems = sortItem,
            isNotSorting = isNotSorting,
            onButtonClicked = {insertionSortViewModel.startSorting()},
            shuffle = {insertionSortViewModel.shuffle()},
            restart = {insertionSortViewModel.restart()},
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