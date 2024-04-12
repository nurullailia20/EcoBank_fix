package com.example.ecobank

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Sampah::class], version = 1, exportSchema = false)
abstract class SampahDatabase : RoomDatabase() {
    abstract fun sampahDao(): SampahDao

    companion object {
        @Volatile
        private var INSTANCE: SampahDatabase? = null

        fun getInstance(context: Context): SampahDatabase? {
            if (INSTANCE == null) {
                synchronized(SampahDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        SampahDatabase::class.java,
                        "sampah_database"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}
