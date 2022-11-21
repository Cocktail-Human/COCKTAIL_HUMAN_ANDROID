package com.example.cocktail_human_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cocktail_human_android.ui.theme.BlendyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlendyTheme {
                // A surface container using the 'background' color from the theme
            }
        }
    }
}