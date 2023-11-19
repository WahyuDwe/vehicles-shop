package com.dwi.vehiclesshop.data.local

import com.dwi.vehiclesshop.data.local.model.Purchases
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import com.dwi.vehiclesshop.data.local.room.VehiclesDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val vehiclesDao: VehiclesDao) {
    fun getVehiclesWithMotorCycle(): Flow<List<VehiclesWithMotorCycle>> =
        vehiclesDao.getVehicleWithMotorCycle()

    fun getVehiclesWithCar(): Flow<List<VehiclesWithCar>> =
        vehiclesDao.getVehicleWithCar()

    fun getPurchasesById(id: String):Flow<List<Purchases>> = vehiclesDao.getQuantityById(id)

    suspend fun purchaseVehicle(purchases: Purchases) = vehiclesDao.purchaseVehicle(purchases)

    suspend fun updateVehicle(vehicleId: String, quantity: Int) {
        val vehicle = vehiclesDao.getVehicleById(vehicleId)
        vehicle.let {
            val updateStock = it.copy(stock = it.stock - quantity)
            vehiclesDao.updateVehicle(updateStock)
        }
    }

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(vehiclesDao: VehiclesDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(vehiclesDao)
            }
    }
}