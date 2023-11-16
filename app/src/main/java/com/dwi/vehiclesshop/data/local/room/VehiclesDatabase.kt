package com.dwi.vehiclesshop.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dwi.vehiclesshop.data.local.model.Car
import com.dwi.vehiclesshop.data.local.model.MotorCycle
import com.dwi.vehiclesshop.data.local.model.Vehicles

@Database(
    entities = [
        Vehicles::class,
        Car::class,
        MotorCycle::class,
    ], version = 1, exportSchema = false
)
abstract class VehiclesDatabase() : RoomDatabase() {
    abstract fun vehiclesDao(): VehiclesDao

    companion object {
        @Volatile
        private var INSTANCE: VehiclesDatabase? = null

        fun getInstance(context: Context): VehiclesDatabase = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                VehiclesDatabase::class.java,
                "Sample.db"
            )
                .fallbackToDestructiveMigration()
                .createFromAsset("vehicles_int.db")
                .build()
            INSTANCE = instance
            instance
        }

    }
}