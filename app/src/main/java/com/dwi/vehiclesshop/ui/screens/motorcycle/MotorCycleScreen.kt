package com.dwi.vehiclesshop.ui.screens.motorcycle

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
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import com.dwi.vehiclesshop.di.Injection
import com.dwi.vehiclesshop.ui.common.UiState
import com.dwi.vehiclesshop.utils.ViewModelFactory

@Composable
fun MotorCycleScreen(
    modifier: Modifier,
    viewModel: MotorCyclesViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    )
) {
    viewModel.uiState.collectAsState(
        initial = UiState.Loading
    ).value.let {
        when (it) {
            is UiState.Loading -> {
                viewModel.getAllMotorCycles()
            }
            is UiState.Success -> {
                val data = it.data
                MotorCycleContent(
                    motorCycles = data,
                    modifier = modifier
                )
            }
            is UiState.Error -> {}
        }
    }

}

@Composable
fun MotorCycleContent(
    motorCycles: List<VehiclesWithMotorCycle>,
    modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(motorCycles) { motorCycle ->
            Log.d("CarContent", "CarContent: $motorCycle")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "id vehicles : ${motorCycle.vehicles.idVehicles}")
                Text(text = "tahun : ${motorCycle.vehicles.year}")
                Text(text = "harga : ${motorCycle.vehicles.price}")
                Text(text = "stok : ${motorCycle.vehicles.stock}")
                Text(text = "typeId : ${motorCycle.vehicles.typeId}")
                motorCycle.motorCycle?.let {
                    Text(text = it.idMotorCycle.toString())
                    Text(text = it.engine)
                    Text(text = it.transmissionType)
                    Text(text = it.suspensionType)
                }
            }
        }
    }
}
