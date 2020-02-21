package com.jolandaverhoef.jetnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Typography
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.font.ResourceFont
import androidx.ui.text.font.fontFamily
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp

val BLUE = Color(0xff7189bf)
val PINK = Color(0xffdf7599)
val YELLOW = Color(0xffffc785)
val GREEN = Color(0xff72d6c9)

val appFontFamily = fontFamily(
    fonts = listOf(
        ResourceFont(R.font.montserrat_regular),
        ResourceFont(R.font.montserrat_medium, FontWeight.W500),
        ResourceFont(R.font.montserrat_semibold, FontWeight.W600)
    )
)
val themeTypography = Typography(
    h6 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    body2 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    )
)

val bodyFontFamily = fontFamily(
    fonts = listOf(
        ResourceFont(R.font.domine_regular),
        ResourceFont(R.font.domine_bold, FontWeight.Bold)
    )
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(typography = themeTypography) {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Column {
        TopAppBar()
        ContentSection()
    }
}

@Composable
fun TopAppBar() {
    Text("I'm a Top App Bar")
}

@Composable
fun ContentSection() {
    Column {
        Title()
        PostCardTop()
        PostCardSimple()
        PostCardSimple()
        PostCardSimple()
    }
}

@Composable
fun Title() {
    Text("Top stories for you")
}

@Composable
fun PostCardTop() {
    Column(modifier = LayoutPadding(16.dp)) {
        Container(height = 180.dp, expanded = true) {
            Clip(RoundedCornerShape(4.dp)) {
                DrawImage(imageResource(R.drawable.post_4))
            }
        }
        Spacer(LayoutHeight(16.dp))
        Text(
            text = "Locale changes and the AndroidViewModel antipattern",
            style = MaterialTheme.typography().h6
        )
        Text(
            text = "Jose Alcérra",
            style = MaterialTheme.typography().body2
        )
        Text(
            text = "April 02 - 1 min read",
            style = MaterialTheme.typography().body2
        )
    }
}

@Composable
fun PostCardSimple() {
    Row(modifier = LayoutPadding(16.dp)) {
        Container(
            width = 40.dp, height = 40.dp,
            modifier = LayoutPadding(right = 16.dp)
        ) {
            DrawImage(imageResource(R.drawable.post_1_thumb))
        }
        Column(modifier = LayoutFlexible(1f)) {
            Text(
                text = "A Little Thing about Android Module Paths",
                style = MaterialTheme.typography().subtitle1
            )
            Text(
                text = "Pietro Maggi - 1 min read",
                style = MaterialTheme.typography().body2
            )
        }
        Container(width=48.dp, height = 48.dp) {
            DrawVector(vectorResource(R.drawable.ic_bookmark))
        }
    }
}

@Preview("Post Card Top")
@Composable
fun DefaultPreview() {
    MaterialTheme(typography = themeTypography) {
        PostCardSimple()
    }
}
