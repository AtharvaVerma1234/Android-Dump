package com.vermaatharva.chatapp.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.vermaatharva.chatapp.ChatViewModel

@Composable
fun StatusScreen(navController: NavController,viewModel: ChatViewModel) {
    BottomNavigationMenu(selectedItem = BottomNavigationItem.STATUSLIST, navController = navController)
}