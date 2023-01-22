package com.example.algovisual.ui.quickSort

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
fun QuickSortScreen(
    navController: NavController,
    quickSortSViewModel: QuickSortSViewModel = viewModel()
) {
    val sortItem = quickSortSViewModel.sortItems.collectAsState()
    val isNotSorting = quickSortSViewModel.isNotSorting.collectAsState()

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
            BottomSheet(algoDetails = quickSortSViewModel.details)
        }
    ) {
        CommonSortUI(
            sortItems = sortItem,
            isNotSorting = isNotSorting,
            onButtonClicked = {quickSortSViewModel.startSorting()},
            shuffle = {quickSortSViewModel.shuffle()},
            restart = {quickSortSViewModel.restart()},
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