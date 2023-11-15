package com.dwi.vehiclesshop

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dwi.vehiclesshop.ui.component.HorizontalPager
import com.dwi.vehiclesshop.ui.component.TabItem
import com.dwi.vehiclesshop.ui.component.Tabs
import com.dwi.vehiclesshop.ui.component.TopBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VehiclesShopApp(modifier: Modifier = Modifier) {
    var state by remember { mutableIntStateOf(0) }
    val tabItems = listOf(
        TabItem(title = "Cars"),
        TabItem(title = "Motorcycles")
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
//            when (index) {
//                0 -> CarsScreen()
//                1 -> MotorcyclesScreen()
//            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = tabItems[index].title)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun VehiclesShopPreview() {
    VehiclesShopApp()
}