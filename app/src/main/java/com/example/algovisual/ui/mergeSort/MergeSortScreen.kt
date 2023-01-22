package com.example.algovisual.ui.mergeSort
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.algovisual.R
import com.example.algovisual.ui.reusedUI.BottomSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MergeSortScreen(
    navController: NavController,
    mergeSortViewModel: MergeSortViewModel = MergeSortViewModel()
) {

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
            BottomSheet(algoDetails = mergeSortViewModel.details)
        }
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ){
            IconButton(
                modifier = Modifier.align(Alignment.TopEnd),
                onClick = {
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
            ) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_read_more_24),
                    contentDescription = null
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.padding(top = 40.dp, bottom = 5.dp)
                ) {
                    for (item in mergeSortViewModel.list){
                        Text(
                            text = "${item.value}",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 22.sp,
                            modifier = Modifier
                                .background(color = item.color)
                                .padding(3.dp)
                        )
                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    itemsIndexed(
                        mergeSortViewModel.sortUIData,
                        key = { _, it ->
                            it.id
                        }
                    ){ index, it ->
                        val depthParts = it.sortParts
                        if(index == 0){
                            Text(
                                "Dividing",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 22.sp,
                                modifier = Modifier
                                    .padding(bottom = 20.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                        }
                        if(index == 4){
                            Text(
                                "Merging",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 22.sp,
                                modifier = Modifier
                                    .padding(bottom = 20.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ){
                            for(part in depthParts){
                                Row(
                                    modifier = Modifier
                                        .padding(start = if (depthParts.indexOf(part) == 0) 0.dp else 5.dp)
                                        .padding(3.dp)

                                ){
                                    for(numberInformation in part){
                                        if (part.indexOf(numberInformation) != part.size-1){
                                            Text(
                                                "${numberInformation.value}",
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Black,
                                                fontSize = 21.sp,
                                                modifier = Modifier
                                                    .background(color = numberInformation.color)
                                                    .padding(3.dp)
                                            )
                                        }else{
                                            Text(
                                                "${numberInformation.value}",
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Black,
                                                fontSize = 21.sp,
                                                modifier = Modifier
                                                    .background(color = numberInformation.color)
                                                    .padding(3.dp)
                                            )
                                        }

                                    }
                                }
                            }
                        }

                    }
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .align(Alignment.BottomCenter),
                shape = CircleShape,

                onClick = { mergeSortViewModel.startSorting() }
            ) {
                Text(
                    text = "Start Sorting",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }

        }
    }

}
