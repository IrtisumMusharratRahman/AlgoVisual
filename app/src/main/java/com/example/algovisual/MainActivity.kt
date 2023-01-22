package com.example.algovisual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.algovisual.ui.AppScreen
import com.example.algovisual.ui.theme.AlgoVisualTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            AlgoVisualTheme {
                AppScreen()
            }
        }
    }
}