package com.vermaatharva.chatapp.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.vermaatharva.chatapp.ChatViewModel

@Composable
fun ChatListScreen(navController: NavController,viewModel: ChatViewModel) {
    BottomNavigationMenu(selectedItem = BottomNavigationItem.CHATLIST, navController =navController )
}

