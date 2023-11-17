package com.dwi.vehiclesshop.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kendaraan")
data class Vehicles(
    @PrimaryKey
    @ColumnInfo(name = "id_kendaraan")
    val idVehicles: String,

    @ColumnInfo(name = "tahun_keluaran")
    val year: String,

    @ColumnInfo(name = "warna")
    val color: String,

    @ColumnInfo(name = "harga")
    val price: Int,

    @ColumnInfo(name = "stok")
    val stock: Int,

    @ColumnInfo(name = "type_id")
    val typeId: String,
)
