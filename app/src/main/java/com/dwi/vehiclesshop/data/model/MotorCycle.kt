package com.dwi.vehiclesshop.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "motor")
data class MotorCycle(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_motor")
    val idMotorCycle: Long = 0,

    @ColumnInfo(name = "mesin")
    val engine: String,

    @ColumnInfo(name ="tipe_suspensi")
    val suspensionType: String,

    @ColumnInfo(name = "tipe_transmisi")
    val transmissionType: String,
)
