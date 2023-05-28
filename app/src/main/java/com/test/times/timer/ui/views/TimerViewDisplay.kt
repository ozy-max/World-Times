package com.test.times.timer.ui.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.times.timer.ui.TimerPageContract
import com.test.times.utils.theme.components.ButtonView
import com.test.times.utils.theme.views.DigitalClockView

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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.dateTime?.let { currentTime ->
            DigitalClockView(
                currentTime = currentTime,
                currentDate = state.date.toString(),
                capitalName = state.timeZone.toString(),
                fonsSize = 24.sp,
                textColor = Color.White,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.SansSerif
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

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
@Preview
fun PreviewTimer() {
    TimerViewDisplay(
        state = TimerPageContract.State(
            dateTime = "2023-05-28T07:49:43.4272562",
            timeZone = "Europe/Berlin",
            isLoading = false,
            error = null
        ),
        changeTimeZone = {}
    )
}
