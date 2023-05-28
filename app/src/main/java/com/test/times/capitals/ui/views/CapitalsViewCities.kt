package com.test.times.capitals.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.times.capitals.model.City
import com.test.times.utils.theme.views.TopBarView

@Composable
fun CapitalsViewCities(
    cities: List<City>,
    onBackButtonClicked: () -> Unit,
    onClickItem: (City) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopBarView {
                onBackButtonClicked()
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                items(cities.size) { item ->
                    val city = cities[item]
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black, RoundedCornerShape(12.dp))
                            .padding(4.dp)
                            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(12.dp))
                            .clickable { onClickItem(city) }
                    ) {
                        Image(
                            painter = painterResource(city.imageFlag),
                            contentDescription = "Flag of Country",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(shape = CircleShape)
                                .border(width = 2.dp, color = Color.White, shape = CircleShape)
                        )
                        Text(
                            text = city.getTimeZone(),
                            fontSize = 18.sp,
                            lineHeight = 24.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                    }
                }
            }
        }
    }
}
