package com.dwi.vehiclesshop.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.dwi.vehiclesshop.data.local.model.MotorCycle
import com.dwi.vehiclesshop.data.local.model.Purchases
import com.dwi.vehiclesshop.data.local.model.Vehicles
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import kotlinx.coroutines.flow.Flow

@Dao
interface VehiclesDao {
    @Transaction
    @Query("SELECT * FROM kendaraan WHERE type_id LIKE 'MR%'")
    fun getVehicleWithMotorCycle(): Flow<List<VehiclesWithMotorCycle>>

    @Transaction
    @Query("SELECT * FROM kendaraan WHERE type_id LIKE 'MB%'")
    fun getVehicleWithCar(): Flow<List<VehiclesWithCar>>

    @Transaction
    @Query("SELECT * FROM kendaraan WHERE id_kendaraan = :id")
    suspend fun getVehicleById(id: String): Vehicles

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun purchaseVehicle(purchases: Purchases)

    @Update
    suspend fun updateVehicle(vehicles: Vehicles)
}
