package com.dwi.vehiclesshop.ui.screens.car

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dwi.vehiclesshop.di.Injection
import com.dwi.vehiclesshop.ui.common.UiState
import com.dwi.vehiclesshop.ui.screens.car.component.CarContent
import com.dwi.vehiclesshop.utils.ViewModelFactory

@Composable
fun CarScreen(
    viewModel: CarViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(context = LocalContext.current))
    ),
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
                    vehiclesWithCars = data,
                    viewModel = viewModel,
                )
            }

            is UiState.Error -> {
                // TODO: do nothing
            }
        }
    }
}
