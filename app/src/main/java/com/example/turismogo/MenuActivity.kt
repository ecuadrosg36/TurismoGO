package com.example.turismogo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.turismogo.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExcursions.setOnClickListener {
            startActivity(Intent(this, ExcursionesActivity::class.java))
        }
        binding.btnHistorialActividades.setOnClickListener {
            startActivity(Intent(this, historial_actividades::class.java))
        }
        binding.btnHistorialUsuarios.setOnClickListener {
            startActivity(Intent(this, historial_usuarios::class.java))
        }
        binding.btnHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        binding.btnResumenExcursion.setOnClickListener {
            startActivity(Intent(this, ResumenExcursionActivity::class.java))
        }
    }
}
