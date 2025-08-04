package com.example.aichatbot.Screens.ChatScreen

import android.R.attr.enabled
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Storage
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


@Preview(showSystemUi = true)
@Composable
fun messageInput() {
    var usertext by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = usertext,
            onValueChange = {usertext = it},
            placeholder = { Text("Ask anything..", color = Color.White) },
            colors = TextFieldDefaults.colors(
                contentColorFor(colorResource(R.color.blue)),
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                focusedContainerColor = colorResource(R.color.blue),
                unfocusedContainerColor = colorResource(R.color.blue),
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .width(300.dp)
                .height(50.dp)
                .background(color = colorResource(R.color.blue), shape = RoundedCornerShape(10.dp)),
            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = {},
            modifier = Modifier
                .height(50.dp)
                .size(45.dp)
                .background(Color(0xFF3A4A7D), shape = RoundedCornerShape(10.dp)) // send button bg
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Send",
                tint = Color.White
            )
        }
    }
}