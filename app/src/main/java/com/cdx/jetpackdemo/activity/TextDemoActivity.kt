package com.cdx.jetpackdemo.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cdx.jetpackdemo.R
import kotlinx.coroutines.launch

class   TextDemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            content()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun content() {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = "你好")
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray),
                text = stringResource(R.string.app_name),
                fontFamily = FontFamily.Serif,
                color = Color.Red,
                fontSize = 10.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                style = TextStyle(
                    fontSize = 20.0.sp,
                    shadow = Shadow( //阴影
                        color = Color.Red,
                        offset = Offset(5.0f, 10.0f),
                        blurRadius = 3.0f
                    )
                )
            )

        }
    }
}