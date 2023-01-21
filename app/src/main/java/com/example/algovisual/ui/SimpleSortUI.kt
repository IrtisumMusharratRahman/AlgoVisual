package com.example.algovisual.ui

import android.widget.RelativeLayout
import androidx.compose.animation.animateColorAsState
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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.PathNode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.algovisual.R
import com.example.algovisual.model.SortItem
import com.example.algovisual.ui.theme.Shapes


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SimpleSortUI(
    sortItems: State<MutableList<SortItem>>,
    isNotSorting: State<Boolean>,
    advancedSortItems:State<MutableList<SortItem>> = mutableStateOf(mutableListOf()),
    onButtonClicked: () -> Unit,
    shuffle: () -> Unit,
) {
    val defaultColor = Color.Transparent
    val comparedColor = Color.Red
    val pivotColor = Color.Green

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.TopEnd),
            enabled = isNotSorting.value,
            onClick = { shuffle() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_shuffle_24),
                contentDescription = null
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 5.dp)
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                items(
                    items = sortItems.value, key = { it.id }
                ) {
                    val endColor = if (it.isPivot) pivotColor else comparedColor
                    val borderColor by animateColorAsState(if (it.isCurrentlyCompared) endColor else defaultColor)

                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .padding(5.dp)
                            .background(color = it.color, shape = Shapes.large)
                            .border(width = 3.dp, color = borderColor, shape = Shapes.large)
                            .animateItemPlacement(
                                animationSpec = tween(1000)
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "${it.value}",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp,
                            color = Color.Black
                        )
                    }
                }
            }
            Button(
                enabled = isNotSorting.value,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 15.dp),
                shape = CircleShape,
                onClick = { onButtonClicked() }
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

@Composable
fun ttt() {

}