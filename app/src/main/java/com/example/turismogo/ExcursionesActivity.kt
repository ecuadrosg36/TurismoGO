package com.example.turismogo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_excursiones.*


class ExcursionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excursiones)

        select_date_button.setOnClickListener {
            val builder = MaterialDatePicker.Builder.datePicker()
            val picker = builder.build()
            picker.show(supportFragmentManager, picker.toString())

            picker.addOnPositiveButtonClickListener { selection ->
                // Aquí puedes manejar la fecha seleccionada
                // Por ejemplo: Toast.makeText(this, "Selected Date: $selection", Toast.LENGTH_SHORT).show()
            }
        }

        val spinner: Spinner = findViewById(R.id.Excursion_spinner)

        // Crear un ArrayAdapter usando el array de strings y un layout predeterminado para los spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.excursion_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Especificar el layout a usar cuando la lista de opciones aparece
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Aplicar el adaptador al spinner
            spinner.adapter = adapter
        }

        // Configurar el listener para el spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@ExcursionesActivity, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Otra acción cuando no se selecciona nada
            }
    }
}
}