package com.example.aichatbot.Screens.SplitScreen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.aichatbot.R
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aichatbot.ui.theme.VCardBrush

//import androidx.navigation.NavHostController
//import com.example.calculator.Navigation.CalRoutes


@Preview(showSystemUi = true)
@Composable
fun SplitScreen() {
//NavController: NavHostController

//    LaunchedEffect(Unit) {
//        kotlinx.coroutines.delay(2000)  // 2 seconds delay
//        NavController.navigate(CalRoutes.NormalCalculatorScreen.name){
//            popUpTo(0)
//        }
//    }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(brush = VCardBrush),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            Modifier.size(80.dp),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Campus.AI",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = colorResource(R.color.white)
        )
        HorizontalDivider(
            modifier = Modifier.width(96.dp),
            color = colorResource(R.color.white)
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
