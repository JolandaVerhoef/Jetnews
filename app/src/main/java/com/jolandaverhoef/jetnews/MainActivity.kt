package com.jolandaverhoef.jetnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

val BLUE = Color(0xff7189bf)
val PINK = Color(0xffdf7599)
val YELLOW = Color(0xffffc785)
val GREEN = Color(0xff72d6c9)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
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
    Text("I'm a Title")
}

@Composable
fun PostCardTop() {
    Text("I'm a Post Card Top")
}

@Composable
fun PostCardSimple() {
    Text("I'm a Post Card Simple")
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        MyApp()
    }
}
