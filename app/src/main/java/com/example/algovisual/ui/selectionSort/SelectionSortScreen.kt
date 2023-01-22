package com.example.algovisual.ui.selectionSort

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
fun SelectionSortScreen(
    navController: NavController,
    selectionSortViewModel: SelectionSortViewModel = SelectionSortViewModel()
) {
    val sortItem = selectionSortViewModel.sortItems.collectAsState()
    val isNotSorting = selectionSortViewModel.isNotSorting.collectAsState()

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
            BottomSheet(algoDetails = selectionSortViewModel.details)
        }
    ) {
        CommonSortUI(
            sortItems = sortItem,
            isNotSorting = isNotSorting,
            onButtonClicked = {selectionSortViewModel.startSorting()},
            shuffle = {selectionSortViewModel.shuffle()},
            restart = {selectionSortViewModel.restart()},
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