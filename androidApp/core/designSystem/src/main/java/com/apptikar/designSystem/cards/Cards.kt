package com.apptikar.designSystem.cards

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.apptikar.designSystem.ChroneXTheme
import com.apptikar.designSystem.chroneXPrimaryColor


@Composable
fun ChroneLineChart(
    data: List<Float>,
    modifier: Modifier = Modifier,
    height : Dp,
    lineColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    backgroundColor: Color = Color.Transparent,
    strokeWidth: Float = 3f,
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        if (data.isEmpty()) return@Canvas

        val width = size.width
        val height = size.height


        val minValue = data.minOrNull() ?: 0f
        val maxValue = data.maxOrNull() ?: 1f
        val valueRange = maxValue - minValue


        val points = data.mapIndexed { index, value ->
            val x = (index.toFloat() / (data.size - 1).coerceAtLeast(1)) * width
            val y = height - ((value - minValue) / valueRange.coerceAtLeast(0.001f)) * height
            Offset(x, y)
        }


        if (points.size > 1) {
            val path = Path().apply {
                moveTo(points.first().x, points.first().y)
                for (i in 1 until points.size) {
                    lineTo(points[i].x, points[i].y)
                }
            }

            drawPath(
                path = path,
                color = lineColor,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round, join = StrokeJoin.Round)
            )
        }
    }
}

@Preview
@Composable
fun ChroneLineChartPreview() {
    ChroneXTheme {
        ChroneLineChart(
            data = listOf(10f, 20f, 15f, 25f, 20f, 30f, 25f,10f, 20f, 15f, 25f, 20f, 30f, 25f,10f, 20f, 15f, 25f, 20f, 30f, 25f,10f, 20f, 15f, 25f, 20f, 30f, 25f),
            height = 200.dp,
            lineColor = MaterialTheme.colorScheme.chroneXPrimaryColor,
            backgroundColor = Color.LightGray.copy(alpha = 0.2f),
            strokeWidth = 4f,
            modifier = Modifier.padding(16.dp)
        )
    }
}



