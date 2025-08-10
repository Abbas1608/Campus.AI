package com.example.aichatbot.Screens.ChatScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aichatbot.R
import com.example.aichatbot.Screens.Message.messageList
import com.example.aichatbot.Screens.ViewModel.ChatViewModel
import com.example.aichatbot.ui.theme.VCardBrush

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun ChatScreen(ViewModel: ChatViewModel) {
    var userText by remember { mutableStateOf("") }
    Column(modifier = Modifier.background(brush = VCardBrush)
        .fillMaxSize()
        .padding(start = 20.dp, end = 15.dp, bottom = 30.dp, top = 18.dp))
    {
        // Harder function
        ChatHarder()
        Spacer(modifier = Modifier.height(5.dp))

        //logo
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(55.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Campus.AI",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                color = Color.White,
                fontStyle = FontStyle.Italic)
        }
        // message list
        messageList(messList = ViewModel.messageList, modifier = Modifier.weight(1f))

        Spacer(modifier = Modifier.height(15.dp))


        ChatInputBar(onMessageSend = {
            ViewModel.sendMessage(it)

        })


    }
}

