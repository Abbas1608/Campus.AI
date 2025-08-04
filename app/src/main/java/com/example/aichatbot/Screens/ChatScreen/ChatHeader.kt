package com.example.aichatbot.Screens.ChatScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aichatbot.R

@Preview(showSystemUi = true)
@Composable
fun ChatHarder(){

    Box(modifier = Modifier.fillMaxWidth()
//        .background(brush = VCardBrush)
    )
    {

        Row {
            IconButton(
                onClick = {}) {
                Icon(imageVector = Icons.Default.Storage,
                    contentDescription = null,
                    tint = colorResource(R.color.white),
                    modifier = Modifier.size(25.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = colorResource(R.color.white),
                    modifier = Modifier.size(25.dp))
            }
        }



    }
}