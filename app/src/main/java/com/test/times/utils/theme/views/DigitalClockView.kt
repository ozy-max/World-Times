package com.test.times.utils.theme.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DigitalClockView(
    currentTime: String,
    currentDate: String,
    capitalName: String,
    fonsSize: TextUnit,
    textColor: Color,
    fontStyle: FontStyle?,
    fontFamily: FontFamily
) {
    Box(
        modifier = Modifier
            .height(210.dp)
            .fillMaxWidth()
            .border(1.dp, Color.White, shape = MaterialTheme.shapes.medium)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = capitalName,
                    style = TextStyle(
                        fontSize = fonsSize,
                        color = textColor,
                        fontFamily = fontFamily,
                        fontStyle = fontStyle
                    )
                )
            }

            Text(
                text = currentTime,
                style = TextStyle(fontSize = 72.sp, fontWeight = FontWeight.Bold, color = Color.White),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = currentDate,
                    style = TextStyle(
                        fontSize = fonsSize,
                        color = textColor,
                        fontFamily = fontFamily,
                        fontStyle = fontStyle
                    )
                )
            }
        }
    }
}
