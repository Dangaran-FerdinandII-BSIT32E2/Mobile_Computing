package com.example.myapplication

//import androidx.compose.ui.text.font
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun Article(title: String, body: String, text: String, modifier: Modifier = Modifier){
    Column {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun TaskManager(title: String, body: String, modifier: Modifier = Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(start = 85.dp, top = 250.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = title,
            fontWeight = Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = body,
            fontSize = 16.sp
        )
    }
}
@Composable
fun Quadrants() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = "Text Composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = "Row Composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier
                    .weight(1f)
            )
            Quadrant(
                title = "Column Composable",
                description = "A layout composable that places its children in a vertical sequence.",
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(
    title: String,
    description: String,
    backgroundColor : Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(bottom = 16.dp),
            fontWeight = Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Compose Task Manager"
)
@Composable
fun TaskManagerPreview() {
    MyApplicationTheme {
        Article(
            "Jetpack Compose tutorial",
            "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Compose Article"
)
@Composable
fun ArticlePreview() {
    MyApplicationTheme {
        TaskManager(
            "All tasks completed",
            "Nice work!"
        )
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Compose Quadrants"
)
@Composable
fun QuadrantPreview() {
    MyApplicationTheme {
        Quadrants()
    }
}

