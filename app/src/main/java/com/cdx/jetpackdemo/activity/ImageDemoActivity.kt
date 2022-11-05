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
                    contentScale = ContentScale.Fit //缩放
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
                // 指定圆角：注意，必须要设置 contentScale = ContentScale.Crop
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .border(BorderStroke(6.dp, Color.Yellow), RoundedCornerShape(16.dp))//边界
                        .clip(RoundedCornerShape(16.dp)))
            }
            item {
                // 上面两个角是圆角
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(16.dp, 16.0.dp, 0.dp, 0.dp)))
            }
            item {
                // 周围增加边框
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
                // 周围彩色的边框
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
                //自定义匡高比
                //注意：width(170.dp) 和 属性 aspectRatio(16f / 9f) 不能写反
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    modifier = Modifier
                        .width(170.dp)
                        .aspectRatio(16f / 9f)
                )
            }

            item {
                // 颜色滤镜 - 转换图片的像素颜色
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.Yellow, blendMode = BlendMode.Darken),
                    modifier = Modifier.width(160.dp)
                )
            }

            item {
                // 颜色矩阵 ColorFilter 选项可用于转换图片。
                // 例如，如需对图片应用黑白滤镜，您可以使用 ColorMatrix 并将饱和度设置为 0f。
                Image(
                    painter = painterResource(id = R.drawable.diqiu),
                    contentDescription = "",
                    colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) }),
                    modifier = Modifier.width(160.dp)
                )
            }

            item {
                // 对 Image 可组合项进行模糊处理
                // 如需对图片进行模糊处理，请使用 Modifier.blur()
                // 并同时提供 radiusX 和 radiusY，两者分别指定水平方向和垂直方向的模糊半径。
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