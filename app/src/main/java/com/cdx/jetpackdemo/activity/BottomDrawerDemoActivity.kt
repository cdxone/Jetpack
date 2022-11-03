package com.cdx.jetpackdemo.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class BottomDrawerDemoActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val drawerState = rememberBottomDrawerState(BottomDrawerValue.Closed)
            BottomDrawer(
                drawerState = drawerState,
                drawerContent = {
                    // Drawer content
                    Column {
                        Text(text = "选项1", modifier = Modifier.padding(10.0.dp))
                        Divider(modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp),
                            color = Color.Blue
                        )
                        Text(text = "选项2", modifier = Modifier.padding(10.0.dp))
                        Divider(modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp),
                            color = Color.Red
                        )
                    }
                }
            ) {
                Text(text = "内容")
            }
        }
    }
}