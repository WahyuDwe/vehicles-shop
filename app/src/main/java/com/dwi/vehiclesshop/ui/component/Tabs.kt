package com.dwi.vehiclesshop.ui.component

import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Tabs(selectedTabIndex: Int, titles: List<TabItem>, onTabSelected: (Int) -> Unit) {

    PrimaryTabRow(selectedTabIndex = selectedTabIndex) {
        titles.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                text = { Text(text = item.title, maxLines = 1) }
            )
        }
    }
}

data class TabItem(
    val title: String,
)