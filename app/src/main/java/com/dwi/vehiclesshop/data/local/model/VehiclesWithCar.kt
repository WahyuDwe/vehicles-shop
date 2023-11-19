package com.dwi.vehiclesshop.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class VehiclesWithCar (
    @Embedded
    val vehicles: Vehicles,

    @Relation(
        parentColumn = "type_id",
        entityColumn = "id_mobil",
    )

    val car: Car? = null,
)