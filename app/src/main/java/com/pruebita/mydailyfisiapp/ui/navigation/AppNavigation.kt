package com.pruebita.mydailyfisiapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pruebita.mydailyfisiapp.ui.screens.login.*
import com.pruebita.mydailyfisiapp.ui.screens.home.*
import com.pruebita.mydailyfisiapp.ui.screens.attendance.*
import com.pruebita.mydailyfisiapp.ui.screens.schedule.*
import com.pruebita.mydailyfisiapp.ui.screens.profesors.*
import com.pruebita.mydailyfisiapp.ui.screens.events.*

@Composable
fun AppNavigation(navController: NavHostController, start:String) {
    NavHost(
        navController = navController,
        startDestination = start
    ) {
        navigation(startDestination = AppScreens.StartScreen.route, route = "login"){
            composable(route = AppScreens.StartScreen.route) {
                StartScreen(navController)
            }
            composable(route = AppScreens.LoginScreen.route) {
                LoginScreen(navController)
            }
            composable(route = AppScreens.MainScreen.route){
                MainScreen(navController)
            }
        }
        navigation(startDestination = ItemMenu.HomeScreen.route, route = "main") {
            composable(route = ItemMenu.HomeScreen.route){
                HomeScreen()
            }
            composable(route = ItemMenu.AttendanceScreen.route){
                AttendanceScreen()
            }
            composable(route = ItemMenu.ScheduleScreen.route){
                ScheduleScreen()
            }
            composable(route = ItemMenu.ProfessorsScreen.route){
                ProfessorsScreen()
            }
            composable(route = ItemMenu.EventsScreen.route){
                EventsScreen()
            }
        }


    }


}