package com.dwi.vehiclesshop.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mobil")
data class Car(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_mobil")
    val idCar: String,

    @ColumnInfo(name = "mesin")
    val engine: String,

    @ColumnInfo(name ="kapasitas_penumpang")
    val capacity: Int,

    @ColumnInfo(name = "tipe")
    val type: String,
)
