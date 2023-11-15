package com.dwi.vehiclesshop.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPager(modifier: Modifier, pagerState: PagerState, content: @Composable (Int) -> Unit ) {
    androidx.compose.foundation.pager.HorizontalPager(
        state = pagerState,
        modifier = modifier.fillMaxWidth()
    ) { index ->
        content(index)
    }
}