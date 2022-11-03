package com.cdx.jetpackdemo.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ScaffoldDemoActivity : ComponentActivity() {
    val scope = MainScope()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Greeting(name = "")
            }
        }
    }


    @Composable
    fun Greeting(name: String) {
        val scaffoldState = rememberScaffoldState()
        MaterialTheme {
            Scaffold(
                // 抽屉
                drawerContent = {
                    Text("Drawer title", modifier = Modifier.padding(16.dp))
                    Divider()
                },
                // 标题内容
                topBar = {
                    TopAppBar {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = "返回")
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                            Text(text = "标题")
                        }
                    }
                },
                // 底部内容
                bottomBar = {
                    BottomAppBar(
                        // Defaults to null, that is, No cutout
                        cutoutShape = MaterialTheme.shapes.small.copy(
                            CornerSize(percent = 50)
                        )
                    ) { /* Bottom app bar content */ }
                },
                // 悬浮框
                floatingActionButton = {
                    FloatingActionButton(onClick = {
                    },
                        // 距离底部的距离
                        modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp)) {
                        Text(text = "悬浮")
                    }
                },
                // 悬浮框的位置
                floatingActionButtonPosition = FabPosition.Center,
                // 参数将 FAB 与底部应用栏重叠：true 重叠
                isFloatingActionButtonDocked = true,

                ) {
                Box(modifier = Modifier.padding(40.dp)) {
                    ExtendedFloatingActionButton(
                        onClick = {
                            scope.launch {
                                Toast.makeText(baseContext, "1", Toast.LENGTH_SHORT).show()
                                // TODO 不生效
                                scaffoldState.snackbarHostState
                                    .showSnackbar("Snackbar")
                            }
                        },
                        icon = {
                            Icon(
                                Icons.Filled.Favorite,
                                contentDescription = "Favorite"
                            )
                        },
                        text = { Text("Like") },
                        elevation = FloatingActionButtonDefaults.elevation()
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Greeting("Android")
    }
}


