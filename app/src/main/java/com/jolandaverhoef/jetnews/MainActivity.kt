package com.jolandaverhoef.jetnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

val BLUE = Color(0xff7189bf)
val PINK = Color(0xffdf7599)
val YELLOW = Color(0xffffc785)
val GREEN = Color(0xff72d6c9)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(modifier = LayoutWidth.Fill) {
        Surface(color = BLUE, modifier = LayoutWidth.Fill + LayoutHeight.Min(54.dp)) {}
        Surface(color = PINK, modifier = LayoutWidth.Fill + LayoutFlexible(1f)) {}
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Greeting("Android")
    }
}
