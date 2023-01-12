package com.example.algovisual.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.algovisual.ui.theme.BottomSheetBG
import com.example.algovisual.ui.theme.Teal200


@Composable
fun NavDrawerHeader() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f),
        color = BottomSheetBG
    ) {
        Text(text = "Algo Visual")
    }
}

@Composable
fun NavDrawerBody(onItemClicked:(algo:String)->Unit) {
    val algoNames = listOf<String>("Bubble Sort","Selection Sort","Insertion Sort")

    LazyColumn(
    ){
        items(
            items = algoNames,
            itemContent = {
                Text(
                    text = it,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(5.dp)
                        .clickable {
                            onItemClicked(it)
                        }
                )
            }
        )
    }


}

@Composable
fun DrawerItem(algoName:String) {
    Text(
        text = algoName,
        fontSize = 18.sp,
        modifier = Modifier.padding(5.dp)
    )
}