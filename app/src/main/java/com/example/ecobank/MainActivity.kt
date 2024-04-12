package com.example.ecobank

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class  MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button_jenis = findViewById<Button>(R.id.jenis_sampah)

        button_jenis.setOnClickListener {
            val intent = Intent(this@MainActivity, JenisSampah::class.java)
            startActivity(intent)
        }

        val button_setor = findViewById<Button>(R.id.setor_sampah)

        button_setor.setOnClickListener {
            val intent = Intent(this@MainActivity, SetorSampah::class.java)
            startActivity(intent)
        }
    }
}