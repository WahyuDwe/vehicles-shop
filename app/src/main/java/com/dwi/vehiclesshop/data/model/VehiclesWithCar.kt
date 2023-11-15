package com.dwi.vehiclesshop.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class VehiclesWithCar (
    @Embedded
    val vehicles: Vehicles,
    @Relation(
        parentColumn = "id_kendaraan",
        entityColumn = "id_mobil",
    )
    val car: List<Car>,
)