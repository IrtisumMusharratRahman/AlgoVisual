package com.example.algovisual.ui

import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.algovisual.model.SortItem
import com.example.algovisual.ui.theme.Shapes
import java.lang.Float

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SimpleSortUI(
    sortItems: State<MutableList<SortItem>>,
    onButtonClicked:()->Unit
) {
    val state = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier.padding(top = 10.dp, bottom = 5.dp)
            ){
                items(
                    items=sortItems.value,
                ){
                    val borderStroke = if (it.isSorted){
                        BorderStroke(3.dp, Color.Green)
                    }else if (it.isCurrentlyCompared){
                        BorderStroke(3.dp, Color.Red)
                    }else{
                        BorderStroke(0.dp, Color.Transparent)
                    }
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .padding(5.dp)
                            .background(color = it.color, shape = Shapes.large)
                            .border(border = borderStroke, shape = Shapes.large)
                            .animateItemPlacement(
                                animationSpec = tween(300)
                            ),
                        contentAlignment = Alignment.Center,
                    ){
                        Text(text = "${it.value}",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp,
                            color = Color.Black
                        )
                    }
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 15.dp),
                shape = CircleShape,
                onClick = { onButtonClicked() }
            ) {
                Text(text = "Start Sorting", fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
            }

        }
    }

}