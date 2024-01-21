package ru.com.bulat.animationcompose.ui.theme.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Test() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(
                state = rememberScrollState(),
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isIncreased by remember {
            mutableStateOf(true)
        }

        val size by animateDpAsState(
            targetValue = if (isIncreased) 200.dp else 100.dp,
            label = "",
            animationSpec = tween(
                durationMillis = 2000,
                easing = FastOutSlowInEasing,
                delayMillis = 1000
            ),

        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {isIncreased = !isIncreased}
        ) {
            Text(
                text = "Animate size",
            )
        }
        AnimatedContainer(
            text = "Size",
            size = size
        )

        var isRounded by remember {
            mutableStateOf(false)
        }
        val radius by animateIntAsState(targetValue = if (isRounded) 50 else 4)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {isRounded = !isRounded}
        ) {
            Text(
                text = "Animate shape",
            )
        }
        AnimatedContainer(
            text = "Shape",
            radiusPercent = radius
        )

        var isSelected by remember {
            mutableStateOf(false)
        }
        val borderWith by animateDpAsState(targetValue = if (isSelected) 16.dp else 0.dp)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {isSelected = !isSelected}
        ) {
            Text(
                text = "Animate border",
            )
        }
        AnimatedContainer(
            text = "Border",
            borderWith = borderWith,
        )

        var isChanged by remember {
            mutableStateOf(false)
        }
        val color by animateColorAsState(targetValue = if (isChanged) Color.Red else Color.Blue)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {isChanged = !isChanged}
        ) {
            Text(
                text = "Animate color",
            )
        }
        AnimatedContainer(
            text = "Color",
            color = color
        )

        var isVisibility by remember {
            mutableStateOf(true)
        }
        val alpha by animateFloatAsState(targetValue = if (isVisibility) 1f else 0f)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {isVisibility = !isVisibility}
        ) {
            Text(
                text = "Animate visibility",
            )
        }
        AnimatedContainer(
            text = "Visibility",
            alpha = alpha
        )
    }
}

@Composable
private fun AnimatedContainer(
    text: String,
    size : Dp = 200.dp,
    radiusPercent :Int = 4,
    borderWith : Dp = 0.dp,
    color : Color = Color.Blue,
    alpha : Float = 1f,
) {
    Box(
        modifier = Modifier
            .alpha(alpha = alpha)
            .clip(RoundedCornerShape(radiusPercent))
            .border(width = borderWith, color = Color.Red)
            .background(color)
            .size(size),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}