package com.dwi.vehiclesshop.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class VehiclesWithMotorCycle(
    @Embedded
    val vehicles: Vehicles,

    @Relation(
        parentColumn = "type_id",
        entityColumn = "id_motor",
    )

    val motorCycle: MotorCycle? = null,
)
