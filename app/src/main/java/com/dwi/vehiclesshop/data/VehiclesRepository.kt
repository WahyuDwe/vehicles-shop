package com.dwi.vehiclesshop.data

import com.dwi.vehiclesshop.data.local.LocalDataSource
import com.dwi.vehiclesshop.data.local.model.MotorCycle
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import kotlinx.coroutines.flow.Flow

class VehiclesRepository(private val localDataSource: LocalDataSource) : IVehiclesRepository {
    override fun getVehiclesWithMotorCycle(): Flow<List<VehiclesWithMotorCycle>> {
        return localDataSource.getVehiclesWithMotorCycle()
    }

    override fun getVehiclesWithCar(): Flow<List<VehiclesWithCar>> {
        return localDataSource.getVehiclesWithCar()
    }

    override fun getMotorCycle(): Flow<List<MotorCycle>> {
        return localDataSource.getMotorCycle()
    }

    override fun getVehicleIdByMotorCycle(id: String): Flow<VehiclesWithMotorCycle> {
        return localDataSource.getVehicleIdByMotorCycle(id)
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