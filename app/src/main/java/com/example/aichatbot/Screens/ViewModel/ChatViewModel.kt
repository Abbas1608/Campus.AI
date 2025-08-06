package com.example.aichatbot.Screens.ViewModel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aichatbot.Screens.Message.messageModel
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch
import kotlin.getValue
import kotlin.setValue

class ChatViewModel: ViewModel(){

    val messageList by lazy {
        mutableStateListOf<messageModel>()
    }

    private val generativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = Constant.apikey
    )

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun sendMessage(Question: String){
        Log.i("Question",Question)

        // using a geminia sdk librarys
        viewModelScope.launch {
            try {
                val chat = generativeModel.startChat(
                    history = messageList.map {
                        content(it.role) { text(it.message) }
                    }.toList()
                )
                messageList.add(messageModel(Question,"User"))
                messageList.add(messageModel("Typing...","AI"))

                val responses = chat.sendMessage(Question)
                messageList.removeLast()
                messageList.add(messageModel(responses.text.toString(),"AI"))

                Log.i("ans", responses.text.toString() ?: "No response text")
            } catch (e: Exception) {
                Log.e("GeminiError", "Exception: ${e.message}", e)
            }
        }

    }
}