package com.example.algovisual.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.algovisual.ui.theme.*


@Composable
fun NavDrawerHeader() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.3f)
        .background(bg2),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = com.example.algovisual.R.drawable.applogo),
            contentScale = ContentScale.FillWidth,
            contentDescription = null)
    }

}

@Composable
fun NavDrawerBody(
    currentPage:String,
    onItemClicked:(algo:String)->Unit
) {
    val context = LocalContext.current
    val algoNames = listOf<String>(
        context.getString(com.example.algovisual.R.string.bubble_sort),
        context.getString(com.example.algovisual.R.string.selection_sort),
        context.getString(com.example.algovisual.R.string.insertion_sort),
        context.getString(com.example.algovisual.R.string.merge_sort),
        context.getString(com.example.algovisual.R.string.quick_sort)
    )
    var pageName = remember {
        mutableStateOf("")
    }
    pageName.value=currentPage
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = primary)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(vertical = 20.dp),
        ){
            items(
                items = algoNames,
                itemContent = {
                    val backGround = if (pageName.value.equals(it)) ContainerBg else primary

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(backGround)
                            .clickable {
                                onItemClicked(it)
                            }
                    ){
                        Text(
                            text = it,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp, horizontal = 25.dp)

                        )
                    }

                }
            )
        }
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