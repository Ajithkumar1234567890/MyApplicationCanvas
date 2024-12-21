package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}


@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("" )
    }
}

@Composable
fun InstagramImage(modifier: Modifier =Modifier) {
    Canvas(modifier = modifier.padding(54.dp).size(300.dp)) {
        drawRoundRect(brush = Brush.linearGradient(listOf(Red, Blue)),
            style = Stroke(width = 36f),
            cornerRadius = CornerRadius(
                x = 120f, y = 120f
            ))

        drawCircle(brush = Brush.linearGradient(listOf(Red, Blue)),
            radius = 150f,
            style = Stroke(40f))

        drawCircle(brush = Brush.linearGradient(listOf(Red, Blue)),
            radius = 50f,
            center = Offset(size.width.times(0.8f),size.height.times(0.2f)))
    }
}

@Preview(showBackground = true)
@Composable
fun FaceBookLogo(modifier: Modifier =Modifier){
    Canvas(modifier = modifier.padding(54.dp).size(300.dp)) {

        val paint = android.graphics.Paint().apply {
            textAlign = android.graphics.Paint.Align.CENTER
            textSize = 550f
            color = android.graphics.Color.WHITE
        }
        drawRoundRect(
            color = Color.Blue,
            cornerRadius = CornerRadius(
                x = 120f, y = 120f
            ))
        drawContext.canvas.nativeCanvas.drawText(
            "f",
            center.x,
            center.y+180f,
            paint

        )
    }
}

@Preview(showBackground = true)
@Composable
fun MessangerLogo(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.padding(54.dp).size(300.dp)) {
        val path= Path().apply {
            moveTo(x = size.width.times(0.2f), y = size.height.times(0.78f))
            lineTo(x = size.width.times(0.2f), y = size.height.times(0.90f))
            lineTo(x = size.width.times(0.35f), y = size.height.times(0.83f))
        }

        val electricPath = Path().apply {
            moveTo(x = size.width.times(0.35f), y = size.height.times(0.55f))
            lineTo(x = size.width.times(0.52f), y = size.height.times(0.30f))
            lineTo(x = size.width.times(0.59f), y = size.height.times(0.40f))
            lineTo(x = size.width.times(0.75f), y = size.height.times(0.25f))
            lineTo(x = size.width.times(0.59f), y = size.height.times(0.50f))
            lineTo(x = size.width.times(0.52f), y = size.height.times(0.40f))
            close()


        }

        drawOval(
            color = Color.Blue,
            size = Size(width = size.width,
                height = size.height.times(0.89f)))
        drawPath(
            path,
            color = Color.Blue,
            style = Fill)
        drawPath(
            electricPath,
            color = White,
            style = Fill

        )
    }
}
