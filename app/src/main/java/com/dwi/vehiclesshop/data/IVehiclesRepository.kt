package com.dwi.vehiclesshop.data

import com.dwi.vehiclesshop.data.local.model.MotorCycle
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import kotlinx.coroutines.flow.Flow

interface IVehiclesRepository {
    fun getVehiclesWithMotorCycle(): Flow<List<VehiclesWithMotorCycle>>

    fun getVehiclesWithCar(): Flow<List<VehiclesWithCar>>

    fun getMotorCycle(): Flow<List<MotorCycle>>
}