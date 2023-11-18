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
) {
    HomeScreen(modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun VehiclesShopPreview() {
    VehiclesShopApp()
}