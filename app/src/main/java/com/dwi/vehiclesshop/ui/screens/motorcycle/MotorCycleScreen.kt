package com.dwi.vehiclesshop.ui.screens.motorcycle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dwi.vehiclesshop.di.Injection
import com.dwi.vehiclesshop.ui.common.UiState
import com.dwi.vehiclesshop.ui.screens.motorcycle.component.MotorCycleContent
import com.dwi.vehiclesshop.utils.ViewModelFactory

@Composable
fun MotorCycleScreen(
    modifier: Modifier = Modifier,
    viewModel: MotorCyclesViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
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
                    modifier = modifier,
                )
            }
            is UiState.Error -> {}
        }
    }

}
