package com.dwi.vehiclesshop.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kendaraan")
data class Vehicles(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_kendaraan")
    val idVehicles: Long = 0,

    @ColumnInfo(name = "tahun_keluaran")
    val year: String,

    @ColumnInfo(name = "warna")
    val color: String,

    @ColumnInfo(name = "harga")
    val price: Int,

    @ColumnInfo(name = "stok")
    val stock: Int,

    @ColumnInfo(name = "type_id")
    val typeId: Long,
)
