package com.dwi.vehiclesshop.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface VehiclesDao {
    @Transaction
    @Query("SELECT * FROM vehicles")
    fun getVehicleWithMotorCycle(): Flow<List<VehiclesWithMotorCycle>>

    @Transaction
    @Query("SELECT * FROM vehicles")
    fun getVehicleWithCar(): Flow<List<VehiclesWithCar>>
}