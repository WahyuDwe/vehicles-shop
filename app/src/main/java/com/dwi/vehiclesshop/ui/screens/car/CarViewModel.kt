package com.dwi.vehiclesshop.ui.screens.car

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dwi.vehiclesshop.data.VehiclesRepository
import com.dwi.vehiclesshop.data.local.model.Purchases
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CarViewModel(private val repository: VehiclesRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<VehiclesWithCar>>> = MutableStateFlow(UiState.Loading)

    val uiState: MutableStateFlow<UiState<List<VehiclesWithCar>>>
        get() = _uiState

    fun getAllCars() {
        viewModelScope.launch {
            repository.getVehiclesWithCar()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    Log.d("CarViewModel", "getAllCars: $it")
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