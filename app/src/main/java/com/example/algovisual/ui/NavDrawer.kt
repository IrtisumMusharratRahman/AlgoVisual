package com.example.algovisual.ui

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.algovisual.ui.theme.BottomSheetBG
import com.example.algovisual.ui.theme.Teal200
import com.example.algovisual.ui.theme.bg2


@Composable
fun NavDrawerHeader() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.2f)
        .background(bg2),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Algo Visual")
    }

}

@Composable
fun NavDrawerBody(onItemClicked:(algo:String)->Unit) {
    val algoNames = listOf<String>("Bubble Sort","Selection Sort","Insertion Sort")

    LazyColumn(
        modifier = Modifier
            .padding(15.dp)
    ){
        items(
            items = algoNames,
            itemContent = {
                Text(
                    text = it,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .background(color = bg2)
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