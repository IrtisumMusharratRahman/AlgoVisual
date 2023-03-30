package com.project.algovisual.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.algovisual.R
import com.project.algovisual.model.SortItem
import com.project.algovisual.ui.theme.*


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CommonSortUI(
    sortItems: State<MutableList<SortItem>>,
    isNotSorting: State<Boolean>,
    onButtonClicked: () -> Unit,
    shuffle: () -> Unit,
    restart: () -> Unit,
    bottomSheet: () -> Unit
) {
    var borderColor:Color

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = { bottomSheet() }
        ) {
            Icon(
                modifier = Modifier.size(35.dp),
                painter = painterResource(id = R.drawable.ic_baseline_read_more_24),
                contentDescription = null
            )
        }
        Column(
            modifier= Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 0.dp)
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                items(
                    items = sortItems.value, key = { it.id }
                ) {
                    val bColor by animateColorAsState(if (it.isCurrentlyCompared) comparedColor else defaultColor)

                    borderColor = if (it.alreadyVisited){
                        alreadyCompared
                    }else{
                        bColor
                    }

                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .padding(5.dp)
                            .background(
                                color = if (it.isPivot) pivotColor else it.color,
                                shape = Shapes.medium
                            )
                            .border(width = 3.dp, color = borderColor, shape = Shapes.medium)
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    enabled = isNotSorting.value,
                    onClick = { shuffle() }
                ) {
                    Icon(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_shuffle_24),
                        contentDescription = null
                    )
                }
                Button(
                    enabled = isNotSorting.value,
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
                IconButton(
                    enabled = isNotSorting.value,
                    onClick = { restart() }
                ) {
                    Icon(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_refresh_24),
                        contentDescription = null
                    )
                }

            }
        }

    }

}