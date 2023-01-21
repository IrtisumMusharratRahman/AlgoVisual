package com.example.algovisual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.algovisual.route.NavScreens
import com.example.algovisual.route.Navigation
import com.example.algovisual.ui.AppBar
import com.example.algovisual.ui.NavDrawerBody
import com.example.algovisual.ui.NavDrawerHeader
import com.example.algovisual.ui.mergeSort.MergeSortScreen
import com.example.algovisual.ui.theme.AlgoVisualTheme
import com.example.algovisual.ui.theme.background
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgoVisualTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {

    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var navController:NavController = rememberNavController()
    var pageName = remember {
        mutableStateOf("Bubble Sort")
    }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        backgroundColor = background,
        topBar = {
            AppBar(
                iconClicked = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                },
                appBarTitle = {
                    Text(
                        text = pageName.value,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                    )
                }
            )
        },
//        drawerGesturesEnabled = scaffoldState.drawerState.isClosed,
        drawerContent = {
            NavDrawerHeader()
            NavDrawerBody(pageName.value){algoName->
                pageName.value=algoName
                when(algoName){
                    context.getString(R.string.bubble_sort) -> {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        navController.navigate(NavScreens.BubbleSort.route)

                    }
                    context.getString(R.string.selection_sort) -> {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        navController.navigate(NavScreens.SelectionSort.route)
                    }
                    context.getString(R.string.insertion_sort) -> {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        navController.navigate(NavScreens.InsertionSort.route)
                    }
                    context.getString(R.string.merge_sort) -> {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        navController.navigate(NavScreens.MergeSort.route)
                    }
                    context.getString(R.string.quick_sort) -> {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        navController.navigate(NavScreens.QuickSort.route)
                    }
                }
            }
        }

    ) {
        Navigation(){
            navController=it
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlgoVisualTheme {

    }
}