package com.example.ecobank

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SetorSampah : AppCompatActivity() {
    private lateinit var editTextNama: EditText
    private lateinit var editTextKategori: EditText
    private lateinit var editTextBerat: EditText
    private lateinit var editTextHarga: EditText
    private lateinit var editTextTanggal: EditText
    private lateinit var editTextAlamat: EditText
    private lateinit var editTextCatatan: EditText
    private lateinit var buttonSetor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setor_sampah)

        editTextNama = findViewById(R.id.editTextNama)
        editTextKategori = findViewById(R.id.editTextKategori)
        editTextBerat = findViewById(R.id.editTextBerat)
        editTextHarga = findViewById(R.id.editTextHarga)
        editTextTanggal = findViewById(R.id.editTextTanggal)
        editTextAlamat = findViewById(R.id.editTextAlamat)
        editTextCatatan = findViewById(R.id.editTextCatatan)
        buttonSetor = findViewById(R.id.buttonSetor)

        buttonSetor.setOnClickListener {
            val nama = editTextNama.text.toString()
            val kategori = editTextKategori.text.toString()
            val berat = editTextBerat.text.toString().toDouble()
            val harga = editTextHarga.text.toString().toDouble()
            val tanggal = editTextTanggal.text.toString()
            val alamat = editTextAlamat.text.toString()
            val catatan = editTextCatatan.text.toString()

            val sampah = Sampah(nama, kategori, berat, harga, tanggal, alamat, catatan)

            val sampahDatabase = SampahDatabase.getInstance(this)
            CoroutineScope(Dispatchers.IO).launch {
                sampahDatabase?.sampahDao()?.insert(sampah)
            }

            Toast.makeText(this, "Data sampah berhasil disimpan", Toast.LENGTH_SHORT).show()
        }
    }
}
