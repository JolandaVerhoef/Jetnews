package com.jolandaverhoef.jetnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.frames.ModelList
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.font.ResourceFont
import androidx.ui.text.font.fontFamily
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Model
object AppState {
    val bookmarks = ModelList<String>()
}

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

val themeColors = lightColorPalette(
    primary = Color(0xFFDD0D3C),
    primaryVariant = Color(0xFFC20029),
    onPrimary = Color.White,
    secondary = Color.White,
    onSecondary = Color.Black,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFD00036),
    onError = Color.White
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
            MaterialTheme(typography = themeTypography, colors = themeColors) {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Scaffold(
        topAppBar = {
            TopAppBar(
                title = { Text("Jetnews (${AppState.bookmarks.size})")},
                navigationIcon = {
                    DrawVector(vectorResource(R.drawable.ic_jetnews_logo))
                })
        }
    ) {
        ContentSection(listOf(post1, post2, post3))
    }
}

object Header

@Composable
fun ContentSection(posts: List<Post>) {
    val data = listOf(Header) + posts
    AdapterList(data) {
        when(it) {
            is Header -> {
                Title()
                PostCardTop()
            }
            is Post -> PostCardSimple(it)
        }
    }
}

@Composable
fun Title() {
    Text(
        text = "Top stories for you",
        style = MaterialTheme.typography().subtitle1,
        modifier = LayoutPadding(left = 16.dp, right = 16.dp, top = 16.dp)
    )
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

data class Post(
    val id: String,
    val image: Int,
    val title: String,
    val subtitle: String
)

val post1 = Post(
    id = "1",
    image = R.drawable.post_1_thumb,
    title = "A Little Thing about Android Module Paths",
    subtitle = "Pietro Maggi - 1 min read"
)

val post2 = Post(
    id = "2",
    image = R.drawable.post_2_thumb,
    title = "Dagger in Kotlin: Gotchas and optimizations",
    subtitle = "Manuel Vivo - 3 min read"
)

val post3 = Post(
    id = "3",
    image = R.drawable.post_3_thumb,
    title = "From Java Programming Language to Kotlin — the idiomatic way",
    subtitle = "Florina Muntenescu - 1 min read"
)

@Composable
fun PostCardSimple(post: Post) {
    Row(modifier = LayoutPadding(16.dp)) {
        Container(
            width = 40.dp, height = 40.dp,
            modifier = LayoutPadding(right = 16.dp)
        ) {
            DrawImage(imageResource(post.image))
        }
        Column(modifier = LayoutFlexible(1f)) {
            Text(
                text = post.title,
                style = MaterialTheme.typography().subtitle1
            )
            Text(
                text = post.subtitle,
                style = MaterialTheme.typography().body2
            )
        }
        Clickable(onClick = { bookmarkClicked(post.id) }) {
            Container(width = 48.dp, height = 48.dp) {
                DrawVector(
                    vectorResource(
                        if (AppState.bookmarks.contains(post.id)) R.drawable.ic_bookmarked else R.drawable.ic_bookmark
                    )
                )
            }
        }
    }
}

private fun bookmarkClicked(postId: String) {
    with(AppState) {
        if (bookmarks.contains(postId)) {
            bookmarks.remove(postId)
        } else {
            bookmarks.add(postId)
        }
    }
}
@Preview
@Composable
fun ContentPreview() {
    MaterialTheme(typography = themeTypography, colors = themeColors) {
        MyApp()
    }
}