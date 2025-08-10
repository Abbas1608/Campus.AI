package com.example.aichatbot.Screens.Navgation

import com.google.ai.client.generativeai.Chat

enum class ChatRoutes{
    SplitScreen,
    ChatScreen;
    companion object{
        fun fromRoutes(routes: String): ChatRoutes
                = when(routes?.substringBefore("/"))
        {
            SplitScreen.name ->SplitScreen
            ChatScreen.name -> ChatScreen
            null -> ChatScreen
            else ->throw IllegalArgumentException("Routes unExcepted")
        }
    }
}