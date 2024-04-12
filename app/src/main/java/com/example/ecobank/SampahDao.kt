package com.example.ecobank

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface SampahDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(sampah: Sampah)
}
