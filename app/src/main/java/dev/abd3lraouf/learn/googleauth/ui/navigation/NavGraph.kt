package dev.abd3lraouf.learn.googleauth.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
  NavHost(navController = navHostController, startDestination = Screen.Login.route) {
    addLoginGraph(this, navHostController)
    addHomeGraph(this, navHostController)
  }
}

fun addHomeGraph(navGraphBuilder: NavGraphBuilder, navHostController: NavHostController) {
  navGraphBuilder.addHomeScreen(navHostController)
}

fun NavGraphBuilder.addHomeScreen(navHostController: NavHostController) {
  composable(Screen.Home.route) {

  }
}

fun addLoginGraph(navGraphBuilder: NavGraphBuilder, navHostController: NavHostController) {
  navGraphBuilder.addLoginScreen(navHostController)
}

fun NavGraphBuilder.addLoginScreen(navHostController: NavHostController) {
  composable(Screen.Login.route) {}
}
