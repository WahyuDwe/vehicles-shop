package com.dwi.vehiclesshop.ui.screens.motorcycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dwi.vehiclesshop.data.VehiclesRepository
import com.dwi.vehiclesshop.data.local.model.Purchases
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import com.dwi.vehiclesshop.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MotorCyclesViewModel(private val repository: VehiclesRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<VehiclesWithMotorCycle>>> =
        MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<List<VehiclesWithMotorCycle>>>
        get() = _uiState

    fun getAllMotorCycles() {
        viewModelScope.launch {
            repository.getVehiclesWithMotorCycle()
                .catch {
                    _uiState.value  = UiState.Error(it.message.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }

    fun purchaseVehicle(purchases: Purchases) {
        viewModelScope.launch {
            repository.purchaseVehicle(purchases)
        }
    }

    fun updateStock(vehicleId : String, quantity : Int) {
        viewModelScope.launch {
            repository.updateVehicle(vehicleId, quantity)
        }
    }
}