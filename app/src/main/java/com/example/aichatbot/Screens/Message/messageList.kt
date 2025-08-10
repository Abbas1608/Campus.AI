package com.example.aichatbot.Screens.Message

import android.R.attr.text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aichatbot.R

@Composable
fun messageList(modifier: Modifier, messList: List<messageModel>) {
    if (messList.isEmpty()) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Where should we begin?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color = colorResource(R.color.white)
            )
        }
    } else {
        LazyColumn(
            modifier = modifier,
            reverseLayout = true
        ) {
            items(messList.reversed()) { item ->
                messageListUI(item)
            }
        }
    }
}

@Composable
fun messageListUI(msg: messageModel) {
    val isModel = msg.role.equals("AI", ignoreCase = true)

    text
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = if (isModel) Arrangement.Start else Arrangement.End,
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = if (isModel) Color.Transparent else colorResource(R.color.blue),
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomEnd = if (isModel) 12.dp else 2.dp,
                        bottomStart = if (isModel) 2.dp else 12.dp
                    )
                )
                .padding(horizontal = 12.dp, vertical = 8.dp)
                .heightIn(min = 30.dp, max = 350.dp)
        ) {
            // AI message not scrollable; user message scrollable if long
            val textModifier = if (isModel) Modifier.verticalScroll(rememberScrollState()) else Modifier.verticalScroll(rememberScrollState())

            SelectionContainer {
                Text(
                    modifier = textModifier,
                    text = parseMessage(msg.message),
                    fontSize = 14.sp,
                    color = colorResource(R.color.white)
                )
            }
        }
    }
}

/**

Parses message to:

Bold text wrapped with double asterisks

Bullet lines when a line starts with "* "

Numbered lines when a line starts with "N. "
 */
private fun parseMessage(input: String) = buildAnnotatedString {
    val lines = input.replace("\r\n", "\n").split("\n")

    lines.forEachIndexed { index, rawLine ->
        val line = rawLine.trimEnd()

        text
        val numberMatch = Regex("""^(\d+)\.\s+(.*)$""").matchEntire(line)

        when {
            line.startsWith("* ") -> {
                append("-  ")
                appendParsedBold(line.removePrefix("* ").trim())
            }
            numberMatch != null -> {
                val (num, rest) = numberMatch.destructured
                append("$num. ")
                appendParsedBold(rest.trim())
            }
            else -> {
                appendParsedBold(line)
            }
        }

        if (index != lines.lastIndex) append("\n")
    }
}

/**

Appends text handling bold segments.

Any text between pairs of ** is rendered bold.
 */
private fun androidx.compose.ui.text.AnnotatedString.Builder.appendParsedBold(text: String) {
    val parts = text.split("**")
    parts.forEachIndexed { i, part ->
        if (i % 2 == 1) {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold, fontSize = 16.5.sp)) { append(part) }
        } else {
            append(part)
        }
    }
}