package com.example.algovisual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.algovisual.route.NavScreens
import com.example.algovisual.route.Navigation
import com.example.algovisual.ui.AppBar
import com.example.algovisual.ui.NavDrawerBody
import com.example.algovisual.ui.NavDrawerHeader
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
                    Text(text = pageName.value, textAlign = TextAlign.Center)
                }
            )
        },
//        drawerGesturesEnabled = scaffoldState.drawerState.isClosed,
        drawerContent = {
            NavDrawerHeader()
            NavDrawerBody(){algoName->
                pageName.value=algoName
                when(algoName){
                    "Bubble Sort" -> {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        navController.navigate(NavScreens.BubbleSort.route)

                    }
                    "Selection Sort" -> {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        navController.navigate(NavScreens.SelectionSort.route)
                    }
                    "Insertion Sort" -> {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        navController.navigate(NavScreens.InsertionSort.route)
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