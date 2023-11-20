package com.example.dronamanagercompanion.navigations

sealed class Screen(val route:String){
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Team : Screen("team_screen")
    object Result : Screen("result_screen")
}
