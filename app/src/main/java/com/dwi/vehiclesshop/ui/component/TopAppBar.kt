package com.dwi.vehiclesshop.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.History
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dwi.vehiclesshop.R
import com.dwi.vehiclesshop.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navHostController: NavHostController = rememberNavController(),
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.vehicles_shop),
                fontFamily = FontFamily.Monospace
            )
        },
        actions = {
            IconButton(onClick = {
                navHostController.navigate(Screen.History.route)
            }) {
                Icon(
                    imageVector = Icons.Outlined.History, contentDescription = null,
                )
            }
        }
    )
}