package com.sam.appnavigation.navigation

import android.provider.SyncStateContract.Constants
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.sam.appnavigation.navigation.detail.DetailScreen
import com.sam.appnavigation.navigation.home.HomeScreen


@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavDestination.Home.name
    ){
        composable(
            route =  NavDestination.Home.name
        ) {
            HomeScreen(onDetailClick = {navController.navigate(NavDestination.Detail.name + "/123")})
        }
        composable(
            route =  NavDestination.Detail.name + "/{userId}",
            arguments = listOf(
                navArgument("userId"){
                    type = NavType.StringType
                }
            ),

//            deepLinks = listOf(
//                navDeepLink {
//                    uriPattern = "${Constants.App.SHORT_WEB_URL}/${Constants.Value.orders}/${Constants.Value.orderId}"
//                },
//                navDeepLink {
//                    uriPattern = "${Constants.App.WEBSITE}/${Constants.Value.orders}/${Constants.Value.orderId}"
//                }
//            )
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId") ?: return@composable

            DetailScreen(
                userId = userId,
                onBackClick = {navController.popBackStack()})
        }
    }
}