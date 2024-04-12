package com.example.ecobank

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sampah_table")
data class Sampah(
    val nama: String,
    val kategori: String,
    val berat: Double,
    val harga: Double,
    val tanggal: String,
    val alamat: String,
    val catatan: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
