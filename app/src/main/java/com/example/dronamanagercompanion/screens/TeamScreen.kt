package com.example.dronamanagercompanion.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Team(padding: PaddingValues , navController: NavController){
    Box( modifier = Modifier
        .fillMaxSize()
        .padding(padding)){
        Text(text = "This is Team")
    }
}