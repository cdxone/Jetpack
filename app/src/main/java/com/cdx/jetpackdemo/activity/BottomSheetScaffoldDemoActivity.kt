package com.cdx.jetpackdemo.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class BottomSheetScaffoldDemoActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberBottomSheetScaffoldState()
            val scope = rememberCoroutineScope()
            BottomSheetScaffold(
                sheetContent = {
                    Text(text = "sheetContent")
                },
                // 设置高度
                sheetPeekHeight = 128.dp,
                // 设置手势
                sheetGesturesEnabled = false,
                // 背景颜色
                sheetBackgroundColor = Color.Green,
                // 底部弹出框
                floatingActionButton = {
                    ExtendedFloatingActionButton(
                        text = { Text("Expand or collapse sheet") },
                        onClick = {
                            scope.launch {
                                scaffoldState.bottomSheetState.apply {
                                    if (isCollapsed) expand() else collapse()
                                }
                            }
                        }
                    )
                }
            ) {
                Text(text = "content")
            }
        }
    }
}