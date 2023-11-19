package com.dwi.vehiclesshop.data

import com.dwi.vehiclesshop.data.local.model.MotorCycle
import com.dwi.vehiclesshop.data.local.model.Purchases
import com.dwi.vehiclesshop.data.local.model.Vehicles
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import kotlinx.coroutines.flow.Flow

interface IVehiclesRepository {
    fun getVehiclesWithMotorCycle(): Flow<List<VehiclesWithMotorCycle>>

    fun getVehiclesWithCar(): Flow<List<VehiclesWithCar>>

    suspend fun purchaseVehicle(purchases: Purchases)

    suspend fun updateVehicle(vehicleId: String, quantity: Int)
}