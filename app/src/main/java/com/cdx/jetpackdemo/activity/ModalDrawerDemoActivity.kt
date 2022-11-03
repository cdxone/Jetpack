package com.cdx.jetpackdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class ModalDrawerDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // 抽屉样式
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            ModalDrawer(
                drawerState = drawerState,
                modifier = Modifier.fillMaxWidth(),
                drawerBackgroundColor = Color.Red,
                drawerContentColor = Color.Green,
                scrimColor = Color.Transparent,
                drawerContent = {
                    Text(text = "选项1")
                    Divider()
                },
                drawerElevation = 10.0.dp
            ) {
                Text(text = "你好")
            }
        }
    }

}