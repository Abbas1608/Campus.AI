package com.example.aichatbot.Screens.Navgation

import android.R.attr.text
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aichatbot.Screens.ChatScreen.ChatScreen
import com.example.aichatbot.Screens.SplitScreen.splitScreen
import com.example.aichatbot.Screens.ViewModel.ChatViewModel

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun ChatNavigation() {
    val navController = rememberNavController()

    text
    NavHost(
        navController = navController,
        startDestination = ChatRoutes.SplitScreen.name
    ) {
        composable(ChatRoutes.SplitScreen.name) {
            splitScreen(navController)
        }
        composable(ChatRoutes.ChatScreen.name) { backStackEntry ->
            val chatViewModel: ChatViewModel = viewModel(backStackEntry)
            ChatScreen(chatViewModel)
        }
    }
}