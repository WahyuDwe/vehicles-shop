package com.dwi.vehiclesshop.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.dwi.vehiclesshop.data.model.VehiclesWithCar
import com.dwi.vehiclesshop.data.model.VehiclesWithMotorCycle
import kotlinx.coroutines.flow.Flow

@Dao
interface VehiclesDao {
    @Transaction
    @Query("SELECT * FROM kendaraan")
    fun getVehicleWithMotorCycle(): Flow<List<VehiclesWithMotorCycle>>

    @Transaction
    @Query("SELECT * FROM kendaraan")
    fun getVehicleWithCar(): Flow<List<VehiclesWithCar>>
}