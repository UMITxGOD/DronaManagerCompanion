package com.example.dronamanagercompanion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier


import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.compose.rememberNavController

import com.example.dronamanagercompanion.navigations.RootNavigation
import com.example.dronamanagercompanion.navigations.Screen
import com.example.dronamanagercompanion.ui.theme.DronaManagerCompanionTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetFromFile(applicationContext)
        }
        setContent {
            DronaManagerCompanionTheme {

                App()
            }
        }
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun App(){
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold (
            bottomBar = {
                BottomAppBar (containerColor = MaterialTheme.colorScheme.primaryContainer
                    , contentColor =  MaterialTheme.colorScheme.onPrimaryContainer , modifier = Modifier.height(70.dp)){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        ){
                        Row (modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceAround){
                            Icon(painter = painterResource(id = R.drawable.home_logo),
                                contentDescription = "home" , modifier = Modifier.clickable {
                                navController.navigate(Screen.Home.route)
                            } )
                            Icon(painter = painterResource(id = R.drawable.my_team),
                                contentDescription = "my_team" , modifier = Modifier.clickable {
                                    navController.navigate(Screen.Team.route)
                                } )
                            Icon(painter = painterResource(id = R.drawable.matches),
                                contentDescription = "result" , modifier = Modifier.clickable {
                                    navController.navigate(Screen.Result.route)
                                } )
                        }
                    }
                }
            }){

            RootNavigation(it,navController)

        }
    }

    }
