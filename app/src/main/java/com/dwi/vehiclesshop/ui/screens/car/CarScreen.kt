package com.dwi.vehiclesshop.ui.screens.car

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.di.Injection
import com.dwi.vehiclesshop.ui.common.UiState
import com.dwi.vehiclesshop.utils.ViewModelFactory

@Composable
fun CarScreen(
    modifier: Modifier = Modifier,
    viewModel: CarViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(context = LocalContext.current))
    )
) {
    Log.d("CarScreen", "CarScreen: ")
    viewModel.uiState.collectAsState(
        initial = UiState.Loading
    ).value.let {
        when (it) {
            is UiState.Loading -> {
                viewModel.getAllCars()
            }
            is UiState.Success -> {
                Log.d("CarScreen", "CarScreen: ${it.data}")
                val data = it.data
                CarContent(
                    cars = data,
                    modifier = modifier
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun CarContent(
    cars: List<VehiclesWithCar>,
    modifier: Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(cars) { car ->
            Log.d("CarContent", "CarContent: $car")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = car.vehicles.idVehicles.toString())
                Text(text = car.vehicles.year)
                Text(text = car.vehicles.price.toString())
                Text(text = car.vehicles.stock.toString())
                Text(text = car.vehicles.typeId.toString())
                car.car?.let {
                    Text(text = it.idCar.toString())
                    Text(text = it.engine)
                    Text(text = it.capacity.toString())
                    Text(text = it.type)
                }
            }
        }
    }
}