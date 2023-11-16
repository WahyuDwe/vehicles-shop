package com.dwi.vehiclesshop.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dwi.vehiclesshop.data.VehiclesRepository
import com.dwi.vehiclesshop.ui.screens.car.CarViewModel
import com.dwi.vehiclesshop.ui.screens.motorcycle.MotorCyclesViewModel

class ViewModelFactory(private val repository: VehiclesRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MotorCyclesViewModel::class.java)) {
            return MotorCyclesViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CarViewModel::class.java)) {
            return CarViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}