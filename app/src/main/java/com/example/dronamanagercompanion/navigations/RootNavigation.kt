package com.example.dronamanagercompanion.navigations

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.dronamanagercompanion.DataManager
import com.example.dronamanagercompanion.screens.Home
import com.example.dronamanagercompanion.screens.PlayerDetailScreen
import com.example.dronamanagercompanion.screens.Result
import com.example.dronamanagercompanion.screens.SplashScreen
import com.example.dronamanagercompanion.screens.Team

@Composable
fun RootNavigation(padding: PaddingValues , navController: NavHostController){
        NavHost(navController = navController , startDestination = Screen.Splash.route ){
            composable(route = Screen.Splash.route  ){
                SplashScreen(navController = navController)
            }
            composable(route = Screen.Home.route){
                Home(padding = padding, navController = navController)
            }

            composable(route = Screen.Team.route){
                Team(padding = padding, navController = navController)
            }

            composable(route = Screen.Result.route){
                Result(padding = padding, navController =navController )
            }
            composable(route = "playerDetail/{playerName}" , arguments = listOf(
                navArgument(name = "playerName" ){
                    type = NavType.StringType
                }
            )){ it ->
                val name = it.arguments!!.getString("playerName" ,"" )
                 val player = DataManager.data.filter { it.name == name}
                PlayerDetailScreen(player = player[0])
            }

        }
}