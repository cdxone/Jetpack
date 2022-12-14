package com.cdx.jetpackdemo.activity

import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import android.widget.Scroller
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cdx.jetpackdemo.R
import kotlinx.coroutines.launch

class ImageDemoActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            content()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun content() {
        val rainbowColorsBrush = remember {
            Brush.sweepGradient(
                listOf(
                    Color(0xFF9575CD),
                    Color(0xFFBA68C8),
                    Color(0xFFE57373),
                    Color(0xFFFFB74D),
                    Color(0xFFFFF176),
                    Color(0xFFAED581),
                    Color(0xFF4DD0E1),
                    Color(0xFF9575CD)
                )
            )
        }
        LazyColumn(modifier = Modifier.padding(20.dp)) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .width(200.dp)
                        .height(100.dp)
                        .border(BorderStroke(10.0.dp, Color.Red))
                        .background(Color.Yellow),
                    contentScale = ContentScale.Fit //??????
                )
            }
            item {
                AsyncImage(
                    model = "https://gd-hbimg.huaban.com/8765789188dfa37b3d9101c06d002a516b823f177c99-fRdS9e_fw658",
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                )
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
            }
            item {
                AsyncImage(
                    model = "https://gd-hbimg.huaban.com/8765789188dfa37b3d9101c06d002a516b823f177c99-fRdS9e_fw658",
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(CircleShape))
            }
            item {
                // ??????????????????????????????????????? contentScale = ContentScale.Crop
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .border(BorderStroke(6.dp, Color.Yellow), RoundedCornerShape(16.dp))//??????
                        .clip(RoundedCornerShape(16.dp)))
            }
            item {
                // ????????????????????????
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(16.dp, 16.0.dp, 0.dp, 0.dp)))
            }
            item {
                // ??????????????????
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .border(BorderStroke(6.dp, Color.Yellow), CircleShape)
                        .clip(CircleShape))
            }
            item {
                // ?????????????????????
                val borderWidth = 4.dp
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .border(
                            BorderStroke(borderWidth, rainbowColorsBrush),
                            CircleShape
                        )
                        .padding(borderWidth)
                        .clip(CircleShape)
                )
            }

            item {
                //??????????????????
                //?????????width(170.dp) ??? ?????? aspectRatio(16f / 9f) ????????????
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    modifier = Modifier
                        .width(170.dp)
                        .aspectRatio(16f / 9f)
                )
            }

            item {
                // ???????????? - ???????????????????????????
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.Yellow, blendMode = BlendMode.Darken),
                    modifier = Modifier.width(160.dp)
                )
            }

            item {
                // ???????????? ColorFilter ??????????????????????????????
                // ???????????????????????????????????????????????????????????? ColorMatrix ???????????????????????? 0f???
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) }),
                    modifier = Modifier.width(160.dp)
                )
            }

            item {
                // ??? Image ??????????????????????????????
                // ????????????????????????????????????????????? Modifier.blur()
                // ??????????????? radiusX ??? radiusY??????????????????????????????????????????????????????????????????
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) }),
                    modifier = Modifier
                        .width(160.dp)
                        .blur(//
                            radiusX = 10.dp,
                            radiusY = 10.dp,
                            edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
                        )
                )
            }
        }
    }
}