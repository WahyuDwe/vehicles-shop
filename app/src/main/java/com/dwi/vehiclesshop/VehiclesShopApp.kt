package com.dwi.vehiclesshop

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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