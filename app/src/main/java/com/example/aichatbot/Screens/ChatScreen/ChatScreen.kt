package com.example.aichatbot.Screens.ChatScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aichatbot.R
import com.example.aichatbot.ui.theme.HCardBrush
import com.example.aichatbot.ui.theme.VCardBrush

@Preview(showSystemUi = true)
@Composable
fun ChatScreen(){
    Column(modifier = Modifier.background(brush = VCardBrush)
        .fillMaxSize()
        .padding(start = 20.dp, end = 15.dp, bottom = 30.dp, top = 10.dp))
    {
        // Harder function
        ChatHarder()
        Spacer(modifier = Modifier.height(30.dp))

        //logo
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(painter = painterResource(R.drawable.logo),
                contentDescription = null)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Campus.AI",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = Color.White,
                fontStyle = FontStyle.Italic)
        }


        Spacer(modifier = Modifier.weight(1f))
        messageInput()

    }
}

