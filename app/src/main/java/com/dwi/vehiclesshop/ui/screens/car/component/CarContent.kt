package com.dwi.vehiclesshop.ui.screens.car.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.ui.component.BottomSheet
import com.dwi.vehiclesshop.ui.component.MainCardContent
import com.dwi.vehiclesshop.ui.screens.car.CarViewModel


@Composable
fun CarContent(
    modifier: Modifier = Modifier,
    vehiclesWithCars: List<VehiclesWithCar>,
    viewModel: CarViewModel,
) {
    val showBottomSheet = remember { mutableStateMapOf<Int, Boolean>() }

    LazyColumn(
        contentPadding = PaddingValues(bottom = 32.dp),
    ) {
        itemsIndexed(vehiclesWithCars) { index, cars ->
            val vehicle = cars.vehicles

            MainCardContent(
                modifier = modifier,
                vehicle = vehicle,
                index = index,
                showBottomSheet = showBottomSheet,
            )
            BottomSheet(
                modifier = modifier,
                showBottomSheet = showBottomSheet,
                index = index,
                vehicle = vehicle,
                typeOfVehicle = cars,
                viewModel = viewModel,
            )
        }
    }
}