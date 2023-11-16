package com.dwi.vehiclesshop.ui.component

import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import com.dwi.vehiclesshop.data.local.model.TabItem

@Composable
fun Tabs(selectedTabIndex: Int, titles: List<TabItem>, onTabSelected: (Int) -> Unit) {

    PrimaryTabRow(selectedTabIndex = selectedTabIndex) {
        titles.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        text = item.title,
                        maxLines = 1,
                        fontFamily = FontFamily.Monospace
                    )
                }
            )
        }
    }
}

