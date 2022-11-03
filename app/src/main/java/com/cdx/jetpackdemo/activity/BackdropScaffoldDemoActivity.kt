package com.cdx.jetpackdemo.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class BackdropScaffoldDemoActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 背景幕
            BackdropScaffold(
                appBar = {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)) {
                        Text(text = "Top app bar", modifier = Modifier.padding(10.dp))
                    }
                },
                backLayerContent = {
                    // Back layer content
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(color = Color.Red)
                    ) {
                        Text(text = "这是背景", fontSize = 30.sp)
                    }
                },
                frontLayerContent = {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(color = Color.Green)
                    ) {
                        Text(text = "这是前景", fontSize = 30.sp)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                // 背景颜色
                backLayerBackgroundColor = Color.Red
            )
        }
    }
}