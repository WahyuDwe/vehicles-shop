package com.dwi.vehiclesshop

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dwi.vehiclesshop.ui.component.TopBar
import com.dwi.vehiclesshop.ui.navigation.Screen
import com.dwi.vehiclesshop.ui.screens.detail.DetailItemScreen
import com.dwi.vehiclesshop.ui.screens.home.HomeScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VehiclesShopApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute == Screen.Home.route) {
                TopBar(navHostController = navController)
            }
        }, modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(modifier = modifier, navigateToDetail = { itemId ->
                    navController.navigate(Screen.DetailItem.createRoute(itemId))
                })
            }

            composable(
                Screen.DetailItem.route,
                arguments = listOf(navArgument("itemId") { type = NavType.StringType })
            ) {
                val id = it.arguments?.getString("itemId") ?: ""
                DetailItemScreen(
                    itemId = id,
                    navigateBack = { navController.navigateUp() },
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun VehiclesShopPreview() {
    VehiclesShopApp()
}