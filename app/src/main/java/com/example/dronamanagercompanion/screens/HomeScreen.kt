package com.example.dronamanagercompanion.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dronamanagercompanion.DataManager
import com.example.dronamanagercompanion.models.Player

@Composable
fun Home(padding: PaddingValues , navController: NavController){
    Box( modifier = Modifier
        .fillMaxSize()
        .padding(padding)){
        Grid(DataManager.data , navController)
    }
}

@Composable
fun Grid(playerDetails : Array<Player> , navController: NavController) {
    if(DataManager.isDataLoaded.value){
        LazyVerticalGrid(columns = GridCells.Adaptive(100.dp) ,
            contentPadding = PaddingValues(6.dp) ,
            userScrollEnabled = true)
        {
            items(playerDetails){
                player ->
                PlayerCardView(playerImage = player.playerImage, title =player.name , description = player.role , county = player.country){
                    playerName -> navController.navigate("playerDetail/${playerName}")
                }
            }
        }

    }
    else {
        Text(text = "Wait Loading")
    }

}
