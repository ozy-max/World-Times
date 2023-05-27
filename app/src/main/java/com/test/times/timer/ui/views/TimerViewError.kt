package com.test.times.timer.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.test.times.R
import com.test.times.timer.ui.TimerPageContract
import com.test.times.utils.theme.components.CustomButton

@Composable
fun TimesViewError(
    state: TimerPageContract.State,
    onReloadClick: () -> Unit
) {

    state.error?.let { errorMessage ->

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(96.dp),
                        imageVector = Icons.Filled.Warning,
                        tint = Color.Yellow,
                        contentDescription = "Error loading items"
                    )

                    Text(
                        modifier = Modifier.padding(top = 16.dp, bottom = 24.dp),
                        text = errorMessage,
                        style = TextStyle.Default,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    CustomButton(
                        modifier = Modifier.fillMaxWidth(),
                        backgroundColor = Color.DarkGray,
                        text = stringResource(id = R.string.action_refresh),
                        onClick = onReloadClick
                    )
                }
            }
        }
    }
}
