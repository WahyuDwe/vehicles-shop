package com.dwi.vehiclesshop.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "motor")
data class MotorCycle(
    @PrimaryKey
    @ColumnInfo(name = "id_motor")
    val idMotorCycle: Int,

    @ColumnInfo(name = "mesin")
    val engine: String,

    @ColumnInfo(name ="tipe_suspensi")
    val suspensionType: String,

    @ColumnInfo(name = "tipe_transmisi")
    val transmissionType: String,
)
