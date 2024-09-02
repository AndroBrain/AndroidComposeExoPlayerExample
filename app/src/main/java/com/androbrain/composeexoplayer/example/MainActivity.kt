package com.androbrain.composeexoplayer.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.androbrain.composeexoplayer.example.ui.theme.AndroidComposeExoPlayerExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposeExoPlayerExampleTheme {
                PlayerScreen()
            }
        }
    }
}
