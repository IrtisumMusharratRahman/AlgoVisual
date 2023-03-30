package com.project.algovisual.ui.reusedUI

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.algovisual.algorithms.AlgoDetails
import com.project.algovisual.ui.theme.BottomSheetBG
import com.project.algovisual.ui.theme.ContainerBg
import com.project.algovisual.ui.theme.Shapes

@Composable
fun BottomSheet(algoDetails: AlgoDetails) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .background(color = BottomSheetBG, shape = Shapes.medium)
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.45f)
            .padding(0.dp)
            .padding(10.dp)
            .border(width = 3.dp, color = MaterialTheme.colors.background, shape = Shapes.medium)
    ) {
        Box(
            modifier = Modifier
                .background(color = ContainerBg, shape = Shapes.medium)
                .fillMaxSize()
                .padding(0.dp)
                .padding(vertical = 30.dp, horizontal = 40.dp)

        ) {
            Column() {
                Text(
                    text = "Time Complexity:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp)
                )
                Text(
                    text = "Best Case: ${algoDetails.bestCase}",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    modifier = Modifier.padding(3.dp)
                )
                Text(
                    text = "Worst Case: ${algoDetails.worstCase}",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    modifier = Modifier.padding(3.dp)
                )
                Text(
                    text = "Average Case: ${algoDetails.avarageCase}",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    modifier = Modifier.padding(3.dp)
                )
                Text(
                    text = "Space Complexity: ${algoDetails.spaceComplexity}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)
                )
                Text(
                    text = "Stability: ${algoDetails.stability}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)
                )

            }
        }


    }
}