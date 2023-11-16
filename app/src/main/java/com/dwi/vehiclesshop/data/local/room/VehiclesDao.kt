package com.dwi.vehiclesshop.data.local.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.dwi.vehiclesshop.data.local.model.MotorCycle
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import kotlinx.coroutines.flow.Flow

@Dao
interface VehiclesDao {
    @Transaction
    @Query("SELECT * FROM kendaraan WHERE type_id LIKE '2%'")
    fun getVehicleWithMotorCycle(): Flow<List<VehiclesWithMotorCycle>>

    @Transaction
    @Query("SELECT * FROM kendaraan WHERE type_id LIKE '1%'")
    fun getVehicleWithCar(): Flow<List<VehiclesWithCar>>

    @Query("SELECT * FROM motor")
    fun getMotorCycle(): Flow<List<MotorCycle>>

}
