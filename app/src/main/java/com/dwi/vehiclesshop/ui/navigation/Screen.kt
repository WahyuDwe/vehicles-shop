package com.dwi.vehiclesshop.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")

    object History : Screen("riwayat")

    object DetailItem : Screen("detailItem/{itemId}") {
        fun createRoute(itemId: String) = "detailItem/$itemId"
    }
}
