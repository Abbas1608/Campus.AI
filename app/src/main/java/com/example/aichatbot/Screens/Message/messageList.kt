package com.example.aichatbot.Screens.Message

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aichatbot.R


@Composable
fun messageList(modifier: Modifier,messList: List<messageModel>)
{

    LazyColumn(
        modifier = modifier,
        reverseLayout = true
    ) {
        items(messList.reversed()){
            messageListUI(it)
        }
    }
}

@Composable
fun messageListUI(
    messageModel: messageModel
){

    val isModel = messageModel.role == "AI"
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.fillMaxWidth()){
            //AI
            if (isModel){
                Text(
                    text = messageModel.message,
                    fontSize = 14.sp,
                    color = colorResource(R.color.white),
                    modifier = Modifier
                        .padding(end = 25.dp, bottom = 5.dp, top = 5.dp)
                )
            }
            //users
            else {
                Box(
                    modifier = Modifier
//                        .padding( end = 4.dp)
//                        .fillMaxWidth()
                        .heightIn(min = 30.dp, max = 350.dp)
                        .background(
                            colorResource(R.color.blue),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .align (alignment = Alignment.BottomEnd)
                ) {
                    Text(
                        text = messageModel.message,
                        fontSize = 14.sp,
                        color = colorResource(R.color.white),
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
            }
        }
    }

}