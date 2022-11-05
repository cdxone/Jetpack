package com.cdx.jetpackdemo.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.GridCells
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class LazyVerticalGridDemoActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = List(10) {
            Photo("张三 $it")
        }
        setContent {
//            LazyVerticalGrid(
//                cells = GridCells.Fixed(5),
//                horizontalArrangement = Arrangement.spacedBy(10.dp),
//                verticalArrangement = Arrangement.spacedBy(15.dp),
//                contentPadding = PaddingValues(10.0.dp)
//            ) {
//                items(list) { photo ->
//                    Text(text = photo.name,
//                        Modifier
//                            .background(Color.Gray)
//                            .fillMaxWidth())
//                }
//            }
        }
    }
}

data class Photo(val name: String)