package com.example.aichatbot.Screens.SplitScreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aichatbot.R
import com.example.aichatbot.Screens.Navgation.ChatRoutes
import com.example.aichatbot.ui.theme.VCardBrush



@Composable
fun splitScreen(NavController: NavHostController) {

    var scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    var animateAgain by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = animateAgain) {
        scale.animateTo(
            targetValue = 360f,
            animationSpec = tween(durationMillis = 4000,
                delayMillis = 200,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        kotlinx.coroutines.delay(2000)
        NavController.navigate(ChatRoutes.ChatScreen.name){
            popUpTo(0)
        }
    }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(brush = VCardBrush),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(85.dp)
                .rotate(scale.value))

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Campus.AI",
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            color = colorResource(R.color.white)
            )
        HorizontalDivider(
            modifier = Modifier.width(90.dp),
            color = colorResource(R.color.Dark_Blue)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Developed By Abbas Shaikh",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.white),
            )

    }
}