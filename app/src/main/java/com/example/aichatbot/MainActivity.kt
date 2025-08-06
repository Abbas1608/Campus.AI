package com.example.aichatbot

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.aichatbot.Screens.ChatScreen.ChatScreen
import com.example.aichatbot.Screens.ViewModel.ChatViewModel

import com.example.aichatbot.ui.theme.AiChatBotTheme
import kotlin.jvm.java

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ChatViewModel = ViewModelProvider(this)[ChatViewModel :: class.java]
        enableEdgeToEdge()
        setContent {
            AiChatBotTheme {
                ChatScreen(ChatViewModel)
            }
        }
    }
}
