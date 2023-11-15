package com.dwi.vehiclesshop.data

import androidx.room.Embedded
import androidx.room.Relation

data class VehiclesWithMotorCycle(
    @Embedded
    val vehicles: Vehicles,
    @Relation(
        parentColumn = "id_kendaraan",
        entityColumn = "id_motor",
    )
    val motorCycle: List<MotorCycle>,
)
