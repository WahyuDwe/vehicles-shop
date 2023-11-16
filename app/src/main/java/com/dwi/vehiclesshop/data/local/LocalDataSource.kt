package com.dwi.vehiclesshop.data.local

import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import com.dwi.vehiclesshop.data.local.room.VehiclesDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val vehiclesDao: VehiclesDao) {
    fun getVehiclesWithMotorCycle(): Flow<List<VehiclesWithMotorCycle>> =
        vehiclesDao.getVehicleWithMotorCycle()

    fun getVehiclesWithCar(): Flow<List<VehiclesWithCar>> =
        vehiclesDao.getVehicleWithCar()

    fun getMotorCycle() = vehiclesDao.getMotorCycle()

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(vehiclesDao: VehiclesDao) : LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(vehiclesDao)
            }
    }
}