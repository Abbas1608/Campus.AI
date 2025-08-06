package com.example.aichatbot.Screens.ChatScreen

import android.R.attr.enabled
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aichatbot.R

@Composable
fun ChatInputBar( onMessageSend :(String) -> Unit) {

    var userText by remember { mutableStateOf("") }
    var onTextChange: (String) -> Unit  = {userText = it}
    var onPlusClick: () -> Unit  ={}
    var onToolsClick: () -> Unit ={}

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.blue), shape = RoundedCornerShape(10.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        // Multiline TextField
        TextField(
            value = userText,
            onValueChange = onTextChange,
            placeholder = {
                Text("Ask anything...", color = Color.White)
            },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 40.dp, max = 150.dp), // Allow growth
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            maxLines = 5
        )


        Spacer(modifier = Modifier.height(2.dp))

        // Bottom row of icons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                IconButton(onClick = onPlusClick) {
                    Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
                }
                IconButton(onClick = onToolsClick) {
                    Icon(Icons.Default.Tune, contentDescription = "Tools", tint = Color.White)
                }
            }

            IconButton(
                onClick = {onMessageSend(userText)
                    Log.i("mess",userText)
                    userText = " "},

                modifier = Modifier
                    .size(36.dp)
                    .background(colorResource(R.color.light_blue), shape = CircleShape)
            ) {
                Icon(Icons.Default.ArrowUpward, contentDescription = "Sent", tint = Color.White)
            }
        }
    }
}