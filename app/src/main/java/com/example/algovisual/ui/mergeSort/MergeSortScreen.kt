package com.example.algovisual.ui.mergeSort

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.algovisual.model.MergeSortUIData
import com.example.algovisual.model.SortItem
import com.example.algovisual.ui.insertionSort.InsertionSortViewModel
import com.example.algovisual.ui.theme.ContainerBg

@Composable
fun MergeSortScreen(
    navController: NavController,
    mergeSortViewModel: MergeSortViewModel = MergeSortViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            itemsIndexed(
                mergeSortViewModel.sortUIData,
                key = { _, it ->
                    it.id
                }
            ){ index, it ->
                val depthParts = it.sortParts.map { it.map { it.value } }
                if(index == 0){
                    Text(
                        "Dividing",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 26.sp,
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
                        fontSize = 26.sp,
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
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            modifier = Modifier
                                .padding(start = if (depthParts.indexOf(part) == 0) 0.dp else 12.dp)
                                .background(it.color, RoundedCornerShape(10.dp))
                                .padding(5.dp)

                        ){
                            for(numberInformation in part){
                                if (part.indexOf(numberInformation) != part.size-1){
                                    Text(
                                        "$numberInformation |",
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        fontSize = 16.sp
                                    )
                                }else{
                                    Text(
                                        "$numberInformation",
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        fontSize = 16.sp
                                    )
                                }

                            }
                        }
                    }
                }

            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            Text(
                "${mergeSortViewModel.list.map { it.value }}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Button(
                onClick = {
                    mergeSortViewModel.startSorting()
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(CircleShape)
            ){
                Text(
                    "Start sort",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }




}
