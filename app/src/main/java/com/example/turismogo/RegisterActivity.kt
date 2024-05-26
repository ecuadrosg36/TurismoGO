package com.example.turismogo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID

class CreateActivityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etName: EditText = findViewById(R.id.et_titulo)
        val etDescription: EditText = findViewById(R.id.et_description)
        val etLocation: EditText = findViewById(R.id.et_ubicacion)
        val etDate: EditText = findViewById(R.id.et_datepublicacion)
        val etPrice: EditText = findViewById(R.id.et_precio)
        val switchStatus: Switch = findViewById(R.id.sw_status)
        val btnSubmit: Button = findViewById(R.id.btn_publicar)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val description = etDescription.text.toString()
            val location = etLocation.text.toString()
            val date = etDate.text.toString()
            val price = etPrice.text.toString()
            val status = if (switchStatus.isChecked) "Disponible" else "No disponible"

            if (name.isBlank() || description.isBlank() || location.isBlank() || date.isBlank() || price.isBlank()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                val uniqueID = UUID.randomUUID().toString()
                val activity = Activity(uniqueID, name, description, location, date, price.toDouble(), status)

                // Aquí puedes manejar la lógica para guardar la actividad
                Toast.makeText(this, "Actividad registrada con éxito", Toast.LENGTH_SHORT).show()
            }
        }
    }
}