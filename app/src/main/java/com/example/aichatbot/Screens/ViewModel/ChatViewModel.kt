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
import com.google.ai.client.generativeai.type.RequestOptions
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException
import kotlin.getValue
import kotlin.setValue

class ChatViewModel : ViewModel() {

    // Backing list for Compose
    val messageList = androidx.compose.runtime.mutableStateListOf<messageModel>()

    // Pick a supported model. Options: "gemini-2.0-flash", "gemini-1.5-pro"
    private val generativeModel = GenerativeModel(
        modelName = "gemini-2.0-flash",
        apiKey = Constant.apikey,
        requestOptions = RequestOptions(apiVersion = "v1beta")
    )

    fun sendMessage(question: String) {
        if (question.isBlank()) return

        viewModelScope.launch {
            // 1) Add the user message immediately to UI
            messageList.add(messageModel(message = question, role = "User"))

            // 2) Add a "typing" placeholder
            messageList.add(messageModel(message = "Typing...", role = "AI"))

            try {
                // Build chat history with correct roles that the SDK expects: "user" or "model"
                val chat = generativeModel.startChat(
                    history = messageList
                        .filter { it.message.isNotBlank() && it.message != "Typing..." }
                        .map { msg ->
                            val role = when (msg.role.lowercase()) {
                                "user" -> "user"
                                "ai", "assistant", "model", "bot" -> "model"
                                else -> "user" // default to user if unknown
                            }
                            content(role) { text(msg.message) }
                        }
                )

                // Send the new message (you already added it to UI)
                val response = chat.sendMessage(question)

                // Safely remove the "Typing..." placeholder if present
                removeLastTypingPlaceholder()

                val answer = response.text
                if (answer.isNullOrBlank()) {
                    messageList.add(messageModel(message = "Sorry, I couldn't generate a response.", role = "AI"))
                } else {
                    messageList.add(messageModel(message = answer, role = "AI"))
                }

                Log.i("GeminiAnswer", answer ?: "No response text")
            } catch (ce: CancellationException) {
                // Coroutine canceled: just clean up typing placeholder
                removeLastTypingPlaceholder()
                Log.w("GeminiError", "Request canceled")
                throw ce
            } catch (e: Exception) {
                removeLastTypingPlaceholder()
                val err = e.message ?: "Unknown error"
                messageList.add(messageModel(message = "Error: $err", role = "AI"))
                Log.e("GeminiError", "Exception: $err", e)
            }
        }
    }

    private fun removeLastTypingPlaceholder() {
        // Remove the last "Typing..." entry safely if it exists
        for (i in messageList.lastIndex downTo 0) {
            if (messageList[i].message == "Typing..." && messageList[i].role.equals("AI", ignoreCase = true)) {
                messageList.removeAt(i)
                return
            }
        }
    }
}
