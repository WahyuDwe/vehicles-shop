package com.dwi.vehiclesshop.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dwi.vehiclesshop.data.local.model.TabItem
import com.dwi.vehiclesshop.ui.component.HorizontalPager
import com.dwi.vehiclesshop.ui.component.Tabs
import com.dwi.vehiclesshop.ui.screens.car.CarScreen
import com.dwi.vehiclesshop.ui.screens.motorcycle.MotorCycleScreen

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    modifier: Modifier,
    navigateToDetail: (String) -> Unit,
) {
    var state by remember { mutableIntStateOf(0) }
    val tabItems = listOf(
        TabItem(title = "Mobil"),
        TabItem(title = "Motor")
    )
    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(state) {
        pagerState.animateScrollToPage(state)
    }
    LaunchedEffect(pagerState.currentPage) {
        state = pagerState.currentPage
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Tabs(selectedTabIndex = state, tabItems, onTabSelected = { state = it })
        HorizontalPager(modifier = modifier, pagerState = pagerState) { index ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                when (index) {
                    0 -> CarScreen(modifier = modifier, navigateToDetail = navigateToDetail)
                    1 -> MotorCycleScreen(modifier = modifier, navigateToDetail = navigateToDetail)
                }
            }

        }
    }
}