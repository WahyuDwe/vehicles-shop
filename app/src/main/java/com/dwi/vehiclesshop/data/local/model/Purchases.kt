package com.dwi.vehiclesshop.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pembelian")
data class Purchases(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_pembelian")
    val idPurchases: Int = 0,

    @ColumnInfo(name = "id_kendaraan")
    val idVehicle: String,

    @ColumnInfo(name = "id_tipe_kendaraan")
    val idTypeOfVehicle: String,

    @ColumnInfo(name = "jumlah_pembelian")
    val total: Int,

    @ColumnInfo(name = "harga_total")
    val totalPrice: Int,
)
