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
import androidx.compose.ui.res.stringResource
import com.dwi.vehiclesshop.R
import com.dwi.vehiclesshop.data.local.model.TabItem
import com.dwi.vehiclesshop.ui.component.HorizontalPager
import com.dwi.vehiclesshop.ui.component.Tabs
import com.dwi.vehiclesshop.ui.component.TopBar
import com.dwi.vehiclesshop.ui.screens.car.CarScreen
import com.dwi.vehiclesshop.ui.screens.motorcycle.MotorCycleScreen

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    modifier: Modifier,
    ) {
    var state by remember { mutableIntStateOf(0) }
    val tabItems = listOf(
        TabItem(title = stringResource(R.string.mobil)),
        TabItem(title = stringResource(R.string.motor))
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
        TopBar()
        Tabs(selectedTabIndex = state, tabItems, onTabSelected = { state = it })
        HorizontalPager(modifier = modifier, pagerState = pagerState) { index ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                when (index) {
                    0 -> CarScreen()
                    1 -> MotorCycleScreen()
                }
            }

        }
    }
}