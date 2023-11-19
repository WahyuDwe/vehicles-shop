package com.dwi.vehiclesshop.ui.screens.motorcycle.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import com.dwi.vehiclesshop.ui.component.BottomSheet
import com.dwi.vehiclesshop.ui.component.MainCardContent
import com.dwi.vehiclesshop.ui.screens.motorcycle.MotorCyclesViewModel

@Composable
fun MotorCycleContent(
    modifier: Modifier = Modifier,
    vehiclesWithMotorCycles: List<VehiclesWithMotorCycle>,
    viewModel: MotorCyclesViewModel,
) {
    val showBottomSheet = remember { mutableStateMapOf<Int, Boolean>() }

    LazyColumn(
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        itemsIndexed(vehiclesWithMotorCycles) { index, motorCycles ->
            val vehicle = motorCycles.vehicles

            MainCardContent(
                modifier = modifier,
                vehicle = vehicle,
                index = index,
                showBottomSheet = showBottomSheet,
                viewModel = viewModel,
            )
            BottomSheet(
                modifier = modifier,
                showBottomSheet = showBottomSheet,
                index = index,
                vehicle = vehicle,
                typeOfVehicle = motorCycles,
                viewModel = viewModel,

                )
        }
    }
}