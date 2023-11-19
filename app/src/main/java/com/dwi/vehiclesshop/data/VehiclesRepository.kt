package com.dwi.vehiclesshop.data

import android.util.Log
import com.dwi.vehiclesshop.data.local.LocalDataSource
import com.dwi.vehiclesshop.data.local.model.MotorCycle
import com.dwi.vehiclesshop.data.local.model.Purchases
import com.dwi.vehiclesshop.data.local.model.Vehicles
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import kotlinx.coroutines.flow.Flow

class VehiclesRepository(private val localDataSource: LocalDataSource) : IVehiclesRepository {
    override fun getVehiclesWithMotorCycle(): Flow<List<VehiclesWithMotorCycle>> {
        Log.d("VehiclesRepository", "getVehiclesWithMotorCycle: ${localDataSource.getVehiclesWithMotorCycle()}")
        return localDataSource.getVehiclesWithMotorCycle()
    }

    override fun getVehiclesWithCar(): Flow<List<VehiclesWithCar>> {
        return localDataSource.getVehiclesWithCar()
    }

    override fun getPurchasesById(id: String): Flow<List<Purchases>> {
        return localDataSource.getPurchasesById(id)
    }

    override suspend fun purchaseVehicle(purchases: Purchases) {
        return localDataSource.purchaseVehicle(purchases)
    }

    override suspend fun updateVehicle(vehicleId: String, quantity: Int) {
        return localDataSource.updateVehicle(vehicleId, quantity)
    }

    companion object {
        @Volatile
        private var instance: VehiclesRepository? = null

        fun getInstance(
            localDataSource: LocalDataSource
        ): VehiclesRepository = instance ?: synchronized(this) {
            instance ?: VehiclesRepository(localDataSource)
        }
    }

}