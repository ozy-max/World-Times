package com.test.times.timer.ui.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.times.timer.ui.TimerPageContract
import com.test.times.utils.theme.components.ButtonView
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimerViewDisplay(
    state: TimerPageContract.State,
    changeTimeZone: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        state.timeZone?.let {
            Text(
                text = it,
                style = TextStyle(fontSize = 24.sp, color = Color.White),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        state.dateTime?.let { DigitalClock(it) }

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            ButtonView(onClick = { changeTimeZone() }, backgroundColor = Color.DarkGray, text = "CHANGE TIMEZONE")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DigitalClock(currentTime: String) {
    Box(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .border(1.dp, Color.White, shape = MaterialTheme.shapes.medium)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = currentTime.format(DateTimeFormatter.ISO_LOCAL_TIME),
            style = TextStyle(fontSize = 72.sp, fontWeight = FontWeight.Bold, color = Color.White),
            modifier = Modifier.padding(16.dp)
        )
    }
}
