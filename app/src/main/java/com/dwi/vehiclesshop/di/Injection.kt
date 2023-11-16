package com.dwi.vehiclesshop.di

import android.content.Context
import com.dwi.vehiclesshop.data.VehiclesRepository
import com.dwi.vehiclesshop.data.local.LocalDataSource
import com.dwi.vehiclesshop.data.local.room.VehiclesDatabase

object Injection {
    fun provideRepository(context: Context): VehiclesRepository {
        val database = VehiclesDatabase.getInstance(context)

        val localDataSource = LocalDataSource.getInstance(database.vehiclesDao())
        return VehiclesRepository.getInstance(localDataSource)
    }
}